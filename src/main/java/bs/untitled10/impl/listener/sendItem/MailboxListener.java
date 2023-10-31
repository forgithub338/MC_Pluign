package bs.untitled10.impl.listener.sendItem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MailboxListener implements Listener {
    private static JavaPlugin plugin;
    public static Map<UUID, Inventory> playerGUIs = new HashMap<>();
    public static Map<UUID, Boolean> renew = new HashMap<>();

    public MailboxListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        if(e.getView().getTitle().equals("mailbox")){
            UUID playerId = e.getPlayer().getUniqueId();
            Inventory mailbox = e.getInventory();
            saveMailbox(playerId, mailbox);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getView().getTitle().equals("mailbox")){
            Player player = (Player) e.getWhoClicked();
            Inventory mailbox = e.getInventory();
            ItemStack currentItem = e.getCurrentItem();
            e.setCancelled(true);
            if(currentItem != null){
                if(hasEmptySlots(player)){
                    player.getInventory().addItem(currentItem);
                    mailbox.remove(currentItem);
                }
                else{
                    player.sendMessage(ChatColor.RED + "你的背包已滿");
                }
            }
        }
    }

    public void saveMailbox(UUID playerId, Inventory GUI) {
        String playerString = playerId.toString();
        File file = new File(plugin.getDataFolder(), "mailbox.yml");
        FileConfiguration GUIconfig = YamlConfiguration.loadConfiguration(file);

        ConfigurationSection guiSection = GUIconfig.createSection(playerString);
        ItemStack[] contents = GUI.getContents();
        List<Map<String, Object>> serializedContents = new ArrayList<>();

        for (int i = 0; i < contents.length; i++) {
            if (contents[i] != null) {
                Map<String, Object> itemMap = new HashMap<>();
                itemMap.put("slot", i);
                itemMap.put("item", contents[i]);
                serializedContents.add(itemMap);
            }
        }

        guiSection.set("contents", serializedContents);

        try {
            GUIconfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasEmptySlots(Player player) {
        ItemStack[] contents = player.getInventory().getContents();

        for (ItemStack item : contents) {
            if (item == null) {
                return true; // 发现一个空位，返回 true
            }
        }

        return false; // 所有槽位都已满，返回 false
    }

}
