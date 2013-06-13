package us.pixelmon.aabmass.forge2bukkitcsv;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import us.pixelmon.aabmass.forge2bukkitcsv.util.ItemCSVList;

/**
 * @author Aaron Abbott
 * TODO: Implement metadata loading, from {Block/Item}.{blockList/itemList}
 * and use those values for metadata. I don't have time right now to look up
 * the obfuscated mappings for the variables, but will do later!
 *
 */
public final class Forge2BukkitCSV extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Beginning writing the items.csv file...");
		
		//first make the new plugin dir if it doesn't exist
		if (!this.getDataFolder().exists()) {
			getLogger().info("Plugin directory doesn't exist. Creating it now.");
			this.getDataFolder().mkdir();
		}
		
		File fileToWrite = new File(this.getDataFolder(), "items.csv");
		ItemCSVList list = new ItemCSVList(fileToWrite);
		list.writeToItemsCSV();
		list.close();
		getLogger().info("Successfully wrote all current items to " + fileToWrite.getAbsolutePath() + ".");
	}
	
	@Override
	public void onDisable() {
		
	}
}
