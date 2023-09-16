package dev.vaaaleh.hub.menu;

import dev.vaaaleh.hub.util.BungeeUtils;
import dev.vaaaleh.hub.util.CC;
import dev.vaaaleh.hub.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SelectorMenu implements Listener {

    public static void openMenu(Player player) {
        Inventory i = Bukkit.createInventory(null, 9*3, name());

        for (int x=0; x<i.getSize(); x++) {
            i.setItem(x, getFiller());
        }

        i.setItem((9*2) - 5, getServerItem());
        i.setItem((9*3) -1, getLeaveItem());

        player.openInventory(i);
    }

    public static String name() {
        return CC.color("&b&lConnect to a Server");
    }

    private static ItemStack getServerItem() {
        return new ItemBuilder(Material.DIAMOND_SWORD)
                .name(CC.AQUA + "NA Practice")
                .lore(CC.GREEN + "Click to connect.")
                .build();
    }

    private static ItemStack getLeaveItem() {
        return new ItemBuilder(Material.INK_SACK)
                .name(CC.RED + "Disconnect")
                .lore(CC.GREEN + "Click to disconnect.")
                .build();
    }

    private static ItemStack getFiller() {
        return new ItemBuilder(Material.STAINED_GLASS_PANE)
                .name(" ")
                .durability(15)
                .build();
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        event.setCancelled(true);

        if (event.getCurrentItem() == null) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Disconnect")) {
            event.setCancelled(true);
            player.kickPlayer("Thank you for flying PvPLounge");

        }
        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Practice")) {
            event.setCancelled(true);
            BungeeUtils.sendPlayerToServer(player, "practice");
        }
    }
}
