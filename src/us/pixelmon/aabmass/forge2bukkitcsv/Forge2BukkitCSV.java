package us.pixelmon.aabmass.forge2bukkitcsv;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import us.pixelmon.aabmass.forge2bukkitcsv.util.ItemCSVList;

/**
 * @author Aaron Abbott
 * 
 */
public final class Forge2BukkitCSV extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Beginning writing the items.csv file...");

        //first make the new plugin dir if it doesn't exist
        if (!this.getDataFolder().exists()) {
            getLogger()
                    .info("Plugin directory doesn't exist. Creating it now.");
            this.getDataFolder().mkdir();
        }

        File f1 = new File(this.getDataFolder(), "items.csv-all-chars");
        File f2 = new File(this.getDataFolder(), "items.csv-essentials");
        ItemCSVList listWithAllChars = new ItemCSVList(f1);
        ItemCSVList listWithEssentialsChars = new ItemCSVList(f2); //wont have any [^a-zA-Z0-9,] regex matches
        listWithAllChars.writeToItemsCSV(true);
        listWithEssentialsChars.writeToItemsCSV(false);
        listWithAllChars.close();
        listWithEssentialsChars.close();

        getLogger().info("Successfully wrote all current items to " + f1.getAbsolutePath() + " allowing all characters.");
        getLogger().info("Successfully wrote all current items to " + f2.getAbsolutePath() + " allowing only characters compatible with the Essentials plugin.");
    }

    @Override
    public void onDisable() {

    }
}
