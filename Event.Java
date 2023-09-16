package bs.untitled10;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Event implements Listener {
    public static Map<UUID, Boolean> ColdTime = new HashMap<>();
    public static Map<Player, Boolean> PlayerSneaking = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        UUID playerId = player.getUniqueId();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(PlayerSneaking.getOrDefault(player, false)){
                if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "玄鐵重劍")){
                    player.sendMessage("hey");
                    if(ColdTime.getOrDefault(playerId, false) == false){
                        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
                        mainHandItem.getItemMeta().addEnchant(Enchantment.KNOCKBACK, 1, true);

                        ColdTime.put(playerId, true);
                        //冷卻開始
                        coldTimer(LocalTime.now(), playerId, 20);
                        timer(LocalTime.now(), playerId, 5);
                        player.sendMessage(ChatColor.GREEN + "玄鐵重劍技能啟動成功");

                    }
                    else{
                        player.sendMessage(ChatColor.RED + "尚在冷卻時間");
                    }
                }
                else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("忘憂劍")) {
                }
            }
        }

    }
    @EventHandler
    public void sneaking(PlayerToggleSneakEvent e){
        Player player = e.getPlayer();
        if(e.isSneaking()){
            PlayerSneaking.put(player, true);
            player.sendMessage("進入潛行");
        }
        else {
            PlayerSneaking.put(player, false);
            player.sendMessage("退出潛行");
        }
    }

    
    public void timer(LocalTime time, UUID playerId, Integer continueTime){
        int startTime = time.getSecond();
        if(LocalTime.now().getSecond() - startTime == continueTime){
            ItemMeta mainHandItem = Bukkit.getPlayer(playerId).getInventory().getItemInMainHand().getItemMeta();
            if(mainHandItem.getDisplayName().equals("玄鐵重劍")){
                mainHandItem.removeEnchant(Enchantment.KNOCKBACK);
            }
        }
    }

    public void coldTimer(LocalTime time, UUID playerId, Integer coldTime){
        int startTime = time.toSecondOfDay();
       if(LocalTime.now().getSecond() - startTime == coldTime){
            ColdTime.put(playerId, false);
            //冷卻結束
            Bukkit.getPlayer(playerId).sendMessage(ChatColor.GREEN + "技能冷卻結束");
        }
    }
}
