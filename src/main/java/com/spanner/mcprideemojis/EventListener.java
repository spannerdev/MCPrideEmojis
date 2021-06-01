package com.spanner.mcprideemojis;

import java.util.regex.Pattern;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventListener implements Listener {

	MinecraftPrideEmojis plugin;
	public EventListener(MinecraftPrideEmojis plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		String message = e.getMessage();
		for (Pride pride : plugin.prides) {
			for (String alias : pride.aliases) {
				String a = alias.toLowerCase();
				if (Pattern.compile("(?i)"+a).matcher(message).find()) {
					message = message.replaceAll("(?i)"+a, pride.unicode);
				}
			}
		}
		e.setMessage(message);
	}
	
}
