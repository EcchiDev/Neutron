package com.ecchidev.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class ListenerPlayerJoin implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPlayedBefore()) {
			p.sendMessage(ChatColor.GOLD + "Welcome to our server " + p.getDisplayName() + ", hopefully you enjoy your stay!");
			p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
			p.getInventory().addItem(new ItemStack(Material.STONE_SPADE));
			p.getInventory().addItem(new ItemStack(Material.STONE_AXE));			
			p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			p.getInventory().addItem(new ItemStack(Material.APPLE, 32));
			p.getInventory().addItem(new ItemStack(Material.LOG, 16));
			return;
		}else {
			p.sendMessage(ChatColor.GOLD + "Welcome back " + p.getName() + ", hopefully you enjoy your stay!");
			
		}
		
	}
	
}
