package bs.untitled10.Utils;

import org.bukkit.plugin.java.JavaPlugin;

public interface SubPlugin {
    void onEnable(JavaPlugin plugin);
    void onDisable();
}
