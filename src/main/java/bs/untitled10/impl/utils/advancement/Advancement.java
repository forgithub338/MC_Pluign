package bs.untitled10.impl.utils.advancement;

import bs.untitled10.impl.utils.SubPlugin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Map;
import java.lang.String;

public final class Advancement implements SubPlugin {
    private JavaPlugin mainPlugin;
    @Override
    public void onEnable(JavaPlugin plugin) {
        Bukkit.getLogger().info("======= Loading advancement plugin =======");
        mainPlugin = plugin;

        cleanAdvancements();

        Gson gson = new GsonBuilder().create();
        try {
            mainPlugin.saveResource("advancementTree.json", true);
            BufferedReader reader = new BufferedReader(new FileReader(new File(mainPlugin.getDataFolder(), "advancementTree.json")));
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            reader.close();

            Bukkit.getLogger().info("======= Start loading advancement tree =======");

            processTree(jsonObject, 1);

            Bukkit.getLogger().info("======= finish loading advancement tree =======");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Bukkit.reloadData();

        Bukkit.getLogger().info("======= Advancement plugin enabled =======");
    }

    @SuppressWarnings("deprecation")
    private void cleanAdvancements() {
        Bukkit.getLogger().info("======= Start cleaning old advancements =======");
        int cleanedCount = 0;
        Iterator<org.bukkit.advancement.Advancement> advancements = Bukkit.advancementIterator();
        while (advancements.hasNext()) {
            NamespacedKey namespacedKey = advancements.next().getKey();
            if ("Main".equals(namespacedKey.getNamespace())) {
                Bukkit.getUnsafe().removeAdvancement(namespacedKey);
                cleanedCount++;
            }
        }
        Bukkit.reloadData();
        Bukkit.getLogger().info("======= Cleaned " + cleanedCount + " advancements =======");
    }

    private void processTree(JsonObject jsonObject, int depth) throws IOException {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()){
            String key = entry.getKey();
            Bukkit.getLogger().info(">".repeat(depth) + key);
            loadAdvancement(key);
            JsonElement value = entry.getValue();
            if (value.isJsonObject()) processTree(value.getAsJsonObject(), ++depth);
        }
    }

    @SuppressWarnings("deprecation")
    private void loadAdvancement(String key) throws IOException {
        String jsonFilePath = String.format("advancements/%s.json", key);
        mainPlugin.saveResource(jsonFilePath, true);
        String advancementJSON = new String(Files.readAllBytes(new File(mainPlugin.getDataFolder(), jsonFilePath).toPath()));
        Bukkit.getUnsafe().loadAdvancement(new NamespacedKey(mainPlugin, key), advancementJSON);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().info("======= Advancement Plugin Disabled =======");
    }
}