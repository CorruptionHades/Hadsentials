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

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "noperms");
        String gm = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "gamemode");

        if(sender instanceof Player){

            //SELF
            if(args.length == 0) {

                //SURVIVAL
                if (command.getName().equalsIgnoreCase("gms")) {
                    if (p.hasPermission("hadsentials.command.gamemode.gms")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', gm + " &aSurvival"));
                    } else {
                        p.sendMessage(noperm);
                    }
                }
                //CREATIVE
                else if (command.getName().equalsIgnoreCase("gmc")) {
                    if (p.hasPermission("hadsentials.command.gamemode.gmc")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aCreative"));
                    } else {
                        p.sendMessage(noperm);
                    }
                }
                //ADVENTURE
                else if (command.getName().equalsIgnoreCase("gma")) {
                    if (p.hasPermission("hadsentials.command.gamemode.gma")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aAdventure"));
                    } else {
                        p.sendMessage(noperm);
                    }
                }
                //SPECTATOR
                else if (command.getName().equalsIgnoreCase("gmsp")) {
                    if (p.hasPermission("hadsentials.command.gamemode.gmsp")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aSpectator"));
                    } else {
                        p.sendMessage(noperm);
                    }
                }
            }

            //TARGET
            else{
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player) {
                    //SURVIVAL
                    if (command.getName().equalsIgnoreCase("gms")) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aSurvival"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aSurvival"));
                    }

                    //CREATIVE
                    else if (command.getName().equalsIgnoreCase("gmc")) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aCreative"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aCreative"));
                    }

                    //ADVENTURE
                    else if (command.getName().equalsIgnoreCase("gma")) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aAdventure"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aAdventure"));
                    }

                    //SPECTATOR
                    else if (command.getName().equalsIgnoreCase("gmsp")) {
                        if (command.getName().equalsIgnoreCase("gms")) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&',gm + " &aSpectator"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Set " + target.getDisplayName() + "'s gamemode to &aSpectator"));
                        }
                    }
                }
            }

        }else{
            System.out.println("You need to be a player to execute this command");
        }

        return true;
    }
}
