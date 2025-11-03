package net.torosamy.torosamyElevator

import com.bekvon.bukkit.residence.Residence
import com.bekvon.bukkit.residence.api.ResidenceApi
import com.bekvon.bukkit.residence.containers.Flags
import com.bekvon.bukkit.residence.protection.FlagPermissions
import net.torosamy.torosamyCore.utils.MessageUtil
import net.torosamy.torosamyElevator.utils.CommandUtil
import net.torosamy.torosamyElevator.utils.ConfigUtil
import net.torosamy.torosamyElevator.utils.ListenerUtil
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class TorosamyElevator : JavaPlugin() {

    companion object{
        lateinit var plugin: TorosamyElevator
        var residenceEnabled: Boolean = false
    }
    override fun onEnable() {
        plugin = this

        if (server.pluginManager.isPluginEnabled("Residence")) {
            residenceEnabled = true
            FlagPermissions.addFlag("torosamyelevator")
        }
        
        ConfigUtil.initConfig()
        ConfigUtil.reloadConfig()

        CommandUtil.registerCommand()
        ListenerUtil.registerListener()

        Bukkit.getConsoleSender().sendMessage(MessageUtil.format("&b[服务器娘]&a插件 &eTorosamyElevator &a成功开启喵~"))
        Bukkit.getConsoleSender().sendMessage(MessageUtil.format("&b[服务器娘]&a作者 &eTorosamy|yweiyang"))
    }

    override fun onDisable() {
        ConfigUtil.saveConfig()
        Bukkit.getConsoleSender().sendMessage(MessageUtil.format("&b[服务器娘]&c插件 &eTorosamyElevator &c成功关闭喵~"))
        Bukkit.getConsoleSender().sendMessage(MessageUtil.format("&b[服务器娘]&c作者 &eTorosamy|yweiyang"))
    }
}
