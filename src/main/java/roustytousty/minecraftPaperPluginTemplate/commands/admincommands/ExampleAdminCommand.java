package roustytousty.minecraftPaperPluginTemplate.commands.admincommands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import roustytousty.minecraftPaperPluginTemplateJava.managers.StringManager;

public class ExampleAdminCommand extends StringManager implements CommandExecutor {

    // This method is called, whenever the selected command is called
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] strings) {

        // Check if a player executed the command.
        if (!(sender instanceof Player player)) {
            return false;
        }

        // Check if player has op
        if (!(player.isOp())) {
            player.sendMessage(parse("&cYou don't have the permission to use this command!"));
            return false;
        }

        /*
        Example on how to check for a specific permission
        if (!(player.hasPermission("YourPlugin.adminCommands"))) {
            player.sendMessage(parse("&cYou don't have the permission to use this command!"));
            return false;
        }
         */

        // Now execute any code related to the command
        player.sendMessage(parse("&6You &fexecuted the example &6admin &fcommand!"));

        return true;
    }
}
