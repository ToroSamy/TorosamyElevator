package net.torosamy.ironelevatorywy.listener;

import net.torosamy.ironelevatorywy.IronElevatorYwY;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class DownElevator implements Listener {
    @EventHandler
    public void doDown(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        Block block = location.getBlock().getRelative(BlockFace.DOWN);


        if (player.isFlying()) return;
        if (player.isSneaking()) return;
        if (block.getType() != Material.IRON_BLOCK) return;
        if (IronElevatorYwY.getDisableWorldList().contains(location.getWorld().getName())) return;
        if (!player.hasPermission("ironelevatorywy.use")) return;


        int min = IronElevatorYwY.getMinDistance();
        int max = IronElevatorYwY.getMaxDistance();

        for (int index = min; index < max;index ++){
            Block tempBlock = block.getRelative(BlockFace.DOWN, index);
            if (tempBlock.getType() == Material.IRON_BLOCK) {
                location.setY(location.getY() - index);
                player.teleport(location);
                player.playSound(location,Sound.ENTITY_IRON_GOLEM_ATTACK,20,20);
                return;
            }
        }

    }
}
