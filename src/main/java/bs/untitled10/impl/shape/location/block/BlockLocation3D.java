package bs.untitled10.impl.shape.location.block;

import bs.untitled10.lib.shape.Shape3D;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public class BlockLocation3D extends Shape3D {
    private final Block block;

    public BlockLocation3D(@NotNull Block block) {
        super(block.getX(), block.getZ(), block.getY());
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
