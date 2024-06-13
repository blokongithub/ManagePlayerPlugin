package Commands;

import blokplugins.manageplayer.Menus.manageMenu;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class manageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    player.sendMessage("Target doesn't exist");
                    return true;
                } else {
                    player.sendMessage(target.getDisplayName());
                    new manageMenu(player, target);
                }

            } else if (args.length != 1) {
                player.sendMessage("The correct usage is /manage <username>");
            }

        }
        return false;
    }
}
