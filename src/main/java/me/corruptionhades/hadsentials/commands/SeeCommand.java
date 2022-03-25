package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;

public class SeeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = plugin.getConfig().getString("no-perm");

        if(sender instanceof Player){
            if(sender.hasPermission("hadsentials.command.see")){
                if(args.length == 0) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 210000, 1));

                    p.sendMessage("§7You can now §asee.");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 210000, 1));

                        target.sendMessage("§7You can now §asee.");
                        p.sendMessage("§a" + target.getDisplayName() + "§7 can now see.");
                    }else{
                        p.sendMessage("§cThat player does not exist.");
                    }
                }
            }else {
                p.sendMessage(noperm);
            }

        }else{
            System.out.println( "You need to be a player to execute this command!");
        }

        return true;
    }
}
