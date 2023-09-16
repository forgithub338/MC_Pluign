package bs.untitled10.Energy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static bs.untitled10.Energy.PlayerJoinOrQuit.PlayerAnima;

public class GetAnima implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)){
            return false;
        }

        if(command.getName().equals("MyAnima")){
            Player player = (Player) commandSender;
            UUID playerId = player.getUniqueId();
            Integer anima =  PlayerAnima.getOrDefault(playerId, 0);
            player.sendMessage("你的靈氣值" + anima);
        }
        return true;
    }
}
