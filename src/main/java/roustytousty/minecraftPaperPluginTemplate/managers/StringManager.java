package roustytousty.minecraftPaperPluginTemplate.managers;

import org.bukkit.ChatColor;

public class StringManager {

    public static String parse(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
