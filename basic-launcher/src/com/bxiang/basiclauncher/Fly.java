package com.bxiang.basiclauncher;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Hello console!");
				return true;
			}
			Player player = (Player) sender;
			
			if (args.length == 0) {
				player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooom!");
				player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
			} else {
				if (isNum(args[0])) {
					int multiplier = Integer.parseInt(args[0]);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooom!");
					player.setVelocity(player.getLocation().getDirection().multiply(multiplier).setY(2));
				} else {
					player.sendMessage("Usage: launch <numerical-multiplier>");
				}
			}
			return true;
		}
		
		return false;
	}

	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
