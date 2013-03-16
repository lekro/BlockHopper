package lekro.bukkitplugins.blockhopper;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockHopper extends JavaPlugin implements Listener {
	public void onEnable() {
		getLogger().info("[BlockHopper] Blocking your Hopper placement now (until Lockette/Deadbolt implements it!) -Lekro");
		getServer().getPluginManager().registerEvents(this,this);
	}
	@EventHandler
	public void hopperPlaced(BlockPlaceEvent event) {
		if (event.getBlock().getType().equals(Material.HOPPER)) {
			getLogger().info(event.getPlayer().getDisplayName() + " placed a Hopper! Blocking!");
			getServer().broadcastMessage("§a[§2BlockHopper§a]§r " + event.getPlayer().getDisplayName() + "§c tried to use a Hopper, but was stopped!");
			event.setCancelled(true);
		}
	}
}
