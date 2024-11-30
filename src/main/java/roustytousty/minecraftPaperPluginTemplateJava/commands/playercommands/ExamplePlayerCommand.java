package roustytousty.minecraftPaperPluginTemplateJava.commands.playercommands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import roustytousty.minecraftPaperPluginTemplateJava.managers.StringManager;

public class ExamplePlayerCommand extends StringManager implements CommandExecutor {

    // This method is called, whenever the selected command is called
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] strings) {

        // Check if a player executed the command.
        if (!(sender instanceof Player player)) {
            return false;
        }

        // Now execute any code related to the command
        player.sendMessage(parse("&6You &fexecuted the example &6player &fcommand!"));

        return true;
    }
}