package net.torosamy.torosamyElevator

import net.torosamy.torosamyCore.utils.MessageUtil
import net.torosamy.torosamyElevator.utils.CommandUtil
import net.torosamy.torosamyElevator.utils.ConfigUtil
import net.torosamy.torosamyElevator.utils.ListenerUtil
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class TorosamyElevator : JavaPlugin() {

    companion object{lateinit var plugin: TorosamyElevator}
    override fun onEnable() {
        plugin = this
        ConfigUtil.reloadConfig()

        CommandUtil.registerCommand()
        ListenerUtil.registerListener()

        Bukkit.getConsoleSender().sendMessage(MessageUtil.text("&a[服务器娘]&a插件 &eTorosamyElevator &a成功开启喵~"))
        Bukkit.getConsoleSender().sendMessage(MessageUtil.text("&a[服务器娘]&a作者 &eTorosamy|yweiyang"))
    }

    override fun onDisable() {
        ConfigUtil.saveConfig()
        Bukkit.getConsoleSender().sendMessage(MessageUtil.text("&a[服务器娘]&c插件 &eTorosamyElevator &c成功关闭喵~"))
        Bukkit.getConsoleSender().sendMessage(MessageUtil.text("&a[服务器娘]&c作者 &eTorosamy|yweiyang"))
    }
}
