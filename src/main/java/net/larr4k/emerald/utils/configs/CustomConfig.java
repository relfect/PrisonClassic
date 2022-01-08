package net.larr4k.emerald.utils.configs;

import net.larr4k.emerald.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;


public class CustomConfig {
    private final YamlConfiguration yml;
    private final File file;

    CustomConfig(String name, Main plugin) {
        this.file = new File(plugin.getDataFolder(), name + ".yml");
        this.yml = YamlConfiguration.loadConfiguration(this.file);
        this.file.getParentFile().mkdirs();
    }

    public FileConfiguration get() {
        return this.yml;
    }

    public void save() {
        try {
            this.yml.save(this.file);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public void setDefault(String path, Object value) {
        if (!this.yml.isSet(path)) {
            this.yml.set(path, value);
        }

    }

    public void reload() {
        try {
            this.yml.load(this.file);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static boolean exist(String name, Main plugin) {
        File file = new File(plugin.getDataFolder(), name + ".yml");
        return file.exists();
    }
}
