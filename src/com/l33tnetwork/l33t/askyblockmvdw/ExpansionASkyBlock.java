package com.l33tnetwork.l33t.askyblockmvdw;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.wasteofplastic.askyblock.ASkyBlockAPI;
 
import org.bukkit.plugin.java.JavaPlugin;

import be.maximvdw.featherboard.api.PlaceholderAPI;
import be.maximvdw.featherboard.api.PlaceholderAPI.PlaceholderRequestEvent;
import be.maximvdw.featherboard.api.PlaceholderAPI.PlaceholderRequestEventHandler;

public class ExpansionASkyBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        PlaceholderAPI.registerOfflinePlaceholder("asb_island_level", true, 
        	new PlaceholderRequestEventHandler() {
                    @Override
                    public String onPlaceholderRequest(PlaceholderRequestEvent e) {
                        String playerName = e.getOfflinePlayer().getName();
                    	Location islandLoc = Bukkit.getPlayer(playerName).getLocation();
                    	int islandLevel;

                    	try {
                        	islandLevel = ASkyBlockAPI.getInstance().getIslandLevel(ASkyBlockAPI.getInstance().getIslandAt(islandLoc).getOwner());
                    	}
                    	catch (Exception e1) {
                    		islandLevel = 0;
                    	}
                    	
                    	if (islandLevel == 0) {
                    		return "-";
                    	}
                    	else {
                    		return String.valueOf(islandLevel);
                    	}
                    }
        });

    }
}