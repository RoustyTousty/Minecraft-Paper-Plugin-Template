package roustytousty.minecraftPaperPluginTemplateJava.managers;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiManager {

    public ItemStack createGuiItem(
            Material material,
            int amount,
            boolean glow,
            String name,
            String... lore
    ) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        // Set item display name (using StringUtils for parsing)
        if (name != null) {
            meta.setDisplayName(StringManager.parse(name));
        }

        // Add default attribute modifiers and hide attributes flag
        meta.setAttributeModifiers(item.getType().getDefaultAttributeModifiers(EquipmentSlot.HAND));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        // Add lore if provided
        if (lore.length > 0) {
            List<String> loreList = new ArrayList<>();
            for (String s : lore) {
                if (s != null) {
                    loreList.add(StringManager.parse(s));
                }
            }
            meta.setLore(loreList);
        }

        // Apply glow if requested
        if (glow) {
            meta.addEnchant(Enchantment.MENDING, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createPlayerHead(OfflinePlayer player, String name, String... lore) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        // Set player head owner
        meta.setOwningPlayer(player);

        // Set display name
        if (name != null) {
            meta.setDisplayName(StringManager.parse(name));
        }

        // Add lore if provided
        if (lore.length > 0) {
            List<String> loreList = new ArrayList<>();
            for (String s : lore) {
                if (s != null) {
                    loreList.add(StringManager.parse(s));
                }
            }
            meta.setLore(loreList);
        }

        item.setItemMeta(meta);
        return item;
    }
}
