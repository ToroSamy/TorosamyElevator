package net.torosamy.torosamyElevator.utils

import net.torosamy.torosamyElevator.TorosamyElevator
import net.torosamy.torosamyElevator.listener.DownElevatorListener
import net.torosamy.torosamyElevator.listener.UpElevatorListener


class ListenerUtil {
    companion object{
        fun registerListener() {
            TorosamyElevator.plugin.server.pluginManager.registerEvents(DownElevatorListener(),TorosamyElevator.plugin)
            TorosamyElevator.plugin.server.pluginManager.registerEvents(UpElevatorListener(),TorosamyElevator.plugin)
        }
    }
}