package net.larr4k.emerald.listeners;

import lombok.Getter;
import lombok.NonNull;
import net.larr4k.emerald.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @Getter
    static Main plugin;

    @EventHandler
    public void onPlace(@NonNull BlockPlaceEvent e) {
        e.setCancelled(true);
    }


}
