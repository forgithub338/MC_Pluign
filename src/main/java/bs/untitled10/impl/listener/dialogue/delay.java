package bs.untitled10.impl.listener.dialogue;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

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

