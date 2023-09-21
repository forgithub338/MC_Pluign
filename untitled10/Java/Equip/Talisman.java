package bs.untitled10.Equip;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Talisman implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        //朱雀羽
        ItemStack south = new ItemStack(Material.RED_DYE);
        ItemMeta southMeta = south.getItemMeta();

        southMeta.setDisplayName(ChatColor.GOLD + "朱雀羽");
        southMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "[護符]",
                ChatColor.GRAY + "朱雀的一根尾羽，蘊含離火之意",
                ChatColor.GRAY + "配戴可使人戰意不止",
                ChatColor.GRAY + "升級次數: " + ChatColor.AQUA + "1/50",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "護符屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "攻擊力+" + ChatColor.AQUA + "2%"
        ));
        south.setItemMeta(southMeta);


        //青龍鱗
        ItemStack east = new ItemStack(Material.GREEN_DYE);
        ItemMeta eastMeta = east.getItemMeta();
        eastMeta.setDisplayName(ChatColor.GOLD + "青龍鱗");
        eastMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "[護符]",
                ChatColor.GRAY + "青龍褪下的鱗片，蘊含?木之魂",
                ChatColor.GRAY + "煉化可延年益壽",
                ChatColor.GRAY + "升級次數: " + ChatColor.AQUA + "1/50",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "護符屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "生命值+" + ChatColor.AQUA + "2%"
        ));
        east.setItemMeta(eastMeta);


        //白虎爪
        ItemStack west = new ItemStack(Material.WHITE_DYE);
        ItemMeta westMeta = west.getItemMeta();
        westMeta.setDisplayName(ChatColor.GOLD + "白虎爪");
        westMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "[護符]",
                ChatColor.GRAY + "白虎的一截爪子，蘊含庚金之道",
                ChatColor.GRAY + "參悟可破敵無雙",
                ChatColor.GRAY + "升級次數: " + ChatColor.AQUA + "1/50",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "護符屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "符咒/陣法強度+" + ChatColor.AQUA + "2%"
        ));
        west.setItemMeta(westMeta);


        //玄武甲
        ItemStack north = new ItemStack(Material.BLACK_DYE);
        ItemMeta northMeta = north.getItemMeta();
        northMeta.setDisplayName(ChatColor.GOLD + "玄武甲");
        northMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "[護符]",
                ChatColor.GRAY + "玄武遺留的一小塊甲殼，蘊含坎水之精",
                ChatColor.GRAY + "持之金身不倒",
                ChatColor.GRAY + "升級次數: " + ChatColor.AQUA + "1/50",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "護符屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "防禦值+" + ChatColor.AQUA + "2%"
        ));
        north.setItemMeta(northMeta);

        player.getInventory().addItem(south);
        player.getInventory().addItem(west);
        player.getInventory().addItem(east);
        player.getInventory().addItem(north);






    }
}
