package bs.untitled10.impl.commands.equipgui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class equipment implements CommandExecutor, Listener {
    private static JavaPlugin plugin;

    public equipment(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public static Map<UUID, Boolean> lockMap = new HashMap<>();
    public static Map<UUID, Inventory> playerGUIs = new HashMap<>();

    private ItemStack wool;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(command.getName().equals("openGUI")){
            if(!(commandSender instanceof Player)){
                return false;
            }
            Player player = (Player) commandSender;
            UUID playerId = player.getUniqueId();
            boolean lock = lockMap.getOrDefault(playerId, true);
            @Nullable Inventory GUI = playerGUIs.get(playerId);

            if(GUI == null){
                GUI = loadGUI(playerId);
                if (GUI == null){
                    GUI = Bukkit.createInventory(Bukkit.getPlayer(playerId), 54,"equip");
                }
            }

            if(lock){
                //上鎖 綠
                wool = new ItemStack(Material.GREEN_WOOL);
                ItemMeta woolMeta = wool.getItemMeta();
                woolMeta.setDisplayName("解鎖");
                woolMeta.setLore(Arrays.asList("點擊以解鎖裝備欄"));
                wool.setItemMeta(woolMeta);
            }
            else {
                //解鎖 紅
                wool = new ItemStack(Material.RED_WOOL);
                ItemMeta woolMeta = wool.getItemMeta();
                woolMeta.setDisplayName("結算並上鎖");
                woolMeta.setLore(Arrays.asList("點擊以上鎖裝備欄"));
                wool.setItemMeta(woolMeta);
            }

            ItemStack notUse = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta notUseData = notUse.getItemMeta();
            notUseData.setDisplayName(ChatColor.RED + "不可使用區域");
            notUseData.setLore(Arrays.asList(ChatColor.RED + "別用裝備區存物品喔!!"));
            notUse.setItemMeta(notUseData);


            for(int i=0;i<=52;i++) {
                switch (i){
                    case 7:
                    case 8:
                    case 13:
                    case 17:
                    case 22:
                    case 29:
                    case 31:
                    case 33:
                    case 36:
                    case 40:
                    case 45:
                    case 46:
                        continue;
                    default:
                        GUI.setItem(i, notUse);
                }
            }
            GUI.setItem(53, wool);

            ((Player) commandSender).openInventory(GUI);
        }
        return true;
    }

    public static void saveGUI(UUID playerId, Inventory GUI) {
        String playerString = playerId.toString();
        File file = new File(plugin.getDataFolder(), "equipGUI.yml");
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


    @Nullable
    public static Inventory loadGUI(UUID playerId) {
        String playerString = playerId.toString();
        Player player = Bukkit.getPlayer(playerId);
        File file = new File(plugin.getDataFolder(), "equipGUI.yml");
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

        Inventory GUI = Bukkit.createInventory(player, 54, "equip"); // Replace with your GUI title

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
