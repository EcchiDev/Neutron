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

import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class CommandUnban implements CommandExecutor {

	public Neutron plugin;

	public CommandUnban(Neutron plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "/unban <username>");
				return true;
			}
			if (args.length == 1) {

				FileConfiguration config = null;
				File file = new File("plugins" + File.separator + "Neutron"
						+ File.separator + "players" + File.separator
						+ args[0].toLowerCase() + ".yml");
				config = YamlConfiguration.loadConfiguration(file);
				

				if (!config.contains("ban_reason")) {
					sender.sendMessage(ChatColor.RED
							+ "That player is not banned");
				}else {

				OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);

				StringBuilder x = new StringBuilder();

					for (int i = 1; i < args.length; i++) {
						x.append(args[i] + " ");
					}
					config.set("ban_reason", null);
					config.set("ban_sender", null);
					try {
						config.save(file);
					} catch (Exception e) {
						e.printStackTrace();
						sender.sendMessage(ChatColor.RED
								+ "Player data could not be saved");
					}
					offline.setBanned(false);
					sender.sendMessage(ChatColor.RED
							+ "Player has been unbanned.");
				}
			}
		}

		return false;
	}

}
