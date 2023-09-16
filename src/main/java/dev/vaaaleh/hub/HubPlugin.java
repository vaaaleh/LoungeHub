package dev.vaaaleh.hub;

import dev.vaaaleh.hub.menu.SelectorMenu;
import dev.vaaaleh.hub.task.InventoryTask;
import dev.vaaaleh.hub.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class HubPlugin extends JavaPlugin {

    private static HubPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        setupBungeeListgener();
        registerListeners();
        startRunnable();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void startRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                getServer().getOnlinePlayers().stream()
                        .filter(player -> !player.getOpenInventory().getTitle().equals(SelectorMenu.name()))
                        .forEach(SelectorMenu::openMenu);
            }
        }.runTaskTimerAsynchronously(this, 1L, 1L);

    }
    private void setupBungeeListgener() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new SelectorMenu(), this);
    }

    public static HubPlugin getInstance() {
        return instance;
    }
}
