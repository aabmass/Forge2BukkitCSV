package us.pixelmon.aabmass.forge2bukkitcsv.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * A big thanks to ForgeEssentials for this code! It comes from their
 * FriendlyItemsList.java, but I added some mcpc+-api-srgnames
 * obfuscations. These should last and not cause ClassNotFoundException's
 * when minecraft is upgraded!
 **/
public class ForgeItemList {
    private HashMap<String, Item> itemMap = new HashMap<String, Item>();
    private HashMap<String, Block> blockMap = new HashMap<String, Block>();

    private static ForgeItemList instance;

    public ForgeItemList() {
        instance = this;
        makeList();
    }

    public static ForgeItemList instance() {
        return instance;
    }

    public void makeList() {
        for (Item item : Item.field_77698_e) {
            if (item != null) {
                try {
                    itemMap.put(item.func_77658_a().toLowerCase().replaceAll("tile.", "").replaceAll("item.", ""), item);
                }
                catch (Exception e) {

                }
            }
        }

        for (Block block : Block.field_71973_m) {
            if (block != null && block.field_71990_ca != 0) {
                try {

                    blockMap.put(block.func_71917_a().toLowerCase().replaceAll("item.", "").replaceAll("tile.", ""), block);
                }
                catch (Exception e) {

                }
            }
        }
    }

    public Item getItemForName(String name) {
        return itemMap.get(name.toLowerCase());
    }

    public Block getBlockForName(String name) {
        return blockMap.get(name.toLowerCase());
    }

    public List<String> getItemList() {
        return Arrays.asList(itemMap.keySet().toArray(new String[0]));
    }

    public List<String> getBlockList() {
        return Arrays.asList(blockMap.keySet().toArray(new String[0]));
    }

    public List<String> getAllList() {
        String[] array1 = blockMap.keySet().toArray(new String[0]);
        String[] array2 = itemMap.keySet().toArray(new String[0]);

        String[] array1and2 = new String[array1.length + array2.length];

        System.arraycopy(array1, 0, array1and2, 0, array1.length);
        System.arraycopy(array2, 0, array1and2, array1.length, array2.length);

        return Arrays.asList(array1and2);
    }
}
