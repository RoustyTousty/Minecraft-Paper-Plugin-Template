package roustytousty.minecraftPaperPluginTemplateJava.commands.playercommands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import roustytousty.minecraftPaperPluginTemplateJava.managers.StringManager;

public class ExampleArgumentCommand extends StringManager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        // Check if they provided exactly 1 argument
        if (!(args.length == 1)) {
            player.sendMessage(parse("&cIncorrect usage: /<command> [string]"));
            return false;
        }

        // Using args[index] access any of the provided arguments
        player.sendMessage(parse("&6Your argument contains: &f" + args[0]));

        return true;
    }
}
