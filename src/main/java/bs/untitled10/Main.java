package bs.untitled10;

import bs.untitled10.Dialogue.Chapter1_1;
import bs.untitled10.Dialogue.delay;
import bs.untitled10.Utils.Advancement.Advancement;
import bs.untitled10.Equip.*;
import bs.untitled10.Anima.*;
import bs.untitled10.EquipGUI.*;
import bs.untitled10.Particle.*;
import bs.untitled10.Utils.SubPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static bs.untitled10.Anima.AnimaSet.timeUpdateAnima;

public final class Main extends JavaPlugin {

    public static JavaPlugin instance;
    private List<SubPlugin> subPlugins;


    @Override
    public void onEnable() {
        getLogger().info("hello world");
        // Plugin startup logic
        instance = this;

        getServer().getPluginManager().registerEvents(new PlayerJoinOrQuit(this), this);//加入靈氣設定
        getServer().getPluginManager().registerEvents(new DeleteRecipe(), this );//清除合成表
        getServer().getPluginManager().registerEvents(new equipmentListener(), this);//裝備計算
        getServer().getPluginManager().registerEvents(new AnimaSet(this), this);//靈氣設定&儲存
        getServer().getPluginManager().registerEvents(new GetDrinkListener(), this);//補給(listener)
        getServer().getPluginManager().registerEvents(new delay(this), this);//計時器
        getServer().getPluginManager().registerEvents(new ArmsSkill(this), this);//技能發動
        getServer().getPluginManager().registerEvents(new SwordSet(), this);
        getCommand("ranks").setExecutor(new Ranks());
        getCommand("surmount").setExecutor(new Surmount(this));
        getCommand("MyAnima").setExecutor(new GetAnima());
        getCommand("openGUI").setExecutor(new equipment(this));
        getCommand("menu").setExecutor(new GetDrink());
        getCommand("particle").setExecutor(new surmount());
        getCommand("SetMainHand").setExecutor(new SetMainHand());
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
