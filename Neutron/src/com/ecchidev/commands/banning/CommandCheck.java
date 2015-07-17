package com.ecchidev.commands.banning;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class CommandCheck implements CommandExecutor {

	public Neutron plugin;

	public CommandCheck(Neutron plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("check")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Invalid usage: /check <usename>");
				return true;
			}
			if (args.length == 1) {
				Player online = Bukkit.getPlayer(args[0]);
				if (online == null) {
					OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);
					FileConfiguration config = null;
					File file = new File("plugins" + File.separator + "Neutron" + File.separator + "players" + File.separator + offline.getName() + ".yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					String banreason = config.getString("ban_reason");
					String bannedby = config.getString("ban_sender");
					int timesbanned = config.getInt("times_banned");
					boolean muted = config.getBoolean("muted");
					
					sender.sendMessage(ChatColor.GOLD + offline.getName() + "'s " + ChatColor.RED +"Private Ban Data");
					if (config.contains("ban_reason")) { sender.sendMessage(ChatColor.GREEN + "Ban Reason: " + ChatColor.RED + banreason); } else { sender.sendMessage(ChatColor.GOLD + "Ban Reason: " + ChatColor.RED + "Player not banned."); }
					if (config.contains("ban_sender")) { sender.sendMessage(ChatColor.GREEN + "Banned By: " + ChatColor.RED + bannedby); } else { sender.sendMessage(ChatColor.GOLD + "Banned By: " + ChatColor.RED + "Player not banned."); }
					if (config.contains("times_banned")) { sender.sendMessage(ChatColor.GREEN + "Has Been Banned: " + ChatColor.RED + timesbanned + " time(s)"); } else { sender.sendMessage(ChatColor.GREEN + "Has Been Banned: " + ChatColor.RED + timesbanned + " time(s)"); }
					if (config.contains("muted")) { sender.sendMessage(ChatColor.GREEN + "Muted: " + ChatColor.RED + config.getBoolean("muted")); } else { sender.sendMessage(ChatColor.GREEN + "Muted: " + ChatColor.RED + config.getBoolean("muted")); }
				} else {

					FileConfiguration config = null;
					File file = new File("plugins" + File.separator + "Neutron" + File.separator + "players" + File.separator + online.getName() + ".yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					
					String banreason = config.getString("ban_reason");
					String bannedby = config.getString("ban_sender");
					int timesbanned = config.getInt("times_banned");
					boolean muted = config.getBoolean("muted");

					sender.sendMessage(ChatColor.GOLD + online.getName() + "'s " + ChatColor.RED +"Private Ban Data");
					if (config.contains("ban_reason")) { sender.sendMessage(ChatColor.GREEN + "Ban Reason: " + ChatColor.RED + banreason); } else { sender.sendMessage(ChatColor.GOLD + "Ban Reason: " + ChatColor.RED + "Player not banned."); }
					if (config.contains("ban_sender")) { sender.sendMessage(ChatColor.GREEN + "Banned By: " + ChatColor.RED + bannedby); } else { sender.sendMessage(ChatColor.GOLD + "Banned By: "	+ ChatColor.RED + "Player not banned."); }
					if (config.contains("times_banned")) { sender.sendMessage(ChatColor.GREEN + "Has Been Banned: " + ChatColor.RED + timesbanned + " time(s)"); } else { sender.sendMessage(ChatColor.GREEN + "Has Been Banned: " + ChatColor.RED + timesbanned + " time(s)"); }
					if (config.contains("muted")) { sender.sendMessage(ChatColor.GREEN + "Muted: " + ChatColor.RED + config.getBoolean("muted")); } else { sender.sendMessage(ChatColor.GREEN + "Muted: " + ChatColor.RED + config.getBoolean("muted")); }

				}
			}

		}
		return false;
	}
}
