package net.torosamy.torosamyElevator.commands

import net.torosamy.torosamyCore.utils.MessageUtil
import net.torosamy.torosamyElevator.utils.ConfigUtil
import org.bukkit.command.CommandSender
import org.incendo.cloud.annotations.Command
import org.incendo.cloud.annotations.CommandDescription
import org.incendo.cloud.annotations.Permission


class AdminCommands {
    @Command(value = "te reload")
    @Permission("torosamyElevator.reload")
    @CommandDescription("重载TorosamyElevator配置文件")
    fun reloadConfig(sender: CommandSender) {
        ConfigUtil.reloadConfig()
        sender.sendMessage(MessageUtil.text(ConfigUtil.langConfig.reloadMessage))
    }
}