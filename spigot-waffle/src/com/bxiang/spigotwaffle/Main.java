package com.bxiang.spigotwaffle;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		// server startup, reloads, plugin reloads
		
	}
	
	@Override
	public void onDisable() {
		// shutdown, reloads (when plugin disabled)
		
	}
	
	// Plan: /hello => Welcome to Bill's Server!
		
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("hello")) { // label equivalent to cmd.getName()
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("hello.use")) {
					player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Welcome to Bill's Server!");
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1H&2a&3v&4e &5f&6u&7n&8!"));
				} else {
					player.sendMessage(ChatColor.RED + "You do not have permission.");
				}
			} else {
				sender.sendMessage("Hello console!");
			}
			return true;
		}
		
		return false;
	}
}
