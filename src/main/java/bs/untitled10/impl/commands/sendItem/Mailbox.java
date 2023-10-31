package bs.untitled10.impl.commands.sendItem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Mailbox implements CommandExecutor {

    private static JavaPlugin plugin;
    public static Map<UUID, Inventory> playerGUIs = new HashMap<>();
    public static Map<UUID, Boolean> renew = new HashMap<>();

    public Mailbox(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)){
            return false;
        }
        if(command.getName().equals("myMailbox")){
            Player player = (Player) commandSender;
            UUID playerId = player.getUniqueId();
            Inventory mailbox = loadMailbox(playerId);
            player.openInventory(mailbox);

        }

        return false;
    }

    @Nullable
    public static Inventory loadMailbox(UUID playerId) {
        String playerString = playerId.toString();
        Player player = Bukkit.getPlayer(playerId);
        File file = new File(plugin.getDataFolder(), "mailbox.yml");
        FileConfiguration GUIconfig = YamlConfiguration.loadConfiguration(file);

        ConfigurationSection guiSection = GUIconfig.getConfigurationSection(playerString);
        if (guiSection == null || !guiSection.isList("contents")) {
            return null; // If GUI data is not found, return null
        }

        List<?> rawContents = guiSection.getList("contents");
        List<Map<String, Object>> serializedContents = new ArrayList<>();

        for (Object obj : rawContents) {
            if (obj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> itemMap = (Map<String, Object>) obj;
                serializedContents.add(itemMap);
            }
        }

        Inventory GUI = Bukkit.createInventory(player, 27, "mailbox"); // Replace with your GUI title

        for (Map<String, Object> itemMap : serializedContents) {
            int slot = (int) itemMap.get("slot");
            ItemStack itemStack = (ItemStack) itemMap.get("item");

            if (slot >= 0 && slot < GUI.getSize()) {
                GUI.setItem(slot, itemStack);
            }
        }

        return GUI;
    }
}
