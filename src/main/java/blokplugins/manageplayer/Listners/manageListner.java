package blokplugins.manageplayer.Listners;

import blokplugins.manageplayer.Holders.manageHolder;
import blokplugins.manageplayer.Menus.manageMenu;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class manageListner implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof manageHolder) {
            Player player = (Player) e.getWhoClicked();
            Player target = Bukkit.getPlayer(e.getView().getItem(0).getItemMeta().getDisplayName());

            if (target == null) {
                return;
            }
            if (e.getRawSlot() < 27) {
                if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
                    target.getInventory().clear();
                } else if (e.getCurrentItem().getType() == Material.ENDER_CHEST) {
                    target.getEnderChest().clear();
                } else if (e.getCurrentItem().getType() == Material.NETHERITE_BOOTS) {
                    target.kickPlayer(player.getDisplayName() + " has kicked you");
                } else if (e.getCurrentItem().getType() == Material.REDSTONE) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "You have been banned by " + player.getDisplayName(), null, player.getDisplayName());
                    target.kickPlayer("You have been banned by " + player.getDisplayName());
                }

                e.setCancelled(true);
            }
        }
    }
}
