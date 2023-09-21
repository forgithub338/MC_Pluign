package bs.untitled10.Utils.Advancement;

import bs.untitled10.Main;
import bs.untitled10.Utils.SubPlugin;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class Advancement implements SubPlugin {
    private static final Pattern KEY_REGEX_PATTERN = Pattern.compile("[^A-Za-z0-9_]");
    private JavaPlugin mainPlugin;
    @Override
    public void onEnable(JavaPlugin plugin) {
        Bukkit.getLogger().info("======= Loading Advancement Plugin =======");
        mainPlugin = plugin;

        cleanAdvancements();

        ArrayList<String> avmOrder = new ArrayList<>(Arrays.asList("root", "child", "child2"));
        avmOrder.forEach((name) -> {
            try {
                loadAdvancement(name);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Bukkit.reloadData();

        Bukkit.getLogger().info("======= Advancement Plugin Enabled =======");
    }
    @SuppressWarnings("deprecation")
    private void cleanAdvancements() {
        Iterator<org.bukkit.advancement.Advancement> advancements = Bukkit.advancementIterator();
        while (advancements.hasNext()) {
            NamespacedKey namespacedKey = advancements.next().getKey();
            if ("Main".equals(namespacedKey.getNamespace())) {
                Bukkit.getUnsafe().removeAdvancement(namespacedKey);
            }
        }
        Bukkit.reloadData();
    }
    @SuppressWarnings("deprecation")
    private void loadAdvancement(String advancementName) throws IOException {
        String jsonFilePath = String.format("advancements/%s.json", advancementName);
        String key = KEY_REGEX_PATTERN.matcher(advancementName).replaceAll("").toLowerCase();
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
