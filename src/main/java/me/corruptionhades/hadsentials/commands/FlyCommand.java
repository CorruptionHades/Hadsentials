package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = plugin.getConfig().getString("no-perm");

        if(sender instanceof Player){

            if(p.hasPermission("hadsentials.command.fly")){
                if(args.length == 0) {
                    if(p.getAllowFlight()){
                        p.setAllowFlight(false);
                        p.sendMessage("§7You can no longer §cfly.");
                    }else {
                        p.setAllowFlight(true);
                        p.sendMessage("§7You can now §afly.");
                    }
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        if(target.getAllowFlight()){
                            target.setAllowFlight(false);
                            target.sendMessage("§7You can no longer §cfly.");
                            p.sendMessage("§a" + target.getDisplayName() + "§7 can no longer fly.");
                        }else {
                            target.setAllowFlight(true);
                            target.sendMessage("§7You can now §afly.");
                            p.sendMessage("§a" + target.getDisplayName() + "§7 can now fly.");
                        }
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
