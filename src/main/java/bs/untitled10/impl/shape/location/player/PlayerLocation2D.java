package bs.untitled10.impl.shape.location.player;

import bs.untitled10.lib.shape.Shape2D;
import org.bukkit.entity.Player;

public class PlayerLocation2D extends Shape2D {
    private final Player player;

    public PlayerLocation2D(Player player) {
        super(player.getLocation().getX(), player.getLocation().getZ());
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
