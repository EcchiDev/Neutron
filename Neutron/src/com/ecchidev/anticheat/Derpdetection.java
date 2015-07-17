package com.ecchidev.anticheat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class Derpdetection implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.getLocation().getPitch() == 180) {
			p.kickPlayer(ChatColor.RED + "Using derp/hacks is not allowed! >:c");
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + p.getDisplayName()
					+ ChatColor.RED + "Has been kicked for using hacks/derp!");
		}
	}

}
