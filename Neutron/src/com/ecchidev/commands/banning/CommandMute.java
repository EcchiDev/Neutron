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

public class CommandMute implements CommandExecutor {
	public Neutron plugin;

	public CommandMute(Neutron plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("mute")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "/mute <username> ");
				return true;
			}
			if (args.length >= 1) {
				Player online = Bukkit.getPlayer(args[0]);
				if (online == null) {
					OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);
					FileConfiguration config = null;
					File file = new File("plugins" + File.separator + "Neutron"
							+ File.separator + "players" + File.separator
							+ args[0].toLowerCase() + ".yml");
					config = YamlConfiguration.loadConfiguration(file);
					sender.sendMessage(ChatColor.RED + offline.getName() + " Has been muted!");
					config.set("muted", true);
					try {
						config.save(file);
					} catch (Exception e) {
						e.printStackTrace();
						sender.sendMessage(ChatColor.RED
								+ "Player data could not be saved");
					}

				} else {
					FileConfiguration config = null;
					File file = new File("plugins" + File.separator + "Neutron"
							+ File.separator + "players" + File.separator
							+ args[0].toLowerCase() + ".yml");
					config = YamlConfiguration.loadConfiguration(file);
					sender.sendMessage(ChatColor.RED + online.getName() + " Has been muted!");
					online.sendMessage(ChatColor.RED + "You are now muted!");
					config.set("muted", true);
					try {
						config.save(file);
					} catch (Exception e) {
						e.printStackTrace();
						sender.sendMessage(ChatColor.RED
								+ "Player data could not be saved");
					}
				}
			}
		}
		return false;
	}
}
