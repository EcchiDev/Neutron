package com.ecchidev.commands.banning;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class BannedPlayerJoin implements Listener {

	public Neutron plugin;

	public BannedPlayerJoin(Neutron plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (p.isBanned()) {

			FileConfiguration config = null;
			File file = new File("plugins" + File.separator + "Neutron"
					+ File.separator + "players" + File.separator + p.getName()
					+ ".yml");
			config = YamlConfiguration.loadConfiguration(file);
			String banreason = config.getString("ban_reason");
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.RED
					+ "You are banned for " + banreason);
		}
	}
}
