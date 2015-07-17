package com.ecchidev.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class CommandFly implements CommandExecutor {
	
	public Neutron plugin;
	
	public CommandFly(Neutron plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fly")) {
			Player p = (Player) sender;
			if (args.length != 0) {
				p.sendMessage(ChatColor.RED + "Too many arguments");
				return true;
			}
			p.setAllowFlight(!p.getAllowFlight());
			p.sendMessage(ChatColor.YELLOW
					+ "Flying has been "
					+ (p.getAllowFlight()
							? ChatColor.GREEN + "enabled"
							: ChatColor.RED + "disabled"));
			return false;
		}

		return false;
	}

}
