package bs.untitled10.impl.utils;

import bs.untitled10.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class Utils {

    public static NamespacedKey createNamespacedKey(String key) {
        return new NamespacedKey(Main.instance, key);
    }

    public static ItemStack setDisplayNameOfItemStack(ItemStack itemStack, String displayName) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return itemStack;

        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


    public static void setMetadataTag(Block block, Object value) {
        if (hasMetadataTag(block)) return;
        block.setMetadata("untitled10", new FixedMetadataValue(Main.instance, value));
    }

    public static boolean hasMetadataTag(Block block) {
        List<MetadataValue> metadataList = block.getMetadata("untitled10");
        return !metadataList.isEmpty();
    }

}
