package net.larr4k.emerald.utils.configs;

import net.larr4k.emerald.Main;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Configs {
    private final Map<String, CustomConfig> sfg = new ConcurrentHashMap();
    private final Main plugin;

    public Configs(Main plugin) {
        this.plugin = plugin;
    }

    public CustomConfig get(String name) {
        if (this.sfg.get(name) == null) {
            this.add(name);
        }

        return this.sfg.get(name);
    }

    public Map<String, CustomConfig> getConfigs() {
        return this.sfg;
    }

    public void add(String name) {
        CustomConfig custom = new CustomConfig(name, this.plugin);
        this.sfg.put(name, custom);
    }

    public void save(String name) {
        if (this.sfg.get(name) == null) {
            this.add(name);
        }

        try {
            this.sfg.get(name).save();
            this.sfg.remove(name);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void saveAll() {

        for (String name : this.sfg.keySet()) {
            this.sfg.get(name).save();
        }

    }
}
