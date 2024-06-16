package blokplugins.manageplayer;

import blokplugins.manageplayer.listners.ManageListner;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manageplayer extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Manage player system is loading");
        this.getCommand("manage").setExecutor(new Commands.ManageCommand());
        getServer().getPluginManager().registerEvents(new ManageListner(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Manage player system is loading");
    }
}
