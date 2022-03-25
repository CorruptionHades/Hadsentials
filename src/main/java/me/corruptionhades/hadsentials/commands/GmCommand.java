package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import me.corruptionhades.hadsentials.utils.LanguageFilesUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "noperms");
        String gm = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "gamemode");

        //SELF
        if(args.length == 1){
            if(command.getName().equalsIgnoreCase("gm")){
                //SURVIVAL
                if (p.hasPermission("hadsentials.command.gm.0")) {
                    if(args[0].equalsIgnoreCase("0")){
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aSurvival"));
                    }
                }else {
                    p.sendMessage(noperm);
                }

                //CREATIVE
                if (p.hasPermission("hadsentials.command.gm.1")) {
                    if(args[0].equalsIgnoreCase("1")){
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aCreative"));
                    }
                }else {
                    p.sendMessage(noperm);
                }

                if (p.hasPermission("hadsentials.command.gm.2")) {
                    if(args[0].equalsIgnoreCase("2")){
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aAdventure"));
                    }
                }else {
                    p.sendMessage(noperm);
                }

                if (p.hasPermission("hadsentials.command.gm.3")) {
                    if(args[0].equalsIgnoreCase("3")){
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aSpectator"));
                    }
                }else {
                    p.sendMessage(noperm);
                }
            }
        }

        //TARGET
        else {
            Player target = Bukkit.getPlayerExact(args[1]);

            if (target instanceof Player) {
                //SURVIVAL
                if (args[0].equalsIgnoreCase("0")) {
                    target.setGameMode(GameMode.SURVIVAL);
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aSurvival"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aSurvival"));
                }

                //CREATIVE
                if (args[0].equalsIgnoreCase("1")) {
                    target.setGameMode(GameMode.CREATIVE);
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aCreative"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aCreative"));
                }

                //ADVENTURE
                if (args[0].equalsIgnoreCase("2")) {
                    target.setGameMode(GameMode.ADVENTURE);
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aAdventure"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aAdventure"));
                }

                //SPECTATOR
                if (args[0].equalsIgnoreCase("3")) {
                    target.setGameMode(GameMode.SPECTATOR);
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aSpectator"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aSpectator"));
                }
            }
        }
        return true;
    }
}
