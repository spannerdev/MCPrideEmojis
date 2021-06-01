package com.spanner.mcprideemojis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftPrideEmojis extends JavaPlugin {

	public ArrayList<Pride> prides = new ArrayList<Pride>();
	public FileConfiguration config;
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		this.config = getConfig();
		
		for (String pride : config.getConfigurationSection("prides").getKeys(false)) {
			Pride p = new Pride();
			@SuppressWarnings("unchecked")
			List<String> als = (List<String>) config.getList("prides."+pride+".aliases");
			String[] as = new String[als.size()];
			p.aliases = als.toArray(as);
			p.unicode = config.getString("prides."+pride+".unicode");
			prides.add(p);
			System.out.println("aa");
		}
		
		Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
	}
	
}
