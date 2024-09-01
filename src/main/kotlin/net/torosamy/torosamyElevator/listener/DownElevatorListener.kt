package net.torosamy.torosamyElevator.listener

import net.torosamy.torosamyElevator.utils.ConfigUtil
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent


class DownElevatorListener : Listener {
    @EventHandler
    fun doDown(event: PlayerToggleSneakEvent) {
        val player = event.player
        val location = player.location
        val block = location.block.getRelative(BlockFace.DOWN)


        if (player.isFlying) return
        if (player.isSneaking) return
        if (block.type != Material.getMaterial(ConfigUtil.mainConfig.enableItem)) return
        if (ConfigUtil.mainConfig.disableWorlds.contains(location.world.name)) return
        if (!player.hasPermission("torosamyElevator.use")) return
        if (ConfigUtil.mainConfig.disablePlayers.contains(player.name)) return

        val min: Int = ConfigUtil.mainConfig.minDistance
        val max: Int = ConfigUtil.mainConfig.maxDistance

        for (index in min until max) {
            val tempBlock = block.getRelative(BlockFace.DOWN, index)
            if (tempBlock.type == Material.getMaterial(ConfigUtil.mainConfig.enableItem)) {
                location.y -= index
                player.teleport(location)
                player.playSound(location, Sound.ENTITY_IRON_GOLEM_ATTACK, 20f, 20f)
                return
            }
        }
    }
}