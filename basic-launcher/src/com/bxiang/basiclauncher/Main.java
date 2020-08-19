package com.bxiang.basiclauncher;

import org.bukkit.plugin.java.JavaPlugin;
/*
 * Plan: /launch,	/launch <number>
 */
public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("Launch").setExecutor(new Fly());
	}
	
	@Override
	public void onDisable() {
		
	}
}
