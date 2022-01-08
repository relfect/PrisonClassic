package net.larr4k.emerald;

import lombok.Getter;
import net.larr4k.emerald.database.MySQL;
import net.larr4k.emerald.prison.PrisonLoader;
import ru.abstractcoder.benioapi.BenioApiInstance;
import ru.abstractcoder.benioapi.BenioPlugin;

public final class Main extends BenioPlugin {

    @Getter
    static Main instance;
    @Getter
    static PrisonLoader loader;
    @Getter
    static MySQL mysql;

    @Override
    protected void onPluginEnable() throws Throwable {
        instance = this;
        loader.init();


    }

    @Override
    public BenioApiInstance getBenioApiInstance() {
        return super.getBenioApiInstance();
    }


    @Override
    protected void onPluginDisable() throws Throwable {
        mysql.getHikariDataSource().close();
    }
}
