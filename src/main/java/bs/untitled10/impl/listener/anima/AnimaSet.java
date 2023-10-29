package bs.untitled10.impl.listener.anima;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.UUID;

import static bs.untitled10.impl.listener.PlayerJoinOrQuit.*;

public class AnimaSet implements Listener {
    private final JavaPlugin plugin;
    public AnimaSet(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        UUID playerId = e.getPlayer().getUniqueId();
        Integer anima = PlayerAnima.getOrDefault(playerId, 0);
        PlayerJoin.remove(playerId);
        saveAnima_2(playerId, anima);
    }

    //殺生物
    @EventHandler
    public void onPlayerKillEntity(EntityDeathEvent e){
        if(!(e.getEntity().getKiller() instanceof Player)){
            return;
        }
        Player killer = e.getEntity().getKiller();
        UUID playerId = killer.getUniqueId();
        Integer anima = PlayerAnima.getOrDefault(playerId, 0);
        killer.sendMessage(ChatColor.WHITE + "奪取靈氣，靈氣值+1");

        PlayerAnima.put(playerId, anima+1);
        saveAnima_2(playerId, anima+1);
    }

    //食靈丹
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent e){
        Player consumer = e.getPlayer();
        UUID playerId = consumer.getUniqueId();
        Integer anima = PlayerAnima.getOrDefault(playerId, 0);
        if(e.getItem().getItemMeta().getDisplayName().equals("靈氣丹")){
            consumer.getInventory().remove(e.getItem());
            consumer.sendMessage("食用靈丹，靈氣值+1");
        }
        PlayerAnima.put(playerId, anima+1);
        saveAnima_2(playerId, anima+1);

    }

    //固定獲得
    public static void timeUpdateAnima(){
        for (Player player: Bukkit.getOnlinePlayers()){
            UUID playerId = player.getUniqueId();
            Integer second = PlayerJoin.get(playerId);
            if(LocalTime.now().getMinute() == PlayerTime.get(playerId)){
                return;
            }
            if(!(LocalTime.now().getSecond() == second)){
                return;
            }
            player.sendMessage("靈氣入體，靈氣值+1");
            Integer anima = PlayerAnima.getOrDefault(playerId, 0);
            PlayerAnima.put(playerId, anima+1);

        }
    }

    public void saveAnima_2(UUID playerId, Integer anima){
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
}
