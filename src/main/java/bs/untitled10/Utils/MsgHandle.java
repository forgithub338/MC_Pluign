package bs.untitled10.Utils;

import bs.untitled10.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsgHandle {
   
    //控制台警告訊息
    public static void WARN(String msg) {
        Main.instance.getLogger().log(Level.WARNING, toColor(msg));
    }

    //控制台一般訊息
    public static void INFO(String msg) {
        Main.instance.getLogger().log(Level.INFO, toColor(msg));
    }

    //廣播
    public static void broadcast(String msg) {
        Main.instance.getServer().broadcast(toColor(msg), "");
    }

    public static void sendMessageToPlayer(Player player, String message) {
        player.sendMessage(toColor(message));
    }

    public static  String replace( String s1, String s2, Object s3) {
        if (s1.contains(s2)) return s1.replace(s2, s3.toString());
        return s1;
    }

    public static  String toColor(String s1) {
        String msg = MsgHandle.toRGB(s1);

        if (msg.contains("&")) {
            msg = ChatColor.translateAlternateColorCodes('&', msg);
        }

        return msg;
    }

    public static String toRGB(final  String message) {
        String msg = message;

        final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");
        Matcher       matcher    = hexPattern.matcher(msg);

        while (matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String    before   = msg.substring(0, matcher.start());
            final String    after    = msg.substring(matcher.end());
            msg     = before + hexColor + after;
            matcher = hexPattern.matcher(msg);
        }

        return msg;
    }
}
