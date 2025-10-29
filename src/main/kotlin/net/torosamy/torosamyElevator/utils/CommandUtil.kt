package net.torosamy.torosamyElevator.utils

import net.torosamy.torosamyCore.TorosamyCore
import net.torosamy.torosamyCore.commands.CommandManager
import net.torosamy.torosamyElevator.TorosamyElevator
import net.torosamy.torosamyElevator.commands.AdminCommands
import net.torosamy.torosamyElevator.commands.PlayerCommands


class CommandUtil {
    companion object {
        private val commanderManager: CommandManager = CommandManager(TorosamyElevator.plugin)

        public val ADMIN_COMMANDS: AdminCommands = AdminCommands();
        public val PLAYER_COMMANDS: PlayerCommands = PlayerCommands();

        fun registerCommand() {
            commanderManager.annotationParser.parse(ADMIN_COMMANDS)
            commanderManager.annotationParser.parse(PLAYER_COMMANDS)
        }
    }
}