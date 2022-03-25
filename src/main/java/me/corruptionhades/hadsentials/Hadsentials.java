package me.corruptionhades.hadsentials;

import me.corruptionhades.hadsentials.commands.*;

import me.corruptionhades.hadsentials.events.GodModeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hadsentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("------------------");
        System.out.println("--Hadsentials by--");
        System.out.println("-CorruptionHades!-");
        System.out.println("------------------");


        //COMMANDS
        getCommand("see").setExecutor(new SeeCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("hi").setExecutor(new HiCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("hereload").setExecutor(new HEReloadCommand());
        getCommand("fly").setExecutor(new FlyCommand());

        //EVENTS
        getServer().getPluginManager().registerEvents(new GodModeEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
