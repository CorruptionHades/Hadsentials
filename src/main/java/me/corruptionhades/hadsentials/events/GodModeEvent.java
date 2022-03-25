package me.corruptionhades.hadsentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class GodModeEvent implements Listener {

    public static List<Player> GODS;

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    public void onDamage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && GODS.contains(e.getEntity())) {

            e.setCancelled(true);

            ((Player)e.getEntity()).setHealth(((Player)e.getEntity()).getMaxHealth());
        }
    }

    static {
        GODS = new ArrayList<Player>();
    }
}
