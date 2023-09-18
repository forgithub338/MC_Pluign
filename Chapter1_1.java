package bs.untitled10.Dialogue;

import bs.untitled10.Main;
import bs.untitled10.Dialogue.delay;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.conversations.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.List;
import java.util.Timer;




public class Chapter1_1 implements CommandExecutor {

    private final Main plugin;

    public Chapter1_1(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;

        if(command.getName().equals("chapter")){
            startCustomDialog(player);
        }
        return false;
    }

    private void startCustomDialog(Player player) {
        ConversationFactory factory = new ConversationFactory(plugin)
                .withModality(true)
                .withPrefix(new ConversationPrefix() {
                    @Override
                    public String getPrefix(ConversationContext context) {
                        return ChatColor.AQUA + "[主線]";
                    }
                })
                .withFirstPrompt(new CustomDialogPrompt())
                .withEscapeSequence("cancel");


        Conversation conversation = factory.buildConversation(player);
        conversation.begin();
    }

    private class CustomDialogPrompt extends FixedSetPrompt {
        private boolean isTaskScheduled = false;

        public CustomDialogPrompt() {
            super("是", "否");
        }

        @Override
        public String getPromptText(ConversationContext context) {
            return ChatColor.YELLOW + "開啟主線第一節?   " + ChatColor.GREEN + "是" + ChatColor.WHITE + " / " + ChatColor.RED + "否";
        }

        @Override
        protected Prompt acceptValidatedInput(ConversationContext context, String choice) {
            Player player = (Player) context.getForWhom();
            String playerName = player.toString();
            if (choice.equalsIgnoreCase("是")) {
                if (!isTaskScheduled) {
                    isTaskScheduled = true;

                    InputStream inputStream = getClass().getResourceAsStream("/chapter1_1.yml");

                    YamlConfiguration config = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                    List<String> dialogueMessages = config.getStringList("dialogue-messages");

                    for (String message : dialogueMessages) {
                        new delay(() -> {context.getForWhom().sendRawMessage(ChatColor.translateAlternateColorCodes('&', message));
                        }, 20); //5 seconds
                    }


                }else{
                    context.getForWhom().sendRawMessage("任務已啟動");
                }
            } else if (choice.equalsIgnoreCase("否")) {
                player.sendMessage(ChatColor.RED + "主線取消");
                context.getForWhom().sendRawMessage("您选择了 '否'。");
            }
            else{
                player.sendMessage(ChatColor.RED + "主線取消");
            }
            return null;
        }
    }



}