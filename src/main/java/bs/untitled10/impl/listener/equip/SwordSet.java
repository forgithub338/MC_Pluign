package bs.untitled10.impl.listener.equip;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SwordSet implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        //精鐵劍
        ItemStack firstSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta firstSwordMeta = firstSword.getItemMeta();
        firstSwordMeta.setUnbreakable(true);
        hideAttributes(firstSwordMeta);
        firstSwordMeta.setDisplayName(ChatColor.WHITE + "精鐵劍");
        firstSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[刀]  限制境界:[練氣]",
                ChatColor.GRAY + "結實的鐵劍",
                ChatColor.GRAY + "材料及做工不錯",
                ChatColor.GRAY + "可以承受練氣士的力量",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        firstSword.setItemMeta(firstSwordMeta);

        //百煉劍
        ItemStack secondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta secondSwordMeta = secondSword.getItemMeta();
        secondSwordMeta.setUnbreakable(true);
        secondSwordMeta.setDisplayName(ChatColor.GREEN + "百煉劍");
        secondSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[刀]  限制境界:[築基]",
                ChatColor.GRAY + "百煉成鋼",
                ChatColor.GRAY + "且混入少量玄鐵",
                ChatColor.GRAY + "摧金斷玉的寶劍",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0"
        ));

        secondSword.setItemMeta(secondSwordMeta);

        //
        ItemStack thirdSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta thirdSwordMeta = thirdSword.getItemMeta();
        thirdSwordMeta.setUnbreakable(true);
        thirdSwordMeta.setDisplayName(ChatColor.DARK_GREEN + "玄鐵重劍");
        thirdSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰]  限制境界:[金丹]",
                ChatColor.GRAY + "重劍無鋒",
                ChatColor.GRAY + "大巧不工",
                ChatColor.GRAY + "凡人武道巔峰",
                ChatColor.GRAY + "劍魔生前所使之兵",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[潛行+右鍵]" + ChatColor.WHITE + "冷卻" +ChatColor.AQUA + "20" + ChatColor.WHITE + "秒 " + ChatColor.WHITE + "持續" + ChatColor.AQUA + "5" + ChatColor.WHITE + "秒",
                ChatColor.WHITE + "對被攻擊者造成擊退I效果"
        ));
        thirdSword.setItemMeta(thirdSwordMeta);

        //忘憂劍
        ItemStack fourthSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta fourthSwordMeta = fourthSword.getItemMeta();
        fourthSwordMeta.setUnbreakable(true);
        fourthSwordMeta.setDisplayName(ChatColor.AQUA + "忘憂劍");
        fourthSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰]  限制境界:[元嬰]",
                ChatColor.GRAY + "傳聞為酒劍仙當年曾使用過的兵刃",
                ChatColor.GRAY + "散發著一股淡淡的酒香" ,
                ChatColor.GRAY + "聽說其中藏著酒劍仙飛升之法",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[潛行+右鍵]" + ChatColor.WHITE + "冷卻" +ChatColor.AQUA + "20" + ChatColor.WHITE + "秒 ",
                ChatColor.WHITE + "周圍五格內的其他生物傷害降低20%"
        ));
        fourthSword.setItemMeta(fourthSwordMeta);

        //
        ItemStack fifthSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta fifthSwordMeta = fifthSword.getItemMeta();
        fifthSwordMeta.setUnbreakable(true);
        fifthSwordMeta.setDisplayName(ChatColor.DARK_AQUA + "赤霄劍");
        fifthSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰]  限制境界:[化神]",
                ChatColor.GRAY + "取用南方火龍的脊骨所製",
                ChatColor.GRAY + "催發其中威能後可焚山煮海" ,
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[潛行+右鍵]" + ChatColor.WHITE + "冷卻" +ChatColor.AQUA + "20" + ChatColor.WHITE + "秒 ",
                ChatColor.WHITE + "對五格範圍內的其他生物造成持續5秒的燃燒傷害"
        ));
        fifthSword.setItemMeta(fifthSwordMeta);

        //
        ItemStack sixthSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta sixthSwordMeta = sixthSword.getItemMeta();
        sixthSwordMeta.setUnbreakable(true);
        sixthSwordMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "霜痕劍");
        sixthSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰]  限制境界:[反虛]",
                ChatColor.GRAY + "由北海寒玉髓、萬年玄冰心所製，寒氣逼人",
                ChatColor.GRAY + "揮舞時可凝水化冰，在空中形成霜痕" ,
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[潛行+右鍵]" + ChatColor.WHITE + "冷卻" +ChatColor.AQUA + "20" + ChatColor.WHITE + "秒 ",
                ChatColor.WHITE + "對五格範圍內的其他生物造成定身效果並持續造成冰凍傷害"
        ));
        sixthSword.setItemMeta(sixthSwordMeta);

        //
        ItemStack seventhSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta seventhSwordMeta = seventhSword.getItemMeta();
        seventhSwordMeta.setUnbreakable(true);
        seventhSwordMeta.setDisplayName(ChatColor.DARK_PURPLE + "月影劍");
        seventhSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰]  限制境界:[合體]",
                ChatColor.GRAY + "通體漆黑但隱隱透出一絲亮光的神兵",
                ChatColor.GRAY + "揮舞時無聲無息，就如月下柳影" ,
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[潛行+右鍵]" + ChatColor.WHITE + "冷卻" +ChatColor.AQUA + "20" + ChatColor.WHITE + "秒 " + ChatColor.WHITE + "持續" + ChatColor.AQUA + "5" + ChatColor.WHITE + "秒",
                ChatColor.WHITE + "五秒內攻擊上升30%"
                ));
        // 添加被動效果（攻速+20%）
        seventhSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        seventhSwordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        seventhSword.setItemMeta(seventhSwordMeta);

        //
        ItemStack eighthSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta eighthSwordMeta = eighthSword.getItemMeta();
        eighthSwordMeta.setUnbreakable(true);

        eighthSwordMeta.setDisplayName(ChatColor.DARK_RED + "斬天劍");
        eighthSwordMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰]  限制境界:[大乘]",
                ChatColor.GRAY + "神匠歐治子飛升前所留神兵",
                ChatColor.GRAY + "世人贈詩「劍氣縱橫三萬里，一劍光寒十九洲」" ,
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害+5  攻擊速度 1.0",
                ChatColor.RED + "[亦斬]" + ChatColor.AQUA + "橫掃之刃",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "武器技能" + ChatColor.GRAY + "=====",
                ChatColor.YELLOW + "[潛行+右鍵]" + ChatColor.WHITE + "冷卻" +ChatColor.AQUA + "10" + ChatColor.WHITE + "秒 " + ChatColor.WHITE + "持續" + ChatColor.AQUA + "5" + ChatColor.WHITE + "秒",
                ChatColor.WHITE + "近戰傷害提升" + ChatColor.AQUA + "50%",
                ChatColor.YELLOW + "[被動]" + ChatColor.WHITE + "冷卻" + ChatColor.AQUA + "10" + ChatColor.WHITE + "秒 " + ChatColor.WHITE + "持續" + ChatColor.AQUA + "5" + ChatColor.WHITE + "秒",
                ChatColor.WHITE + "造成傷害後，提升" + ChatColor.AQUA + "20%"
        ));

        // 添加被動效果（攻擊時，大機率造成範圍傷害）
        eighthSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        eighthSwordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        eighthSword.setItemMeta(eighthSwordMeta);


        e.getPlayer().getInventory().addItem(firstSword);
        e.getPlayer().getInventory().addItem(secondSword);
        e.getPlayer().getInventory().addItem(thirdSword);
        e.getPlayer().getInventory().addItem(fourthSword);
        e.getPlayer().getInventory().addItem(fifthSword);
        e.getPlayer().getInventory().addItem(sixthSword);
        e.getPlayer().getInventory().addItem(seventhSword);
        e.getPlayer().getInventory().addItem(eighthSword);
    }
    private ItemMeta hideAttributes(ItemMeta itemMeta){
        itemMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        itemMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        return itemMeta;
    }

}
