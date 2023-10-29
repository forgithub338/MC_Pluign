package bs.untitled10.impl.commands.sendItem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ForAll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(command.getName().equals("sendAll")){
            if(!(commandSender instanceof Player)){
                return false;
            }
            Inventory GUI = Bukkit.createInventory(null, 54, "send");
            ItemStack send = new ItemStack(Material.CHEST);
            ItemMeta sendMeta = send.getItemMeta();
            sendMeta.setDisplayName(ChatColor.GREEN + "送出");
            sendMeta.setLore(Arrays.asList("點擊向所有玩家送出物品"));
            send.setItemMeta(sendMeta);

            GUI.setItem(53, send);

            ((Player) commandSender).openInventory(GUI);
        }
        return true;
    }
}

