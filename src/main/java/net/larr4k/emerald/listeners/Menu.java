package net.larr4k.emerald.listeners;

import dagger.Reusable;
import lombok.Getter;
import net.larr4k.emerald.Main;
import net.larr4k.emerald.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

@Reusable
public class Menu implements Listener {

    @Getter
    static Main plugin;


    public void createMainMenu(Player player) {
        Inventory i = Bukkit.createInventory(player, 54);

        i.setItem(0, (new ItemBuilder(Material.LEGACY_SKULL)).setName("§eШахты").setLore("", "").toItemStack());
    }

}
