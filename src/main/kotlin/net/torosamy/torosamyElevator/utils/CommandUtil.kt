package net.torosamy.torosamyElevator.utils

import net.torosamy.torosamyCore.TorosamyCore
import net.torosamy.torosamyElevator.TorosamyElevator
import net.torosamy.torosamyElevator.commands.AdminCommands
import net.torosamy.torosamyElevator.commands.PlayerCommands


class CommandUtil {
    companion object {
        private var torosamyCorePlugin: TorosamyCore = TorosamyElevator.plugin.server.pluginManager.getPlugin("TorosamyCore") as TorosamyCore
        fun registerCommand() {
            torosamyCorePlugin.getCommandManager().annotationParser.parse(AdminCommands())
            torosamyCorePlugin.getCommandManager().annotationParser.parse(PlayerCommands())
        }
    }
}