package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = plugin.getConfig().getString("no-perm");

        if(sender instanceof Player){
            if(p.hasPermission("hadsentials.command.heal")){
                if(args.length == 0){

                    p.setHealth(20);
                    p.setFoodLevel(20);

                    p.sendMessage("§7You have been healed.");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player){

                        target.setHealth(20);
                        target.setFoodLevel(20);

                        p.sendMessage("§7You have healed §a" + target.getDisplayName() + "§7.");
                        target.sendMessage("§7You have been healed.");

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
