package net.torosamy.ironelevatorywy.utils;

import net.torosamy.ironelevatorywy.IronElevatorYwY;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class DataUtils {
    public static void loadConfig() {
        FileConfiguration config = IronElevatorYwY.getPlugin().getConfig();
        IronElevatorYwY.setDisableWorldList(config.getStringList("disable-world"));

        IronElevatorYwY.setMaxDistance(config.getInt("maxDistance"));
        IronElevatorYwY.setMinDistance(config.getInt("minDistance"));

    }

    public static void loadLang() {
        File file = new File(IronElevatorYwY.getPlugin().getDataFolder(), "lang.yml");
        if (!file.exists()) IronElevatorYwY.getPlugin().saveResource("lang.yml",false);

        YamlConfiguration langFile = YamlConfiguration.loadConfiguration(file);
        langFile.getKeys(true).forEach(message -> {
            String[] split = message.split("\\.");
            IronElevatorYwY.getLang().put(split[split.length-1],langFile.getString(message));
        });
    }


    public static void reloadConfig(){
        IronElevatorYwY.getPlugin().reloadConfig();
        loadConfig();
        loadLang();
    }
}
