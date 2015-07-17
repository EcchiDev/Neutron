package com.ecchidev.commands.banning;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import com.ecchidev.main.Neutron;

//Jonne Saloranta - www.youtube.com/MasterSteve26

@SuppressWarnings("deprecation")
public class MutedPlayerChat implements Listener{

	public Neutron plugin;

	public MutedPlayerChat(Neutron plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void mutedPlayerChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		
		FileConfiguration config = null;
		File file = new File("plugins" + File.separator + "Neutron"
				+ File.separator + "players" + File.separator
				+ p.getName().toLowerCase() + ".yml");
		config = YamlConfiguration.loadConfiguration(file);
		
		if(config.getBoolean("muted")==true) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "You are muted!");
			return;
		}
	}

}
