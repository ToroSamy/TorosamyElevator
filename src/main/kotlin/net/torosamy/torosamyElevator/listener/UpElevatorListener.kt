package net.torosamy.torosamyElevator.listener

import net.torosamy.torosamyElevator.utils.ConfigUtil
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent


class UpElevatorListener :Listener{
    @EventHandler
    fun doUp(event: PlayerMoveEvent) {
        val player = event.player
        val location = player.location
        val block = event.to.block.getRelative(BlockFace.DOWN)

        if (player.isFlying) return
        if (!(event.from.y < event.to.y)) return
        if (block.type != Material.getMaterial(ConfigUtil.getMainConfig().enableItem)) return
        if (ConfigUtil.getMainConfig().disableWorlds.contains(location.world.name)) return
        if (!player.hasPermission("torosamyElevator.use")) return
        if (ConfigUtil.getMainConfig().disablePlayers.contains(player.name)) return

        val min: Int = ConfigUtil.getMainConfig().minDistance
        val max: Int = ConfigUtil.getMainConfig().maxDistance


        for (index in min until max) {
            val tempBlock = block.getRelative(BlockFace.UP, index)
            if (tempBlock.type == Material.getMaterial(ConfigUtil.getMainConfig().enableItem)) {
                location.y += index
                player.teleport(location)
                player.playSound(location, Sound.ENTITY_IRON_GOLEM_ATTACK, 20f, 20f)
                return
            }
        }
    }
}