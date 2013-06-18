package us.pixelmon.aabmass.forge2bukkitcsv.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemCSVList {
    private ForgeItemList list;
    private String fileHeader;
    private File fileToWriteTo;
    private FileWriter writer;

    public ItemCSVList(File fileToWriteTo) {
        this.list = new ForgeItemList();
        this.fileToWriteTo = fileToWriteTo;

        //default header
        this.fileHeader = new String(
                "## This items.csv was generated with Forge2BukkitCSV, a bukkit plugin for MCPC-Plus.\n"
                        + "## This is a bukkit style items.csv containing all minecraft blocks and items\n"
                        + "## currently loaded, including those from forge plugins!!\n"
                        + "#format: block/item name,item number,metadata");

        //always delete the old file and create a new one.
        try {
            this.fileToWriteTo.createNewFile();
            this.writer = new FileWriter(this.fileToWriteTo);
        }
        catch (IOException e) {
            //we created the file, this shouldn't happen
            e.printStackTrace();
        }
    }

    public ItemCSVList(File fileToWriteTo, String fileHeader) {
        this(fileToWriteTo);
        this.fileHeader = fileHeader;
    }

    /**
     * Essentials will crash if your items.csv contains anything with the regex
     * [^a-zA-Z0-9,] . The parameter allowAllCharacters = true will right a csv
     * allowing this regex, and false will not allow those characters and will
     * remove them.
     */
    public void writeToItemsCSV(boolean allowAllCharacters) {
        List<String> blockList = list.getBlockList();
        List<String> itemList = list.getItemList();

        //a list of strings already written
        ArrayList<String> written = new ArrayList<String>();

        try {
            //first, write a header
            writer.write(this.fileHeader + "\n");
            written.add(fileHeader);

            //now write the items/blocks
            if (allowAllCharacters) {
                for (int i = 0; i < blockList.size(); i++) {
                    if (!written.contains(blockList.get(i))) {
                        writer.write(blockList.get(i) + "," + list.getBlockForName(blockList.get(i)).field_71990_ca + ",0\n");
                        written.add(blockList.get(i));
                    }
                }

                for (int i = 0; i < itemList.size(); i++) {
                    if (!written.contains(itemList.get(i))) {
                        writer.write(itemList.get(i) + "," + list.getItemForName(itemList.get(i)).field_77779_bT + ",0\n");
                        written.add(itemList.get(i));
                    }
                }
            }

            else {
                for (int i = 0; i < blockList.size(); i++) {
                    String blockName = blockList.get(i);
                    String allowedBlockName = blockName
                            .replaceAll("[^a-zA-Z0-9,]", "");

                    if (!written.contains(allowedBlockName)) {
                        writer.write(allowedBlockName + "," + list.getBlockForName(blockList.get(i)).field_71990_ca + ",0\n");
                        written.add(allowedBlockName);
                    }
                }

                for (int i = 0; i < itemList.size(); i++) {
                    String itemName = itemList.get(i);
                    String allowedItemName = itemName
                            .replaceAll("[^a-zA-Z0-9,]", "");

                    if (!written.contains(allowedItemName)) {
                        writer.write(allowedItemName + "," + list.getItemForName(itemList.get(i)).field_77779_bT + ",0\n");
                        written.add(allowedItemName);
                    }
                }
            }
        }
        catch (IOException e) {
            //this shouldn't happen, we already threw the IOException in the constructor
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        }
        catch (IOException e) {
            //this should never happen, we only close (includes flush) once!
            e.printStackTrace();
        }
    }
}
