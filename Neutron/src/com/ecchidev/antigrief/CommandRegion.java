package com.ecchidev.antigrief;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.ecchidev.antigrief.Messages.Msg;
import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class CommandRegion implements Listener, CommandExecutor {

	public static ChatColor AQUA = ChatColor.AQUA;
	public Neutron plugin;

	public CommandRegion(Neutron plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {


		String prefix = ChatColor.AQUA + "---" + ChatColor.GREEN;
		String suffix = ChatColor.AQUA + "---";
		String sfix = AQUA + "[" + plugin.getName() + "] ";

		if (cmd.getName().equalsIgnoreCase("region")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("" + Msg.ONLY_IN_GAME_COMMAND);
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("Please use /region help");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					p.sendMessage(prefix + "/region create <name>" + suffix);
					p.sendMessage(prefix + "/region delete <name>" + suffix);
					p.sendMessage(prefix + "/region addmember <player> <region>" + suffix);
					p.sendMessage(prefix + "/region addmember <player> <region>" + suffix);
					p.sendMessage(prefix + "/region list <player>" + suffix);
				}
				if (args[0].equalsIgnoreCase("create")) {
				}
				if (args[0].equalsIgnoreCase("delete")) {
				}
				if (args[0].equalsIgnoreCase("addmember")) {
				}
				if (args[0].equalsIgnoreCase("removemember")) {
				}
				if (args[0].equalsIgnoreCase("list")) {
				}
			}
		}

		return false;
	}
	
	public String[] onTabComplete(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		String[] arguments = {"help","create","delete","addmember","removemember","list"};
		if(cmd.getName().equalsIgnoreCase("region")) {
			if(args.length == 1) {
				
				if(!args.equals("")) {
					for(String x : arguments) {
						x.toLowerCase();
					}
				}
				Arrays.sort(arguments);
				return arguments;
			}
		}
		return null;
	}

}
