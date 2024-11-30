package roustytousty.minecraftPaperPluginTemplate.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import roustytousty.minecraftPaperPluginTemplateJava.managers.GuiManager;

public class ExampleGui extends GuiManager implements Listener {

    private Inventory inv;

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() != inv) {
            return;
        }

        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir()) {
            return;
        }

        Player p = (Player) event.getWhoClicked();

        // Check for clicked slots
        if (event.getRawSlot() == 18) {
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
        }
    }

    @EventHandler
    private void onInventoryDrag(InventoryDragEvent event) {
        if (event.getInventory() == inv) {
            event.setCancelled(true);
        }
    }

    public void openInventory(Player player) {
        inv = Bukkit.createInventory(null, 27, "Example Title");
        initItems(player);
        player.openInventory(inv);
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
    }

    private void initItems(Player player) {
        int[] slots = {0, 8, 9, 17, 26};
        for (int slot : slots) {
            inv.setItem(slot, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, 1, false, "&f"));
        }

        /*
            Create gui items:

            inv.setItem(
                @params: Int slot,
                @params: ItemStack createGuiItem(
                    @params: Material material,
                    @params: Int amount,
                    @params: Boolean glow,
                    @params: String name,
                    @params: ...String lore,
                )
            )
         */
        inv.setItem(12, createGuiItem(
                Material.DIAMOND,
                1,
                false,
                "&eExample Gui Item",
                "&7Hello I am the example lore!"
        ));

        /*
            Create player heads:

            inv.setItem(
                @params: Int slot,
                @params: ItemStack createPlayerHead(
                    @params: Player player,
                    @params: String name,
                    @params: ...String lore,
                )
            )
         */
        inv.setItem(12, createPlayerHead(
                player,
                "&eExample Gui Player Head",
                "&7Hello I am also the example lore!"
        ));

        inv.setItem(18, createGuiItem(Material.RED_STAINED_GLASS_PANE, 1, false, "&cClose"));
    }
}
