package com.bxiang.doctor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

/*
 * Plan: /doctor	/doctor healme
 */
public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("doctor")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("healing not applicable to console");
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("doctor.use")) {
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
			if (args.length == 0) {
				TextComponent msg = new TextComponent("Would you like to be healed?");
				msg.setColor(ChatColor.GOLD);
				msg.setBold(true);
				msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, 
						new ComponentBuilder("Click here to be healed!").color(ChatColor.GRAY).italic(true).create()));
				player.spigot().sendMessage(msg);
			} else if (args[0].equalsIgnoreCase("healme")) {
				player.setHealth(20.0);
				//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal " + player.getName());
				player.sendMessage(ChatColor.GREEN + "You have been healed!");
			} else {
				player.sendMessage(ChatColor.RED + "Usage: /doctor");
			}
			return true;
		}
		return false;
	}

}
