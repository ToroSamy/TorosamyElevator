package net.torosamy.ironelevatorywy;

import net.torosamy.ironelevatorywy.commands.ReloadCommand;
import net.torosamy.ironelevatorywy.listener.DownElevator;
import net.torosamy.ironelevatorywy.listener.UpElevator;
import net.torosamy.ironelevatorywy.utils.DataUtils;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IronElevatorYwY extends JavaPlugin {
    private static IronElevatorYwY plugin;
    private static List<String> disableWorldList = new ArrayList<>();
    private static Integer minDistance;
    private static Integer maxDistance;
    private static Map<String, String> lang = new HashMap<>();




    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new DownElevator(),this);
        this.getServer().getPluginManager().registerEvents(new UpElevator(),this);
        this.getCommand("ieywy").setExecutor(new ReloadCommand());
        DataUtils.reloadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static IronElevatorYwY getPlugin() {
        return plugin;
    }
    public static List<String> getDisableWorldList() {
        return disableWorldList;
    }
    public static void setDisableWorldList(List<String> worldList) {
        IronElevatorYwY.disableWorldList = worldList;
    }
    public static Integer getMinDistance() {
        return minDistance;
    }
    public static void setMinDistance(Integer minDistance) {
        IronElevatorYwY.minDistance = minDistance;
    }
    public static Integer getMaxDistance() {
        return maxDistance;
    }
    public static void setMaxDistance(Integer maxDistance) {
        IronElevatorYwY.maxDistance = maxDistance;
    }
    public static Map<String, String> getLang() {
        return lang;
    }




}
