package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import me.corruptionhades.hadsentials.utils.LanguageFilesUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class BroadcastCommand implements CommandExecutor {

    Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "noperms");

        String prefix = plugin.getConfig().getString("prefix");

        if(sender instanceof Player){

            if(p.hasPermission("hadsentials.command.broadcast")){

                StringBuilder message = new StringBuilder();
                for (int i = 0; i != args.length; ++i) {
                    message.append(args[i]).append(" ");
                }

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix")) + "§f " + ChatColor.translateAlternateColorCodes('&',String.valueOf(message)));

            }else {
                p.sendMessage(noperm);
            }
        }
        return true;
    }
}
