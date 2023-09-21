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

public class PhysicsEquipSet implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        //煉氣裝備
        ItemStack firstHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta firstHelmetMeta = firstHelmet.getItemMeta();
        firstHelmetMeta.setUnbreakable(true);
        firstHelmetMeta.setDisplayName(ChatColor.WHITE + "粗布頭巾");
        firstHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[練氣]",
                ChatColor.GRAY + "結實耐操的裝備",
                ChatColor.GRAY + "外觀樸實無華",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        firstHelmet.setItemMeta(firstHelmetMeta);

        ItemStack firstChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta firstChestMeta = firstChest.getItemMeta();
        firstChestMeta.setUnbreakable(true);
        firstChestMeta.setDisplayName(ChatColor.WHITE + "軟甲");
        firstChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[練氣]",
                ChatColor.GRAY + "結實耐操的裝備",
                ChatColor.GRAY + "外觀樸實無華",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        firstChest.setItemMeta(firstChestMeta);

        ItemStack firstLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta firstLeggingsMeta = firstLeggings.getItemMeta();
        firstLeggingsMeta.setUnbreakable(true);
        firstLeggingsMeta.setDisplayName(ChatColor.WHITE + "武褲");
        firstLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[練氣]",
                ChatColor.GRAY + "結實耐操的裝備",
                ChatColor.GRAY + "外觀樸實無華",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        firstLeggings.setItemMeta(firstLeggingsMeta);


        ItemStack firstBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta firstBootsMeta = firstBoots.getItemMeta();
        firstBootsMeta.setUnbreakable(true);
        firstBootsMeta.setDisplayName(ChatColor.WHITE + "蟒皮靴");
        firstBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[練氣]",
                ChatColor.GRAY + "結實耐操的裝備",
                ChatColor.GRAY + "外觀樸實無華",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        firstBoots.setItemMeta(firstBootsMeta);


        //築基
        ItemStack secondHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta secondHelmetMeta = secondHelmet.getItemMeta();
        secondHelmetMeta.setUnbreakable(true);
        secondHelmetMeta.setDisplayName(ChatColor.GREEN + "精鋼盔");
        secondHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[築基]",
                ChatColor.GRAY + "注重防護功能",
                ChatColor.GRAY + "避免遊歷時受到襲擊",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        secondHelmet.setItemMeta(secondHelmetMeta);

        ItemStack secondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta secondChestMeta = secondChest.getItemMeta();
        secondChestMeta.setUnbreakable(true);
        secondChestMeta.setDisplayName(ChatColor.GREEN + "護心甲");
        secondChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[築基]",
                ChatColor.GRAY + "注重防護功能",
                ChatColor.GRAY + "避免遊歷時受到襲擊",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        secondChest.setItemMeta(secondChestMeta);

        ItemStack secondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta secondLeggingsMeta = secondLeggings.getItemMeta();
        secondLeggingsMeta.setUnbreakable(true);
        secondLeggingsMeta.setDisplayName(ChatColor.GREEN + "赤銅護脛");
        secondLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[築基]",
                ChatColor.GRAY + "注重防護功能",
                ChatColor.GRAY + "避免遊歷時受到襲擊",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        secondLeggings.setItemMeta(secondLeggingsMeta);

        ItemStack secondBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta secondBootsMeta = secondBoots.getItemMeta();
        secondBootsMeta.setUnbreakable(true);
        secondBootsMeta.setDisplayName(ChatColor.GREEN + "精鐵靴");
        secondBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[築基]",
                ChatColor.GRAY + "注重防護功能",
                ChatColor.GRAY + "避免遊歷時受到襲擊",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        secondBoots.setItemMeta(secondBootsMeta);

        //金丹
        ItemStack thirdHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta thirdHelmetMeta = thirdHelmet.getItemMeta();
        thirdHelmetMeta.setUnbreakable(true);
        thirdHelmetMeta.setDisplayName(ChatColor.DARK_GREEN + "玄鐵盔");
        thirdHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[金丹]",
                ChatColor.GRAY + "整套裝備重達千斤",
                ChatColor.GRAY + "能抵擋世間大多數兵刃",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        thirdHelmet.setItemMeta(thirdHelmetMeta);

        ItemStack thirdChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta thirdChestMeta = thirdChest.getItemMeta();
        thirdChestMeta.setUnbreakable(true);
        thirdChestMeta.setDisplayName(ChatColor.DARK_GREEN + "玄鐵鎧");
        thirdChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[金丹]",
                ChatColor.GRAY + "整套裝備重達千斤",
                ChatColor.GRAY + "能抵擋世間大多數兵刃",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        thirdChest.setItemMeta(thirdChestMeta);

        ItemStack thirdLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta thirdLeggingsMeta = thirdLeggings.getItemMeta();
        thirdLeggingsMeta.setUnbreakable(true);
        thirdLeggingsMeta.setDisplayName(ChatColor.DARK_GREEN + "玄鐵護脛");
        thirdLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[金丹]",
                ChatColor.GRAY + "整套裝備重達千斤",
                ChatColor.GRAY + "能抵擋世間大多數兵刃",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        thirdLeggings.setItemMeta(thirdLeggingsMeta);

        ItemStack thirdBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta thirdBootsMeta = thirdBoots.getItemMeta();
        thirdBootsMeta.setUnbreakable(true);
        thirdBootsMeta.setDisplayName(ChatColor.DARK_GREEN + "玄鐵靴");
        thirdBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[金丹]",
                ChatColor.GRAY + "整套裝備重達千斤",
                ChatColor.GRAY + "能抵擋世間大多數兵刃",
                ChatColor.GRAY + "=====" + ChatColor.GREEN+ "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        thirdBoots.setItemMeta(thirdBootsMeta);

        //元嬰
        ItemStack fourthHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta fourthHelmetMeta = fourthHelmet.getItemMeta();
        fourthHelmetMeta.setUnbreakable(true);
        fourthHelmetMeta.setDisplayName(ChatColor.AQUA + "天火盔");
        fourthHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[元嬰]",
                ChatColor.GRAY + "散發著炙熱的裝備",
                ChatColor.GRAY + "防禦力高得驚人",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fourthHelmet.setItemMeta(fourthHelmetMeta);

        ItemStack fourthChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta fourthChestMeta = fourthChest.getItemMeta();
        fourthChestMeta.setUnbreakable(true);
        fourthChestMeta.setDisplayName(ChatColor.AQUA + "暖玉甲");
        fourthChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[元嬰]",
                ChatColor.GRAY + "散發著炙熱的裝備",
                ChatColor.GRAY + "防禦力高得驚人",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fourthChest.setItemMeta(fourthChestMeta);

        ItemStack fourthLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta fourthLeggingsMeta = fourthLeggings.getItemMeta();
        fourthLeggingsMeta.setUnbreakable(true);
        fourthLeggingsMeta.setDisplayName(ChatColor.AQUA + "灼焰脛");
        fourthLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[元嬰]",
                ChatColor.GRAY + "散發著炙熱的裝備",
                ChatColor.GRAY + "防禦力高得驚人",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fourthLeggings.setItemMeta(fourthLeggingsMeta);

        ItemStack fourthBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta fourthBootsMeta = fourthBoots.getItemMeta();
        fourthBootsMeta.setUnbreakable(true);
        fourthBootsMeta.setDisplayName(ChatColor.AQUA + "炙炎靴");
        fourthBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[元嬰]",
                ChatColor.GRAY + "散發著炙熱的裝備",
                ChatColor.GRAY + "防禦力高得驚人",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fourthBoots.setItemMeta(fourthBootsMeta);


        //化神
        ItemStack fifthHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta fifthHelmetMeta = fifthHelmet.getItemMeta();
        fifthHelmetMeta.setUnbreakable(true);
        fifthHelmetMeta.setDisplayName(ChatColor.DARK_AQUA + "龍魂盔");
        fifthHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[化神]",
                ChatColor.GRAY + "究竟是裝備使人擁有降龍伏虎之力",
                ChatColor.GRAY + "還是擁有力量的人才能穿上呢?",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fifthHelmet.setItemMeta(fifthHelmetMeta);

        ItemStack fifthChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta fifthChestMeta = fifthChest.getItemMeta();
        fifthChestMeta.setUnbreakable(true);
        fifthChestMeta.setDisplayName(ChatColor.DARK_AQUA + "降龍甲");
        fifthChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[化神]",
                ChatColor.GRAY + "究竟是裝備使人擁有降龍伏虎之力",
                ChatColor.GRAY + "還是擁有力量的人才能穿上呢?",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fifthChest.setItemMeta(fifthChestMeta);

        ItemStack fifthLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta fifthLeggingsMeta = fifthLeggings.getItemMeta();
        fifthLeggingsMeta.setUnbreakable(true);
        fifthLeggingsMeta.setDisplayName(ChatColor.DARK_AQUA + "伏虎脛");
        fifthLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[化神]",
                ChatColor.GRAY + "究竟是裝備使人擁有降龍伏虎之力",
                ChatColor.GRAY + "還是擁有力量的人才能穿上呢?",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fifthLeggings.setItemMeta(fifthLeggingsMeta);

        ItemStack fifthBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta fifthBootsMeta = fifthBoots.getItemMeta();
        fifthBootsMeta.setUnbreakable(true);
        fifthBootsMeta.setDisplayName(ChatColor.DARK_AQUA + "虎嘯靴");
        fifthBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[化神]",
                ChatColor.GRAY + "究竟是裝備使人擁有降龍伏虎之力",
                ChatColor.GRAY + "還是擁有力量的人才能穿上呢?",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        fifthBoots.setItemMeta(fifthBootsMeta);


        //反虛
        ItemStack sixthHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta sixthHelmetMeta = sixthHelmet.getItemMeta();
        sixthHelmetMeta.setUnbreakable(true);
        sixthHelmetMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "冰心盔");
        sixthHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[反虛]",
                ChatColor.GRAY + "北海極寒之地特有的套裝",
                ChatColor.GRAY + "讓攻擊者從頭冷到腳底",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        sixthHelmet.setItemMeta(sixthHelmetMeta);

        ItemStack sixthChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta sixthChestMeta = sixthChest.getItemMeta();
        sixthChestMeta.setUnbreakable(true);
        sixthChestMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "寒玉甲");
        sixthChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[反虛]",
                ChatColor.GRAY + "北海極寒之地特有的套裝",
                ChatColor.GRAY + "讓攻擊者從頭冷到腳底",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        sixthChest.setItemMeta(sixthChestMeta);

        ItemStack sixthLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta sixthLeggingsMeta = sixthLeggings.getItemMeta();
        sixthLeggingsMeta.setUnbreakable(true);
        sixthLeggingsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "冷髓脛");
        sixthLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[反虛]",
                ChatColor.GRAY + "北海極寒之地特有的套裝",
                ChatColor.GRAY + "讓攻擊者從頭冷到腳底",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        sixthLeggings.setItemMeta(sixthLeggingsMeta);

        ItemStack sixthBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta sixthBootsMeta = sixthBoots.getItemMeta();
        sixthBootsMeta.setUnbreakable(true);
        sixthBootsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "寒山靴");
        sixthBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[反虛]",
                ChatColor.GRAY + "北海極寒之地特有的套裝",
                ChatColor.GRAY + "讓攻擊者從頭冷到腳底",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        sixthBoots.setItemMeta(sixthBootsMeta);

        //合體
        ItemStack seventhHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta seventhHelmetMeta = seventhHelmet.getItemMeta();
        seventhHelmetMeta.setUnbreakable(true);
        seventhHelmetMeta.setDisplayName(ChatColor.DARK_PURPLE + "血隱盔");
        seventhHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[合體]",
                ChatColor.GRAY + "漆黑如墨的套裝",
                ChatColor.GRAY + "對隱藏身形頗有用處",
                ChatColor.GRAY + "遊歷天下必備",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        seventhHelmet.setItemMeta(seventhHelmetMeta);

        ItemStack seventhChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta seventhChestMeta = seventhChest.getItemMeta();
        seventhChestMeta.setUnbreakable(true);
        seventhChestMeta.setDisplayName(ChatColor.DARK_PURPLE + "蝠翼甲");
        seventhChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[合體]",
                ChatColor.GRAY + "漆黑如墨的套裝",
                ChatColor.GRAY + "對隱藏身形頗有用處",
                ChatColor.GRAY + "遊歷天下必備",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        seventhChest.setItemMeta(seventhChestMeta);

        ItemStack seventhLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta seventhLeggingsMeta = seventhLeggings.getItemMeta();
        seventhLeggingsMeta.setUnbreakable(true);
        seventhLeggingsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "消影脛");
        seventhLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[合體]",
                ChatColor.GRAY + "漆黑如墨的套裝",
                ChatColor.GRAY + "對隱藏身形頗有用處",
                ChatColor.GRAY + "遊歷天下必備",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        seventhLeggings.setItemMeta(seventhLeggingsMeta);

        ItemStack seventhBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta seventhBootsMeta = seventhBoots.getItemMeta();
        seventhBootsMeta.setUnbreakable(true);
        seventhBootsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "無蹤靴");
        seventhBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[合體]",
                ChatColor.GRAY + "漆黑如墨的套裝",
                ChatColor.GRAY + "對隱藏身形頗有用處",
                ChatColor.GRAY + "遊歷天下必備",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        seventhBoots.setItemMeta(seventhBootsMeta);

        //大乘
        ItemStack eighthHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta eighthHelmetMeta = eighthHelmet.getItemMeta();
        eighthHelmetMeta.setUnbreakable(true);
        eighthHelmetMeta.setDisplayName(ChatColor.RED + "戰天盔");
        eighthHelmetMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[大乘]",
                ChatColor.RED + "與天鬥,與地鬥,與人鬥",
                ChatColor.GOLD + "戰魂不滅，金身不倒",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        eighthHelmet.setItemMeta(eighthHelmetMeta);

        ItemStack eighthChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta eighthChestMeta = eighthChest.getItemMeta();
        eighthChestMeta.setUnbreakable(true);
        eighthChestMeta.setDisplayName(ChatColor.RED + "滅敵甲");
        eighthChestMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[大乘]",
                ChatColor.RED + "與天鬥,與地鬥,與人鬥",
                ChatColor.GOLD + "戰魂不滅，金身不倒",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        eighthChest.setItemMeta(eighthChestMeta);

        ItemStack eighthLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta eighthLeggingsMeta = eighthLeggings.getItemMeta();
        eighthLeggingsMeta.setUnbreakable(true);
        eighthLeggingsMeta.setDisplayName(ChatColor.RED + "破世脛");
        eighthLeggingsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[大乘]",
                ChatColor.RED + "與天鬥,與地鬥,與人鬥",
                ChatColor.GOLD + "戰魂不滅，金身不倒",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        eighthLeggings.setItemMeta(eighthLeggingsMeta);

        ItemStack eighthBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta eighthBootsMeta = eighthBoots.getItemMeta();
        eighthBootsMeta.setUnbreakable(true);
        eighthBootsMeta.setDisplayName(ChatColor.RED + "鬥地靴");
        eighthBootsMeta.setLore(Arrays.asList(
                ChatColor.GOLD + "限制職業:[戰][弓]  限制境界:[大乘]",
                ChatColor.RED + "與天鬥,與地鬥,與人鬥",
                ChatColor.GOLD + "戰魂不滅，金身不倒",
                ChatColor.GRAY + "=====" + ChatColor.GREEN + "裝備屬性" + ChatColor.GRAY + "=====",
                ChatColor.WHITE + "近戰傷害 +2  攻擊速度 1.0"
        ));
        eighthBoots.setItemMeta(eighthBootsMeta);

        player.getInventory().addItem(firstHelmet);
        player.getInventory().addItem(firstChest);
        player.getInventory().addItem(firstLeggings);
        player.getInventory().addItem(firstBoots);

        player.getInventory().addItem(secondHelmet);
        player.getInventory().addItem(secondChest);
        player.getInventory().addItem(secondLeggings);
        player.getInventory().addItem(secondBoots);

        player.getInventory().addItem(thirdHelmet);
        player.getInventory().addItem(thirdChest);
        player.getInventory().addItem(thirdLeggings);
        player.getInventory().addItem(thirdBoots);

        player.getInventory().addItem(fourthHelmet);
        player.getInventory().addItem(fourthChest);
        player.getInventory().addItem(fourthLeggings);
        player.getInventory().addItem(fourthBoots);

        player.getInventory().addItem(fifthHelmet);
        player.getInventory().addItem(fifthChest);
        player.getInventory().addItem(fifthLeggings);
        player.getInventory().addItem(fifthBoots);

        player.getInventory().addItem(sixthHelmet);
        player.getInventory().addItem(sixthChest);
        player.getInventory().addItem(sixthLeggings);
        player.getInventory().addItem(sixthBoots);

        player.getInventory().addItem(seventhHelmet);
        player.getInventory().addItem(seventhChest);
        player.getInventory().addItem(seventhLeggings);
        player.getInventory().addItem(seventhBoots);

        player.getInventory().addItem(eighthHelmet);
        player.getInventory().addItem(eighthChest);
        player.getInventory().addItem(eighthLeggings);
        player.getInventory().addItem(eighthBoots);
    }
}
