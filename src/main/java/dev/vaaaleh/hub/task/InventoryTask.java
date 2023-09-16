package dev.vaaaleh.hub.task;


import dev.vaaaleh.hub.HubPlugin;
import dev.vaaaleh.hub.menu.SelectorMenu;
import dev.vaaaleh.hub.util.CC;

public class InventoryTask implements Runnable {

    private HubPlugin plugin;

    public InventoryTask(HubPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        plugin.getServer().getOnlinePlayers().stream()
                .filter(player -> !player.getOpenInventory().getTitle().equals(SelectorMenu.name()))
                .forEach(SelectorMenu::openMenu);
    }
}
