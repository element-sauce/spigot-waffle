package me.billxiang.sandboxplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SandboxPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The plugin starts up.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The plugin is shut down.");
    }
}
