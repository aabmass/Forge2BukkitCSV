package us.pixelmon.aabmass.forge2bukkitcsv.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		this.fileHeader = new String("## This items.csv was generated with Forge2BukkitCSV, a bukkit plugin for MCPC-Plus.\n" +
									 "## This is a bukkit style items.csv containing all minecraft blocks and items\n" +
									 "## currently loaded, including those from forge plugins!!\n\n" +
									 "#format: block/item name,item number,metadata");
		
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
	
	public void writeToItemsCSV() {
		List<String> blockList = list.getBlockList();
		List<String> itemList = list.getItemList();
		
		try {
			//first, write a header
			writer.write(this.fileHeader + "\n");
			for (int i = 0; i < blockList.size(); i++) {
				writer.write(blockList.get(i) + "," + list.getBlockForName(blockList.get(i)).field_71990_ca + ",0\n");
			}
			
			for (int i = 0; i < itemList.size(); i++) {
				writer.write(itemList.get(i) + "," + list.getItemForName(itemList.get(i)).field_77779_bT + ",0\n");
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
