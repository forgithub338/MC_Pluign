package bs.untitled12;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class advancement {

    @SuppressWarnings("deprecation")
    public void advance(){
        Plugin p = Bukkit.getPluginManager().getPlugin("untitled12");
        assert p != null;
        p.saveResource("advancement.json", false); // 保存
        File f = new File(p.getDataFolder(), "advancement.json");
        String advancementJSON;
        StringBuilder s = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));

            String temp;
            while ((temp = reader.readLine()) != null) {
                s.append(temp);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        advancementJSON = s.toString(); // 读取
        try {
            Bukkit.getUnsafe().loadAdvancement(
                    new NamespacedKey(Untitled12.instance, "hello_advancement"),
                    // 这里不用 <插件主类名>.instance 是因为我们就在 onEnable 方法中，this 就是插件实例，没必要多此一举
                    advancementJSON
            ); // 注册
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    public void advance1(){
        Plugin p = Bukkit.getPluginManager().getPlugin("untitled12");
        assert p != null;
        p.saveResource("hello.json", false); // 保存
        File f1 = new File(p.getDataFolder(), "hello.json");
        String advancementJSON;
        StringBuilder s1 = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f1));

            String temp1;
            while ((temp1 = reader.readLine()) != null) {
                s1.append(temp1);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        advancementJSON = s1.toString(); // 读取
        try {
            Bukkit.getUnsafe().loadAdvancement(
                    new NamespacedKey(Untitled12.instance, "eee_advancement"),
                    // 这里不用 <插件主类名>.instance 是因为我们就在 onEnable 方法中，this 就是插件实例，没必要多此一举
                    advancementJSON
            ); // 注册
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
