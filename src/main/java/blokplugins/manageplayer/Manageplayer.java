package blokplugins.manageplayer;

import Commands.manageCommand;
import blokplugins.manageplayer.Listners.manageListner;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manageplayer extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Manage player system is loading");
        this.getCommand("manage").setExecutor(new manageCommand());
        getServer().getPluginManager().registerEvents(new manageListner(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Manage player system is loading");
    }
}
