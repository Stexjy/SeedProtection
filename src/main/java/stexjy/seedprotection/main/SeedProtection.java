package stexjy.seedprotection.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import stexjy.seedprotection.events.SeedProtectionListener;

public final class SeedProtection extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new SeedProtectionListener(), this);
    }
}
