package bs.untitled10;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SetMainHand implements CommandExecutor {
    public static Map<UUID, Integer>playerMainHand = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String labels, String[] args) {
        if(!(commandSender instanceof Player)){
            return false;
        }
        Player player = (Player) commandSender;
        UUID playerId = player.getUniqueId();
        if(args.length == 0){
            player.sendMessage(ChatColor.RED + "請輸入欄位");
            return false;
        }
        try {
            int number = Integer.parseInt(args[0]);
            //是數字
            if(number >= 1 && number <= 9){
                playerMainHand.put(playerId, number);
                player.sendMessage(ChatColor.GREEN + "將主手設為第:" + number + "格");
            }
            else{
                player.sendMessage(ChatColor.RED + "請輸入介於1~9的數字");
            }
            return true;

        } catch (NumberFormatException e) {
            //不是數字
            player.sendMessage(ChatColor.RED + "請輸入數字");
            return false;
        }
    }
}
