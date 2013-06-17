Forge2BukkitCSV
===============
####A bukkit plugin for MCPC-Plus servers that populates all of the items/blocks into a Essentials-style items.csv
---------------------------

This plugin will only work on MCPC-Plus servers. It doesn't use too much from bukkit either, so it should work with most versions. Just make sure that the obfuscated mappings haven't changed when using this plugin for any bukkit version beside **1.5.2**.

###Download Link: **[Forge2BukkitCSV-0.0.2.jar](http://pixelmon.us/mod-dl/Forge2BukkitCSV-0.0.2.jar)**

##Good Uses
I developed this plugin so that bukkit commands and plugins, namely Essentials signs and /give, will work with items/blocks provided by Minecraft Forge mods!

##Installation
Just download the [jar](http://pixelmon.us/mod-dl/Forge2BukkitCSV-0.0.2jar) and put it in your MCPC-Plus server's plugins folder and restart the server.
##Usage
This plugin currently doesn't use any commands. Some may be expected in the future for pluging the generated items.csv into bukkit through Essentials or a sign shop plugin, etc.

To generate the items.csv files, just restart the server after you install the mod. It will now be at *plugins/Forge2BukkitCSV/items.csv-all-chars* and *plugins/Forge2BukkitCSV/items.csv-essentials*. The *items.csv-all-chars* has all characters, which is supported by some plugins (my fork of SimpleEcoSigns). *items.csv-essentials* only has characters allowed by the Essentials plugin's *items.csv*. Characters not allowed match the regex `[^a-zA-Z0-9,]`

**If you do not use this file with Essentials, all of Essentials commands will not work and your console will be spammed.**