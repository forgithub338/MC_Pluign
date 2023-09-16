package bs.untitled10;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static bs.untitled10.Energy.AnimaSet.timeUpdateAnima;

public final class Main extends JavaPlugin {

    public static JavaPlugin instance;



    @Override
    public void onEnable() {

        // Plugin startup logic
        instance = this;



        getServer().getPluginManager().registerEvents(new SwordSet(), this);
        getServer().getPluginManager().registerEvents(new Event(), this);


    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
