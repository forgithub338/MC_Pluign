package bs.untitled10.impl.shape.location.player;

import bs.untitled10.lib.shape.Shape3D;
import org.bukkit.entity.Player;

public class PlayerLocation3D extends Shape3D {
    private final Player player;

    public PlayerLocation3D(Player player) {
        super(player.getLocation().getX(), player.getLocation().getZ(), player.getLocation().getY());
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
