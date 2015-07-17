package com.ecchidev.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.ecchidev.antigrief.*;
import com.ecchidev.commands.*;
import com.ecchidev.listeners.*;
import com.ecchidev.commands.banning.*;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class Neutron extends JavaPlugin{
	
	Logger logger = Logger.getLogger("Minecraft");
	
	public void logMsg(String msg) {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " V" + pdfFile.getVersion() + " " + msg);
	}

	public void regEvents(Listener listener, Plugin main) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, main);
	}

	@Override
	public void onEnable() {
		logMsg("Plugin has been enabled");
		super.onEnable();
		
		regEvents(new ListenerPlayerJoin(), this);
		regEvents(new CommandRegion(this), this);
		regEvents(new BannedPlayerJoin(this), this);
		regEvents(new MutedPlayerChat(this), this);
		
		getCommand("region").setExecutor(new CommandRegion(this));
		getCommand("fly").setExecutor(new CommandFly(this));
		getCommand("heal").setExecutor(new CommandHeal(this));
		getCommand("starve").setExecutor(new CommandHeal(this));
		getCommand("ban").setExecutor(new CommandBan(this));
		getCommand("unban").setExecutor(new CommandUnban(this));
		getCommand("check").setExecutor(new CommandCheck(this));
		getCommand("mute").setExecutor(new CommandMute(this));
		getCommand("unmute").setExecutor(new CommandUnmute(this));

		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@Override
	public void onDisable() {
		logMsg("Plugin has been disabled");
		super.onDisable();
	}

}
