package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = plugin.getConfig().getString("no-perm");

        if(sender instanceof Player){
            if(p.hasPermission("hadsentials.command.feed")){
                if(args.length == 0){
                    p.setFoodLevel(20);
                    p.sendMessage("§7You have been fed.");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player){

                        target.setFoodLevel(20);

                        p.sendMessage("§7You have fed §a" + target.getDisplayName() + "§7.");
                        target.sendMessage("§7You have been fed.");

                    }else{
                        p.sendMessage("§cThat player does not exist.");
                    }
                }

            }else {
                p.sendMessage(noperm);
            }
        }
        return true;
    }
}
