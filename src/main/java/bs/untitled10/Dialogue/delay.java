package bs.untitled10.Dialogue;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class delay implements Listener {
    private static Plugin plugin = null;
    private int id = -1;
    public delay(Plugin instance){
        plugin = instance;
    }

    public delay(Runnable runnable){
    }

    public delay(Runnable runnable, long delay){
        if(plugin.isEnabled()){
            id = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, runnable, delay);
        }else{
            runnable.run();
        }
    }

}

