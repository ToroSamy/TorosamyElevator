package net.torosamy.torosamyElevator.config;

import net.torosamy.torosamyCore.config.IConfigManage;

import java.util.List;

public class MainConfig implements IConfigManage {
    public List<String> disableWorlds;
    public List<String> disablePlayers;
    public Integer minDistance;
    public Integer maxDistance;
    public String enableItem;
}
