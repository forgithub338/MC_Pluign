package bs.untitled10.impl.listener.sendItem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ForAllListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getView().getTitle().equals("send")){
            Inventory gui = e.getInventory();
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "送出")){
                for(Player player : Bukkit.getOnlinePlayers()){
                    for(ItemStack item : gui.getContents()){
                        if(item != null && item.hasItemMeta()){
                            if(!(item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "送出"))){
                                player.getInventory().addItem(item);
                            }
                        }
                    }
                }
                e.setCancelled(true);
                e.getWhoClicked().closeInventory();
            }
        }
    }
}

