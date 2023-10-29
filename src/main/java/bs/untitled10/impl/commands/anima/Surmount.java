package bs.untitled10.impl.commands.anima;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import static bs.untitled10.impl.listener.PlayerJoinOrQuit.PlayerAnima;
import static bs.untitled10.impl.listener.PlayerJoinOrQuit.PlayerRealms;
public class Surmount implements CommandExecutor {

    private final JavaPlugin plugin;
    public Surmount(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)){
            return false;
        }
        Player player = (Player) commandSender;
        UUID playerId = player.getUniqueId();
        Integer anima = PlayerAnima.getOrDefault(playerId, 0);
        Integer realms = PlayerRealms.getOrDefault(playerId, 0);

        if(command.getName().equals("surmount")){
            Integer want_realm = realms + 1;
            if(want_realm <= 10) {
                //練氣 or 築基劫
                if(want_realm < 10){
                    if (anima >= 10 * want_realm) {
                        player.sendMessage("開始突破練氣" + want_realm + "層");
                        player.performCommand("particle");
                        Random random = new Random();
                        if(random.nextDouble() > 0.05){
                            player.sendMessage(ChatColor.GREEN +  "突破成功，恭喜晉升練氣" + want_realm + "層");
                            PlayerRealms.put(playerId, want_realm);
                        }
                        else {
                            player.sendMessage(ChatColor.RED + "突破失敗");
                            return true;
                        }

                    }
                    else{
                        player.sendMessage(ChatColor.RED + "靈氣不足，無法突破");
                        return true;
                    }
                }
                else{
                    //築基劫
                    if(anima > 10*want_realm){
                        player.sendMessage("開始渡築基劫");
                        PlayerRealms.put(playerId, want_realm);
                        saveRealms_2(playerId, want_realm);
                    }
                }
            }
        }
        return true;
    }

    public void saveRealms_2(UUID playerId, Integer realms){
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




}
