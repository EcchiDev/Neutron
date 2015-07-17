package com.ecchidev.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.ecchidev.msgUtils.MessageUtils;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class ListenerPlayerJoin extends MessageUtils implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (!p.hasPlayedBefore()) {
			p.sendMessage(GOLD + "Welcome to our server "
					+ p.getDisplayName() + ", hopefully you enjoy your stay!");
			p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
			p.getInventory().addItem(new ItemStack(Material.STONE_SPADE));
			p.getInventory().addItem(new ItemStack(Material.STONE_AXE));
			p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			p.getInventory().addItem(new ItemStack(Material.APPLE, 32));
			p.getInventory().addItem(new ItemStack(Material.LOG, 16));
			return;
		} else {
			p.sendMessage(GOLD + "Welcome back " + p.getName()
					+ ", hopefully you enjoy your stay!");

		}

	}

	@EventHandler
	public void isOnASponge(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS && p.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.SPONGE) {
			p.setVelocity(new Vector(0, 1.5, 0));
		}
	}

}
