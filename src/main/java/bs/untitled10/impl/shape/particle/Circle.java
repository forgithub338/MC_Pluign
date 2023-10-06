package bs.untitled10.impl.shape.particle;

import bs.untitled10.lib.shape.Shape2D;
import bs.untitled10.lib.shape.Shape3D;
import bs.untitled10.lib.shape.particle.InterfaceParticle;
import bs.untitled10.impl.shape.location.player.PlayerLocation2D;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Circle extends Shape2D implements InterfaceParticle {

    public Circle(@NotNull PlayerLocation2D playerLocation2D) {
        super(playerLocation2D.getX(), playerLocation2D.getZ());
    }

    public Circle(double x, double z) {
        super(x, z);
    }

    public boolean run(Player player, Shape3D playerLocation) {
        try {
            Circle[] circlePoints = this.getCircleCoordinates(0, 1);
            for (Circle point : circlePoints) {
                double offsetX = point.getX() - this.getX();
                double offsetZ = point.getZ() - this.getZ();

                player.getWorld()
                      .spawnParticle(Particle.ENCHANTMENT_TABLE, playerLocation.getX() + offsetX,
                                     playerLocation.getY() + 2, playerLocation.getZ() + offsetZ, 1000);

            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Circle[] getCircleCoordinates(int r, int num) {
        double   angle             = (double) 360 / num;
        Circle[] circleCoordinates = new Circle[num];

        double theta = 0;
        for (int i = 0; i < num; i++) {
            theta += angle;
            circleCoordinates[i] = new Circle(this.getX() + r * Math.cos(theta), this.getZ() + r * Math.sin(theta));
        }

        return circleCoordinates;
    }
}
