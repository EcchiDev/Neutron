package com.ecchidev.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class CommandHeal implements CommandExecutor {

	public Neutron plugin;

	public CommandHeal(Neutron plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		String sfix = ChatColor.AQUA + "["+ plugin.getName() + "] ";

		if (cmd.getName().equalsIgnoreCase("starve")) {
			Player p = (Player) sender;

			if (args.length == 0) {
				p.setHealth(1);
				p.setSaturation(0);
				p.setFoodLevel(0);
				p.sendMessage(sfix + ChatColor.RED + "You are starving!");
				return false;
			}
			if (args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target != null) {
					target.setHealth(1);
					target.setSaturation(0);
					target.setFoodLevel(0);
					target.sendMessage(sfix + ChatColor.RED
							+ " you are starving because of " + ChatColor.AQUA
							+ p.getDisplayName());
					p.sendMessage(sfix + ChatColor.AQUA
							+ target.getDisplayName() + ChatColor.RED
							+ " is now starving!");
				} else {
					p.sendMessage(sfix + ChatColor.RED
							+ "That player isn't online or doesn't exist!");
				}
				return false;
			}
			if (args.length >= 2) {
				p.sendMessage(sfix + ChatColor.RED
						+ "/starve (starve yourself)");
				p.sendMessage(sfix + ChatColor.RED
						+ "/starve <player>(starve other player)");
				return false;
			}

		}

		if (cmd.getName().equalsIgnoreCase("heal")) {
			Player p = (Player) sender;

			if (args.length == 0) {
				p.setHealth(20);
				p.setSaturation(20);
				p.setFoodLevel(20);
				p.sendMessage(sfix + ChatColor.GREEN + "You have been healed!");
				return false;
			}
			if (args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target != null) {
					target.setHealth(20);
					target.setSaturation(20);
					target.setFoodLevel(20);
					target.sendMessage(sfix + ChatColor.AQUA
							+ p.getDisplayName() + ChatColor.GREEN
							+ " healed you!");
					p.sendMessage(sfix + ChatColor.AQUA
							+ target.getDisplayName() + ChatColor.GREEN
							+ " has been healed!");
				} else {
					p.sendMessage(sfix + ChatColor.RED
							+ "That player isn't online or doesn't exist!");
				}
				return false;
			}
			if (args.length >= 2) {
				p.sendMessage(sfix + ChatColor.RED + "/heal (heal yourself)");
				p.sendMessage(sfix + ChatColor.RED
						+ "/heal <player>(heal other player)");
				return false;
			}

		}

		return false;
	}

}
