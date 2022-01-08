package net.larr4k.emerald.prison;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.larr4k.emerald.Main;
import net.larr4k.emerald.commands.MenuCommand;
import net.larr4k.emerald.database.MySQL;
import net.larr4k.emerald.listeners.BlockBreak;
import net.larr4k.emerald.listeners.BlockPlace;
import net.larr4k.emerald.listeners.GlobalListeners;
import net.larr4k.emerald.utils.configs.Configs;
import net.larr4k.emerald.utils.configs.CustomConfig;
import ru.abstractcoder.benioapi.util.listener.QuickListener;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PrisonLoader {

    @Getter
    static Main plugin;
    @Getter
    String label;
    @Getter
    static Configs configs;
    @Getter
    static MySQL mySQL;

    public void init() {
        configs = getConfigs();
        registerListeners();
        registerCommands();
        registerConfigs();
    }

    protected void registerConfigs() {
        CustomConfig cfgMSQL = getConfigs().get("MySQL");
        cfgMSQL.setDefault("host", "localhost");
        cfgMSQL.setDefault("user", "root");
        cfgMSQL.setDefault("password", "123456789");
        cfgMSQL.save();
        mySQL = new MySQL(Main.getInstance(), "localhost", "prison", "root", "prisonnormaltest");
        mySQL.createDatabase();
    }

    protected void registerListeners() {
        QuickListener.create().register(GlobalListeners.getPlugin()).enableAll();
        QuickListener.create().register(BlockBreak.getPlugin()).enableAll();
        QuickListener.create().register(BlockPlace.getPlugin()).enableAll();
    }

    public void registerCommands() {
        (new MenuCommand(label)).register(plugin);
    }

}
