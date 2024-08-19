package net.torosamy.torosamyElevator.commands

import net.torosamy.torosamyCore.utils.MessageUtil
import net.torosamy.torosamyElevator.utils.ConfigUtil
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.incendo.cloud.annotations.Command
import org.incendo.cloud.annotations.CommandDescription
import org.incendo.cloud.annotations.Permission

class PlayerCommands {
    @Command(value = "te toggle", requiredSender = Player::class)
    @Permission("torosamyElevator.toggle")
    @CommandDescription("切换自己的状态")
    fun changeStatus(sender: CommandSender) {
        if(ConfigUtil.getMainConfig().disablePlayers.contains(sender.name)) {
            ConfigUtil.getMainConfig().disablePlayers.remove(sender.name)
            sender.sendMessage(MessageUtil.text(ConfigUtil.getLangConfig().toggleOpen))
            return
        }
        ConfigUtil.getMainConfig().disablePlayers.add(sender.name)
        sender.sendMessage(MessageUtil.text(ConfigUtil.getLangConfig().toggleClose))
    }
}
