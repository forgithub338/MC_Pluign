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

public class PenSet implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player =  e.getPlayer();

        ItemStack firstPen = new ItemStack(Material.FEATHER);
        ItemMeta firstPenMeta = firstPen.getItemMeta();
        firstPenMeta.setUnbreakable(true);
        firstPenMeta.setDisplayName(ChatColor.WHITE + "狼毫筆");
        firstPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[練氣]",
                ChatColor.GRAY + "取用黃鼠狼毛製成的毛筆",
                ChatColor.GRAY + "書寫十分流暢",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        firstPen.setItemMeta(firstPenMeta);

        ItemStack secondPen = new ItemStack(Material.FEATHER);
        ItemMeta secondPenMeta = secondPen.getItemMeta();
        secondPenMeta.setUnbreakable(true);
        secondPenMeta.setDisplayName(ChatColor.GREEN + "青玉狼毫筆");
        secondPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[築基]",
                ChatColor.GRAY + "造價不斐",
                ChatColor.GRAY + "書寫時如指臂使",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        secondPen.setItemMeta(secondPenMeta);

        ItemStack thirdPen = new ItemStack(Material.FEATHER);
        ItemMeta thirdPenMeta = thirdPen.getItemMeta();
        thirdPenMeta.setUnbreakable(true);
        thirdPenMeta.setDisplayName(ChatColor.DARK_GREEN + "太白筆");
        thirdPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[金丹]",
                ChatColor.GRAY + "天上謫仙曾使用過的毛筆",
                ChatColor.GRAY + "透著一股靈性",
                ChatColor.GRAY + "書寫時瀟灑無比",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        thirdPen.setItemMeta(thirdPenMeta);

        ItemStack fourthPen = new ItemStack(Material.FEATHER);
        ItemMeta fourthPenMeta = fourthPen.getItemMeta();
        fourthPenMeta.setUnbreakable(true);
        fourthPenMeta.setDisplayName(ChatColor.AQUA + "判官筆");
        fourthPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[元嬰]",
                ChatColor.GRAY + "據說是地府判官畫簽生死簿時所用",
                ChatColor.GRAY + "書寫人名時會變得極為沉重",
                ChatColor.GRAY + "這就是生命的重量嗎?",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fourthPen.setItemMeta(fourthPenMeta);

        ItemStack fifthPen = new ItemStack(Material.FEATHER);
        ItemMeta fifthPenMeta = fifthPen.getItemMeta();
        fifthPenMeta.setUnbreakable(true);
        fifthPenMeta.setDisplayName(ChatColor.DARK_AQUA + "龍吟筆");
        fifthPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[化神]",
                ChatColor.GRAY + "筆桿中封有一條龍筋",
                ChatColor.GRAY + "書寫時隱隱可聽見龍吟之聲",
                ChatColor.GRAY + "對妖獸一類有克制效果",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fifthPen.setItemMeta(fifthPenMeta);

        ItemStack sixthPen = new ItemStack(Material.FEATHER);
        ItemMeta sixthPenMeta = sixthPen.getItemMeta();
        sixthPenMeta.setUnbreakable(true);
        sixthPenMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "八尾筆");
        sixthPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[反虛]",
                ChatColor.GRAY + "八尾妖狐的尾毛所製，極為珍貴",
                ChatColor.GRAY + "在施展幻術方面有奇效",
                ChatColor.GRAY + "但在狐族面前使用無異於侮辱對方",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        sixthPen.setItemMeta(sixthPenMeta);

        ItemStack seventhPen = new ItemStack(Material.FEATHER);
        ItemMeta seventhPenMeta = seventhPen.getItemMeta();
        seventhPenMeta.setUnbreakable(true);
        seventhPenMeta.setDisplayName(ChatColor.DARK_PURPLE + "瑞雲筆");
        seventhPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[合體]",
                ChatColor.GRAY + "採用九種瑞獸毛所製",
                ChatColor.GRAY + "持有者可趨吉避凶",
                ChatColor.GRAY + "書寫時旁生祥雲，諸邪退避",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        seventhPen.setItemMeta(seventhPenMeta);

        ItemStack eighthPen = new ItemStack(Material.FEATHER);
        ItemMeta eighthPenMeta = eighthPen.getItemMeta();
        eighthPenMeta.setUnbreakable(true);
        eighthPenMeta.setDisplayName(ChatColor.RED + "司命筆");
        eighthPenMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[符]  限制境界:[大乘]",
                ChatColor.GRAY + "據說是天庭司命星君所用神筆",
                ChatColor.GRAY + "此筆在手，我命由我不由天，世間再無命苦人",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[被動]" + ChatColor.WHITE + "可切換:" +ChatColor.AQUA + "防禦/生命回復/力量",
                ChatColor.WHITE + "當前" + ChatColor.AQUA + "生命回復"
        ));
        eighthPen.setItemMeta(eighthPenMeta);

        player.getInventory().addItem(firstPen);
        player.getInventory().addItem(secondPen);
        player.getInventory().addItem(thirdPen);
        player.getInventory().addItem(fourthPen);
        player.getInventory().addItem(fifthPen);
        player.getInventory().addItem(sixthPen);
        player.getInventory().addItem(seventhPen);
        player.getInventory().addItem(eighthPen);


    }
}
