package bs.untitled10.impl.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class PlayerJoinOrQuit implements Listener {

    private final JavaPlugin plugin;
    public PlayerJoinOrQuit(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static Map<UUID, Integer> PlayerRealms = new HashMap<>();
    public static Map<UUID, Integer> PlayerAnima = new HashMap<>();
    public static Map<UUID, Integer> PlayerJoin = new HashMap<>();

    public static Map<UUID, Integer> PlayerTime = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        UUID playerId = player.getUniqueId();

        //境界
        Integer playerRealm = loadRealms(playerId);
        PlayerRealms.put(playerId, playerRealm);
        player.sendMessage(ChatColor.AQUA + "當前境界:練氣" + playerRealm + "層");


        //靈氣
        Integer playerAnima = loadAnima(playerId);
        PlayerAnima.put(playerId, loadAnima(playerId));
        player.sendMessage(ChatColor.AQUA + "當前靈氣值:" + playerAnima);

        //計時器
        Integer minute = LocalTime.now().getMinute();
        Integer second = LocalTime.now().getSecond();
        System.out.println("second" + second);
        PlayerJoin.put(playerId, second);
        PlayerTime.put(playerId, minute);

        //playerList & mailbox
        if(!loadPlayer(playerId)){
            player.sendMessage("first join");
            savePlayer(playerId, player);

            Inventory GUI = Bukkit.createInventory(player, 27, "mailbox");
            saveMailbox(playerId, GUI);

        }



    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        UUID playerId = player.getUniqueId();

        //境界
        saveRealms(playerId, PlayerRealms.getOrDefault(playerId, 0));

        //靈氣
        Integer anima = PlayerAnima.getOrDefault(playerId, 0);
        saveAnima(playerId, anima);

        //計時器
        PlayerJoin.remove(playerId);
        PlayerTime.remove(playerId);


    }


    //境界
    public Integer loadRealms(UUID playerId){
        File file = new File(plugin.getDataFolder(), "realms.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String playerString = playerId.toString();

        if(config.contains(playerString)){
            return config.getInt(playerString);
        }
        return 0;

    }

    public void saveRealms(UUID playerId, Integer realms){
        File file = new File(plugin.getDataFolder(), "realms.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String playerString = playerId.toString();

        config.set(playerString, realms);


        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //靈氣
    public Integer loadAnima(UUID playerId){
        File file = new File(plugin.getDataFolder(), "anima.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String playerString = playerId.toString();

        if(config.contains(playerString)){
            return config.getInt(playerString);
        }
        return 0;

    }

    public void saveAnima(UUID playerId, Integer anima){
        File file = new File(plugin.getDataFolder(), "anima.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String playerString = playerId.toString();

        config.set(playerString, anima);


        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loadPlayer(UUID playerId){
        File file = new File(plugin.getDataFolder(), "playerList.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String playerString = playerId.toString();
        if(!config.contains(playerString)){
            return false;
        }
        return true;
    }

    public void savePlayer(UUID playerId, Player player){
        File file = new File(plugin.getDataFolder(), "playerList.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String playerString = playerId.toString();
        String playerName = player.toString();
        config.set(playerString, playerName);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
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

}
