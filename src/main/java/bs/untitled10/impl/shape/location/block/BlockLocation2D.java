package bs.untitled10.impl.shape.location.block;

import bs.untitled10.lib.shape.Shape2D;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public class BlockLocation2D extends Shape2D {
    private final Block block;

    public BlockLocation2D(@NotNull Block block) {
        super(block.getX(), block.getZ());
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
