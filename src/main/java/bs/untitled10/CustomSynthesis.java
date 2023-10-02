package bs.untitled10;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;

import bs.untitled10.Utils.Utils;

public class CustomSynthesis implements Listener {


    public static void customRecipe() {
        //有序合成台配方
        NamespacedKey interestingRecipe = Utils.createNamespacedKey("interesting_recipe");
        ItemStack     obsidian          = new ItemStack(Material.OBSIDIAN);
        ShapedRecipe shapedRecipe = new ShapedRecipe(interestingRecipe, obsidian).shape("ccc", "c c", "ccc")
                                                                                 .setIngredient('c', Material.DIRT);

        //無序合成台配方
        NamespacedKey   shapleless      = Utils.createNamespacedKey("shapleless");
        ItemStack       diamond_Sword   = Utils.createItemStack(Material.DIAMOND_SWORD);
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(shapleless, diamond_Sword);
        ItemStack       dirt_ItemStack  = Utils.createItemStack(Material.DIRT);
        ItemStack       customItemStack = Utils.setDisplayNameOfItemStack(dirt_ItemStack, "大地的皮膚");

        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(customItemStack));
        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(customItemStack));
        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(customItemStack));
        shapelessRecipe = shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(customItemStack));

        //熔爐合成配方
        NamespacedKey aFurnaceRecipe = Utils.createNamespacedKey("a_furnace_recipe");
        ItemStack     blackWool      = Utils.createItemStack(Material.BLACK_WOOL);
        FurnaceRecipe fr             = new FurnaceRecipe(aFurnaceRecipe, blackWool, Material.WHITE_WOOL, 0.8F, 200);

        Main.instance.getServer().addRecipe(shapelessRecipe);
        Main.instance.getServer().addRecipe(shapedRecipe);
    }


    // 单引号！
}
