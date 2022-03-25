package me.corruptionhades.hadsentials.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatColorEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){

        Player player = e.getPlayer();

        if(player.hasPermission("hadsentials.chatcolor")){
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        }
    }
}
