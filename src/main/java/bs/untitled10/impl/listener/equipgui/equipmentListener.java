package bs.untitled10.impl.listener.equipgui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nullable;
import java.util.UUID;

import static bs.untitled10.impl.commands.equipgui.equipment.*;

public class equipmentListener implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        if(e.getView().getTitle().equals("equip")){
            Player player = (Player) e.getPlayer();
            UUID playerId = e.getPlayer().getUniqueId();
            Inventory GUI = e.getInventory();

            saveGUI(playerId, GUI);
            playerGUIs.put(playerId, GUI);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        @Nullable String itemName = e.getCurrentItem().getItemMeta().getDisplayName();
        Player player = (Player) e.getWhoClicked();
        UUID playerId = player.getUniqueId();
        boolean lock = lockMap.getOrDefault(playerId, true);
        if(e.getView().getTitle().equals("equip")){
            if(lock){
                //上鎖狀態
                if(e.getCurrentItem() == null){
                    return;
                }

                if(itemName.equals("解鎖")){
                    e.setCancelled(true);
                    player.closeInventory();
                    lockMap.put(playerId, false);
                    player.sendMessage(ChatColor.GREEN + "解鎖成功");
                    player.performCommand("openGUI");
                }
                else{
                    //亂點
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "尚未解鎖，請先解鎖再執行此動作");
                }
            }

            else{
                //解鎖狀態
                if(e.getCurrentItem() == null){
                    return;
                }

                if (itemName.equals("結算並上鎖")) {
                    e.setCancelled(true);
                    player.closeInventory();
                    lockMap.put(playerId, true);
                    Inventory GUI = e.getInventory();
                    saveGUI(playerId, GUI);
                    playerGUIs.put(playerId, GUI);
                    player.sendMessage(ChatColor.GREEN + "上鎖成功");
                }
                else if(itemName.equals(ChatColor.RED + "不可使用區域")){
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "不是說不能用了嗎");
                }
            }
        }
    }
}
