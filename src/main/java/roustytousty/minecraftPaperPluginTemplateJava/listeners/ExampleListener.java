package roustytousty.minecraftPaperPluginTemplateJava.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import roustytousty.minecraftPaperPluginTemplateJava.managers.StringManager;

public class ExampleListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(StringManager.parse("&fThis person joined: &6" + player.getName()));
    }
}
