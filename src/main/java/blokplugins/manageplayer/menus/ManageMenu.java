package blokplugins.manageplayer.menus;

import blokplugins.manageplayer.holders.ManageHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ManageMenu {
    public Inventory inv;

    public ManageMenu(Player player, Player target) {
        inv = Bukkit.createInventory(new ManageHolder(), 27, "Manage " + target.getDisplayName());
        initializeItems(target);
        player.openInventory(inv);
    }

    public void initializeItems(Player target) {
        ItemStack empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta emptymeta = empty.getItemMeta();
        emptymeta.setDisplayName(" ");
        empty.setItemMeta(emptymeta);
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, empty);
        }
        ItemStack clear = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta clearmeta = clear.getItemMeta();
        clearmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLEAR INVENTORY");
        clear.setItemMeta(clearmeta);
        inv.setItem(12, clear);

        ItemStack echest = new ItemStack(Material.ENDER_CHEST);
        ItemMeta echestmeta = echest.getItemMeta();
        echestmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLEAR ENDER CHEST");
        echest.setItemMeta(echestmeta);
        inv.setItem(14, echest);

        ItemStack ban = new ItemStack(Material.REDSTONE);
        ItemMeta banmeta = ban.getItemMeta();
        banmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "BAN THE USER");
        ban.setItemMeta(banmeta);
        inv.setItem(13, ban);

        ItemStack kcik = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta kickmeta = kcik.getItemMeta();
        kickmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "KICK THE USER");
        kcik.setItemMeta(kickmeta);
        inv.setItem(22, kcik);

        ItemStack targethead = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta headmeta = targethead.getItemMeta();
        headmeta.setDisplayName(target.getName());
        targethead.setItemMeta(headmeta);
        inv.setItem(0, targethead);
    }
}
