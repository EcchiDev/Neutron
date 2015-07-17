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

public class CommandBan implements CommandExecutor {

	public Neutron plugin;

	public CommandBan(Neutron plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (args.length < 2) {
				sender.sendMessage(ChatColor.RED
						+ "/ban <username> <banreason>");
				return true;
			}
			if (args.length > 1) {
				Player online = Bukkit.getPlayer(args[0]);
				if (online == null) {
					OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);
					FileConfiguration config = null;
					File file = new File("plugins" + File.separator + "Neutron"
							+ File.separator + "players" + File.separator
							+ args[0].toLowerCase() + ".yml");
					config = YamlConfiguration.loadConfiguration(file);
					StringBuilder x = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						x.append(args[i] + " ");
					}
					config.set("ban_reason", x.toString().trim());
					config.set("ban_sender", sender.getName());
					int times = config.getInt("times_banned");
					config.set("times_banned", times + 1);
					try {
						config.save(file);
					} catch (Exception e) {
						e.printStackTrace();
						sender.sendMessage(ChatColor.RED
								+ "Player data could not be saved");
					}
					offline.setBanned(true);
					Bukkit.broadcastMessage(ChatColor.RED + offline.getName()
							+ " has been banned by " + sender.getName() + " for " + x.toString().trim());
				} else {
					FileConfiguration config = null;
					File file = new File("plugins" + File.separator + "Neutron"
							+ File.separator + "players" + File.separator
							+ args[0].toLowerCase() + ".yml");
					config = YamlConfiguration.loadConfiguration(file);
					StringBuilder x = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						x.append(args[i] + " ");
					}
					config.set("ban_reason", x.toString().trim());
					config.set("ban_sender", sender.getName());
					int times = config.getInt("times_banned");
					config.set("times_banned", times + 1);
					try {
						config.save(file);
					} catch (Exception e) {
						e.printStackTrace();
						sender.sendMessage(ChatColor.RED
								+ "Player data could not be saved");
					}
					online.setBanned(true);
					Bukkit.broadcastMessage(ChatColor.RED + online.getName()
							+ " has been banned by " + sender.getName()
							+ " for " + x.toString().trim());
					online.kickPlayer(ChatColor.RED
							+ "you have been kicked from the server since you got banned!");
				}
			}
		}

		return false;
	}
}
