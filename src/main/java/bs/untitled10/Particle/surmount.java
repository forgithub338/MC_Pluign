package bs.untitled10.Particle;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class surmount implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("particle")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use this command!");
                return true;
            }

            Player player = (Player) sender;

            double playerX = player.getLocation().getX();
            double playerY = player.getLocation().getY();
            double playerZ = player.getLocation().getZ();

            Circle   circle       = new Circle(playerX, playerZ);
            Circle[] circlePoints = circle.getCircleCoordinates(0, 1);

            for (Circle point : circlePoints) {
                double offsetX = point.getX() - playerX;
                double offsetZ = point.getZ() - playerZ;

                player.getWorld()
                      .spawnParticle(Particle.ENCHANTMENT_TABLE, playerX + offsetX, playerY + 2, playerZ + offsetZ,
                                     1000);

            }

            player.sendMessage("粒子創建成功");
            return true;
        }
        return false;
    }

    public class Coordinates {
        private final double X;
        private final double Z;

        public double getX() {
            return X;
        }

        public double getZ() {
            return Z;
        }

        public Coordinates(double x, double z) {
            this.X = x;
            this.Z = z;
        }

        public Coordinates[] circle(double x, double z, int r, int num) {
            double        angle      = (double) 360 / num;
            Coordinates[] circleCoor = new Coordinates[num];

            double theta = 0;
            for (int i = 0; i < num; i++) {
                theta += angle;
                circleCoor[i] = new Coordinates(x + r * Math.cos(theta), z + r * Math.sin(theta));
            }

            return circleCoor;
        }
    }
}
