package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import me.corruptionhades.hadsentials.utils.VanishManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = plugin.getConfig().getString("no-perm");
        VanishManager vanishManager = Hadsentials.getInstance().getVanishManager();
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(p.hasPermission("hadsentials.command.vanish")){
                if(args.length == 0){
                    if (vanishManager.isVanished(player)) {
                        vanishManager.setVanished(player, false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + " &ayou are now vanished!")); //geh mal in gamemode command
                    }else {
                        vanishManager.setVanished(player, true);
                    }
                }
            }
        }

        return true;
    }
}
