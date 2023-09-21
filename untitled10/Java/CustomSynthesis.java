package bs.untitled10;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.FurnaceRecipe;

import java.util.List;

public class CustomSynthesis implements Listener {


    public static void customRecipe(){
        //有序合成台配方
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(Main.instance, "interesting_recipe"), new ItemStack(Material.OBSIDIAN));
        shapedRecipe = shapedRecipe.shape("ccc", "c c", "ccc");
        shapedRecipe = shapedRecipe.setIngredient('c', Material.DIRT);

        //無序合成台配方
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new NamespacedKey(Main.instance, "shapleless"), new ItemStack(Material.DIAMOND_SWORD));

        ItemStack dirtItem = new ItemStack(Material.DIRT);
        ItemMeta dirtMeta = dirtItem.getItemMeta();
        dirtMeta.setDisplayName("大地的皮膚");
        dirtItem.setItemMeta(dirtMeta);

        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(dirtItem));
        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(dirtItem));
        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(dirtItem));
        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(dirtItem));

        //熔爐合成配方
        FurnaceRecipe fr = new FurnaceRecipe(
                new NamespacedKey(Main.instance, "a_furnace_recipe"),
                new ItemStack(Material.BLACK_WOOL),
                Material.WHITE_WOOL,
                0.8F,
                200
);

        Main.instance.getServer().addRecipe(shapelessRecipe);
        Main.instance.getServer().addRecipe(shapedRecipe);
    }


// 单引号！
}
