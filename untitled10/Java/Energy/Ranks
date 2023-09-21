package bs.untitled10.Energy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ranks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)){
            return false;
        }

        if(command.getName().equals("ranks")){

            Player player = (Player) commandSender;
            player.sendMessage("境界列表:" ,
                    "練氣、築基、結丹、元嬰、化神、反虛、合體、大乗",
                    "開發中...");
            return true;
        }
        return true;
    }
}
