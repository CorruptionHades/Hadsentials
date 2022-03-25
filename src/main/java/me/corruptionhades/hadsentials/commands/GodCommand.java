package me.corruptionhades.hadsentials.commands;

import me.corruptionhades.hadsentials.Hadsentials;
import me.corruptionhades.hadsentials.events.GodModeEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GodCommand implements CommandExecutor {

    public static ArrayList<String> god = new ArrayList();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Plugin plugin = Hadsentials.getPlugin(Hadsentials.class);
        String noperm = plugin.getConfig().getString("no-perm");

        if (sender instanceof Player) {

            if (p.hasPermission("hadsentials.command.god")) {

                if(args.length == 0){
                    final boolean b = GodModeEvent.GODS.contains(p) ? GodModeEvent.GODS.remove(p) : GodModeEvent.GODS.add((Player) p);
                    p.sendMessage("§7God mode " + (GodModeEvent.GODS.contains(p) ? "§aenabled" : "§cdisabled") + "§7.");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        final boolean b = GodModeEvent.GODS.contains(target) ? GodModeEvent.GODS.remove(target) : GodModeEvent.GODS.add((Player) target);
                        target.sendMessage("§7God mode " + (GodModeEvent.GODS.contains(target) ? "§aenabled" : "§cdisabled") + "§7.");
                        p.sendMessage("§7God mode " + (GodModeEvent.GODS.contains(target) ? "§aenabled" : "§cdisabled") + "§7 for player §e" + target.getDisplayName() + "§7.");
                    }
                }
            } else{
                    p.sendMessage(noperm);
                }
            }
        return true;
    }
}
