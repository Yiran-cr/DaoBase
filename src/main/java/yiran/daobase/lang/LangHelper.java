package yiran.daobase.lang;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class LangHelper {
    private static JavaPlugin plugin;
    private static YamlConfiguration langConfig;

    public static void init(JavaPlugin plugin) {
        LangHelper.plugin = plugin;
        reload();

        File langFolder = new File(plugin.getDataFolder(), "lang");
        if (!langFolder.exists()) {
            langFolder.mkdirs();
        }
    }

    public static void reload() {
        if (plugin == null) return;

        String langFile = plugin.getConfig().getString("language", "zh_CN") + ".yml";
        File file = new File(plugin.getDataFolder(), "lang/" + langFile);

        if (!file.exists()) {
            plugin.saveResource("lang/" + langFile, false);
        }

        langConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static String getString(String path) {
        return langConfig.getString(path, "[" + path + "]");
    }

    public static String getString(String path, Object... args) {
        String str = getString(path);
        if (args.length > 0) {
            return String.format(str, args);
        }
        return str;
    }

    public static List<String> getStringList(String path) {
        return langConfig.getStringList(path);
    }
}

