package bs.untitled10.impl.commands.particle;

import bs.untitled10.impl.shape.particle.Circle;
import bs.untitled10.impl.shape.location.player.PlayerLocation2D;
import bs.untitled10.impl.shape.location.player.PlayerLocation3D;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class surmount implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("particle")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        PlayerLocation2D playerLocation2D = new PlayerLocation2D(player);
        PlayerLocation3D playerLocation3D = new PlayerLocation3D(player);

        Circle  circle = new Circle(playerLocation2D);
        boolean run    = circle.run(player, playerLocation3D);
        if (!run) {
            return false;
        }
        //            Circle[] circlePoints = circle.getCircleCoordinates(0, 1);
        //
        //            for (Circle point : circlePoints) {
        //                double offsetX = point.getX() - playerX;
        //                double offsetZ = point.getZ() - playerZ;
        //
        //                player.getWorld()
        //                      .spawnParticle(Particle.ENCHANTMENT_TABLE, playerX + offsetX, playerY + 2, playerZ +
        //                      offsetZ,
        //                                     1000);
        //
        //            }

        player.sendMessage("粒子創建成功");
        return true;
    }

    //    public class Coordinates {
    //        private final double X;
    //        private final double Z;
    //
    //        public double getX() {
    //            return X;
    //        }
    //
    //        public double getZ() {
    //            return Z;
    //        }
    //
    //        public Coordinates(double x, double z) {
    //            this.X = x;
    //            this.Z = z;
    //        }
    //
    //        public Coordinates[] circle(double x, double z, int r, int num) {
    //            double        angle      = (double) 360 / num;
    //            Coordinates[] circleCoor = new Coordinates[num];
    //
    //            double theta = 0;
    //            for (int i = 0; i < num; i++) {
    //                theta += angle;
    //                circleCoor[i] = new Coordinates(x + r * Math.cos(theta), z + r * Math.sin(theta));
    //            }
    //
    //            return circleCoor;
    //        }
    //    }
}
