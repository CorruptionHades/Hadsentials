package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import me.corruptionhades.hadsentials.utils.LanguageFilesUtils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class LanguageCommand implements CommandExecutor {

    Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("hadsentials.command.language")){
                if (args.length == 1) {
                    switch (args[0]) {
                        case "eng":
                            plugin.saveConfig();
                            player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
                            String engChange = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "language-change");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + " " + engChange + " English!"));
                            break;
                        case "ger":
                            plugin.saveConfig();
                            player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
                            String gerChange = LanguageFilesUtils.getValue(plugin.getConfig().getString("language"), "language-change");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + " " + gerChange + " Deutsch!"));
                            break;
                    }
                }
            }
        }

        return true;
    }
}
