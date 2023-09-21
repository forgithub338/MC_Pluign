package bs.untitled10;

import bs.untitled10.Dialogue.Chapter1_1;
import bs.untitled10.Dialogue.delay;
import bs.untitled10.Utils.Advancement.Advancement;
import bs.untitled10.Equip.*;
import bs.untitled10.Energy.*;
import bs.untitled10.EquipGUI.*;
import bs.untitled10.Particle.*;
import bs.untitled10.Utils.SubPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static bs.untitled10.Energy.AnimaSet.timeUpdateAnima;

public final class Main extends JavaPlugin {

    public static JavaPlugin instance;
    private List<SubPlugin> subPlugins;


    @Override
    public void onEnable() {
        getLogger().info("hello world");
        // Plugin startup logic
        instance = this;

        getServer().getPluginManager().registerEvents(new PlayerJoinOrQuit(this), this);
        getServer().getPluginManager().registerEvents(new DeleteRecipe(), this );
        getServer().getPluginManager().registerEvents(new equipmentListener(), this);
        getServer().getPluginManager().registerEvents(new Event(), this);
        getServer().getPluginManager().registerEvents(new AnimaSet(this), this);
        getServer().getPluginManager().registerEvents(new GetDrinkListener(), this);
        getServer().getPluginManager().registerEvents(new MagicEquipSet(), this);
        getServer().getPluginManager().registerEvents(new delay(this), this);
        getCommand("ranks").setExecutor(new Ranks());
        getCommand("surmount").setExecutor(new Surmount(this));
        getCommand("MyAnima").setExecutor(new GetAnima());
        getCommand("openGUI").setExecutor(new equipment(this));
        getCommand("menu").setExecutor(new GetDrink());
        getCommand("particle").setExecutor(new surmount());
        getCommand("AnimaGive").setExecutor(new AnimaGive());
        Chapter1_1 dialogue = new Chapter1_1(this);
        getCommand("chapter").setExecutor(dialogue);
        CustomSynthesis.customRecipe();

        new BukkitRunnable(){
            @Override
            public void run(){
                timeUpdateAnima();
            }
        }.runTaskTimer(this, 0L, 20L);

        Bukkit.getLogger().info("======= Loading Main Plugin =======");

        subPlugins = new ArrayList<>();
        registerPlugin(new Advancement());

        Bukkit.getLogger().info("======= Main Plugin Enabled =======");

    }

    private void registerPlugin(SubPlugin plugin) {
        subPlugins.add(plugin);
        plugin.onEnable(this);
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.resetRecipes();
        for (SubPlugin subPlugin : subPlugins) {
            subPlugin.onDisable();
        }
        subPlugins.clear();

        Bukkit.getLogger().info("======= Main Plugin Disabled =======");
    }
}
