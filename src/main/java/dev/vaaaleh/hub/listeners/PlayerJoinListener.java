package dev.vaaaleh.hub.listeners;

import dev.vaaaleh.hub.HubPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().getInventory().clear();
        event.getPlayer().teleport(new Location(HubPlugin.getInstance().getServer().getWorld("world"), 0, 1, 0, 0, 0));

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(event.getPlayer());
            event.getPlayer().hidePlayer(player);
        }
        event.getPlayer().setAllowFlight(true);
        event.getPlayer().setFlying(true);
        event.getPlayer().setFlySpeed(0F);
    }


}
