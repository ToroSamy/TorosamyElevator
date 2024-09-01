package net.torosamy.torosamyElevator.utils

import net.torosamy.torosamyCore.TorosamyCore
import net.torosamy.torosamyElevator.commands.AdminCommands
import net.torosamy.torosamyElevator.commands.PlayerCommands


class CommandUtil {
    companion object {
        fun registerCommand() {
            TorosamyCore.commanderManager.annotationParser.parse(AdminCommands())
            TorosamyCore.commanderManager.annotationParser.parse(PlayerCommands())
        }
    }
}