package bs.untitled10.Energy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetDrink implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Inventory GUI = Bukkit.createInventory(null, 9, "伺服器菜單");

            ItemStack kitButton = new ItemStack(Material.MILK_BUCKET);
            ItemMeta itemMeta = kitButton.getItemMeta();
            itemMeta.setDisplayName("領取靈氣丹");
            kitButton.setItemMeta(itemMeta);

            GUI.setItem(4, kitButton);

            ((Player) sender).openInventory(GUI);
        }else{
            sender.sendMessage("本指令只能由玩家執行");
        }
        return true;
    }
}
