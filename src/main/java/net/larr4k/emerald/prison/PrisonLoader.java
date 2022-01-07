package net.larr4k.emerald.prison;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.larr4k.emerald.Main;
import net.larr4k.emerald.commands.MenuCommand;
import net.larr4k.emerald.listeners.BlockBreak;
import net.larr4k.emerald.listeners.GlobalListeners;
import ru.abstractcoder.benioapi.util.listener.QuickListener;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PrisonLoader {

    @Getter
    static Main plugin;
    @Getter
    String label;

    public void init() {
        registerListeners();
        registerCommands();
    }

    protected void registerListeners() {
        QuickListener.create().register(GlobalListeners.getPlugin());
        QuickListener.create().register(BlockBreak.getPlugin());
    }

    public void registerCommands() {
        (new MenuCommand(label)).register(plugin);
    }

}
