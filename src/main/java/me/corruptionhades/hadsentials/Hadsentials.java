package me.corruptionhades.hadsentials;

import me.corruptionhades.hadsentials.commands.*;

import me.corruptionhades.hadsentials.events.GodModeEvent;
import me.corruptionhades.hadsentials.events.PlayerChatColorEvent;
import me.corruptionhades.hadsentials.utils.LanguageFilesUtils;
import me.corruptionhades.hadsentials.utils.VanishManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hadsentials extends JavaPlugin {

    private static Hadsentials instance;
    private VanishManager vanishManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        LanguageFilesUtils.loadValues();

        instance = this;
        this.vanishManager = new VanishManager(this);

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
        getCommand("lang").setExecutor(new LanguageCommand());
        getCommand("gms").setExecutor(new GamemodeCommand());
        getCommand("gma").setExecutor(new GamemodeCommand());
        getCommand("gmc").setExecutor(new GamemodeCommand());
        getCommand("gmsp").setExecutor(new GamemodeCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("gm").setExecutor(new GmCommand());

        //EVENTS
        getServer().getPluginManager().registerEvents(new GodModeEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatColorEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Hadsentials getInstance() {
        return instance;
    }

    public VanishManager getVanishManager() {
        return this.vanishManager;
    }
}
