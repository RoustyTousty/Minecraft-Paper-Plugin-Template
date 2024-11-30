package roustytousty.minecraftPaperPluginTemplate.commands.guicommands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import roustytousty.minecraftPaperPluginTemplateJava.gui.ExampleGui;

public class ExampleGuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String title, @NotNull String[] strings) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        // Open the specific GUI
        ExampleGui gui = new ExampleGui();
        gui.openInventory(player);

        return true;
    }
}
