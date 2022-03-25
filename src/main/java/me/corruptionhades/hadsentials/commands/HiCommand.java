package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class HiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;
            Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
            String noperm = plugin.getConfig().getString("no-perm");

            if(p.hasPermission("hadsentials.command.hi")){
                p.sendMessage("Hey!");
            }else {
                p.sendMessage(noperm);
            }
        }
        return true;
    }
}
