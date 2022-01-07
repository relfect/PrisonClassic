package net.larr4k.emerald.listeners;

import lombok.NonNull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public void onPlace(@NonNull BlockPlaceEvent e) {
        e.setCancelled(true);
    }


}
