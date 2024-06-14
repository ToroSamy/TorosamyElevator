package net.torosamy.ironelevatorywy.commands;

import net.torosamy.ironelevatorywy.IronElevatorYwY;
import net.torosamy.ironelevatorywy.utils.DataUtils;
import net.torosamy.ironelevatorywy.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] strings) {
        if (!"ieywy".equalsIgnoreCase(label)) return true;

        if (strings.length == 1 && commandSender.hasPermission("ironelevatorywy.reload")) {
            if ("reload".equalsIgnoreCase(strings[0])) {
                DataUtils.reloadConfig();
                commandSender.sendMessage(MessageUtils.text(IronElevatorYwY.getLang().get("reload-successful")));
                return true;
            }
        }
        commandSender.sendMessage(MessageUtils.text(IronElevatorYwY.getLang().get("reload-help")));
        return true;
    }
}
