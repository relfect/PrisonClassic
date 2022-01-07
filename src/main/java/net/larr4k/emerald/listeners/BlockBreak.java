package net.larr4k.emerald.listeners;

import lombok.Getter;
import net.larr4k.emerald.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class BlockBreak implements Listener {

    @Getter
    static Main plugin;

    @EventHandler
    public void onJoin(BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        Collection<ItemStack> drops = e.getBlock().getDrops();
        if (!e.isCancelled()) {
            drops.forEach((item) -> {
                if (p.getGameMode() == GameMode.SURVIVAL) {
                    if (p.getInventory().firstEmpty() >= 0) {
                    } else {
                        e.getBlock().setType(Material.AIR);
                        e.getBlock().getDrops().clear();
                        p.getInventory().addItem(item);

                    }
                } else {
                    p.sendTitle("§cУ вас полный инвентарь!", "§fПродайте все добытые блоки", 8, 10, 20);
                    e.setCancelled(true);
                }

            });
        }
    }

}
