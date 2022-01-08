package net.larr4k.emerald.prison;

import lombok.Getter;
import lombok.NonNull;
import net.larr4k.emerald.Main;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PrisonManager {

    @Getter
    Main plugin;
    @Getter
    Map<String, @NonNull PlayerData> data;

    public PrisonManager(@NonNull Main plugin) {
        this.plugin = plugin;
        this.data = new HashMap<>();
    }

    public void loadStats(@NonNull Player player) {
        this.data.put(player.getName(), Main.getMysql().getPlayerData(player.getName(), player));
    }

    public void save(@NonNull Player player) {
        PlayerData farmer = (PlayerData) this.getData();
        Main.getMysql().setPrisonStats(farmer);
    }

    public void unLoadStats(Player player) {
        PlayerData farmer = (PlayerData) this.getData();
        Main.getMysql().setPrisonStats(farmer);
        this.data.remove(player.getName());
    }

}
