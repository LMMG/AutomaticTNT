package me.lmmg.automatictnt.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.lmmg.automatictnt.AutomaticTNT;

public class BlockListener implements Listener {

	public AutomaticTNT plugin;

	public BlockListener(AutomaticTNT pl) {

		plugin = pl;

		plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {

		Block block = event.getBlock();
		Location location = block.getLocation();

		if (block.getType() == Material.TNT) {

			Entity primed = block.getWorld().spawn(location, TNTPrimed.class);

			((TNTPrimed) primed).setFuseTicks(plugin.settings.getConfiguration().getInt("Fuse.Ticks"));

			location.getBlock().setType(Material.AIR);

		}

	}

}
