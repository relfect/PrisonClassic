package net.larr4k.emerald.listeners;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.larr4k.emerald.Main;
import net.larr4k.emerald.prison.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.abstractcoder.benioapi.board.sidebar.SidebarTemplate;
import ru.abstractcoder.benioapi.board.text.SimpleText;
import ru.abstractcoder.benioapi.board.text.UpdatableText;
import ru.abstractcoder.benioapi.board.text.updater.PlaceholderTextUpdater;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class GlobalListeners {

    @Getter
    static Main plugin;
    @Getter
    static SidebarTemplate sidebarTemplate;
    @Getter
    static PlayerData playerData;

    @EventHandler
    public void onJoin(@NonNull PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        loadBoard(player);
        e.setJoinMessage(null);

    }

    @ToString.Include
    public void loadBoard(@NonNull Player player) {
        plugin.getBenioApiInstance().getBoardApi()
                .getSidebarService()
                .createBukkitSidebar(player, sidebarTemplate)
                .setTitle(new SimpleText("§ePRISON"))
                .addEmptyLine()
                .addLine(new SimpleText("§eСтатистика"))
                .addLine(new UpdatableText("§fУровень: {level}", 30)
                        .applyUpdater(new PlaceholderTextUpdater()
                                .add("{level}", playerData::getLevel)))
                .addLine(new UpdatableText("§fБлоков: {blocks}", 30)
                        .applyUpdater(new PlaceholderTextUpdater()
                                .add("{blocks}", playerData::getBlocks)))
                .addEmptyLine()
                .addLine(new SimpleText("§eСервер"))
                .addLine(new UpdatableText("§fОнлайн: {online}", 30)
                        .applyUpdater(new PlaceholderTextUpdater()
                                .add("{online}", Bukkit.getOnlinePlayers())))
                .addEmptyLine()
                .addLine(new SimpleText("     §eEmeraldMe.Ru"))
                .update();

    }

    @EventHandler
    public void onQuit(@NonNull PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
