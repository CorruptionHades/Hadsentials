package me.corruptionhades.hadsentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class VanishManager {
    private Plugin plugin;
    private ArrayList<Player> vanished;
    public VanishManager(Plugin plugin) {
        this.plugin = plugin;
        this.vanished = new ArrayList<Player>();
    }

    public ArrayList<Player> getVanished() {
        return this.vanished;
    }
    public boolean isVanished(Player player) {
        return this.vanished.contains(player);
    }
    public void setVanished(Player player, boolean toggled) {
        if (toggled) {
            this.vanished.add(player);
        }else {
            this.vanished.remove(player);
        }
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (player.equals(onlinePlayer)) continue;
            if (toggled) {
                onlinePlayer.hidePlayer(player);
            }
            onlinePlayer.showPlayer(player);
        }
    }
    public void hideAll (Player player) {
        this.vanished.forEach(player1 -> player.hidePlayer((Player) player1));
    }
}
