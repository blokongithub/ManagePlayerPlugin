package blokplugins.manageplayer.Menus;

import blokplugins.manageplayer.Holders.manageHolder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class manageMenu {
    public Inventory inv;
    public manageMenu(Player player, Player target) {
        inv = Bukkit.createInventory(new manageHolder(), 27, "Manage " + target.getDisplayName());
        initializeItems();
        player.openInventory(inv);
    }
    public void initializeItems() {
        ItemStack clear = new ItemStack(Material.REDSTONE_BLOCK);
        inv.setItem(13, clear);
    }
}
