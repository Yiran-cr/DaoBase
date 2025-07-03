package yiran.daobase.output;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageUtils {
    private static JavaPlugin plugin;
    public static String PREFIX = "§a§l[刀牌插件] ";

    public static void init(JavaPlugin pluginInstance, String customPrefix) {
        plugin = pluginInstance;
        PREFIX = customPrefix;
    }

    public static String playerMsg(String type, String message) {
        String colorCode;
        switch (type) {
            case "highlight":
                colorCode = "§e§l";
                break;
            case "warn":
                colorCode = "§6§l";
                break;
            case "error":
                colorCode = "§c§l";
                break;
            default:
                colorCode = "§a§l";
                break;
        }
        return ChatColor.translateAlternateColorCodes('§', PREFIX + colorCode + message);
    }

    public static void log(String type, String message) {
        String formatted = playerMsg(type, message);
        switch (type) {
            case "error":
                plugin.getLogger().severe(formatted);
                break;
            case "warn":
                plugin.getLogger().warning(formatted);
                break;
            default:
                plugin.getLogger().info(formatted);
                break;
        }
    }

    public static String[] getBanner(String pluginName, String author, String version) {
        int nameLength = pluginName.length();
        int totalWidth = Math.max(40, nameLength + 12);

        // 构建顶部和底部的装饰线
        String topBottomLine = "§b§l" + repeatChar('=', totalWidth);

        // 构建中间内容
        String nameLine = "§b§l" + centerText("§e§l" + pluginName, totalWidth);
        String authorLine = "§b§l作者: §e" + author;
        String versionLine = "§b§l版本: §e" + version;

        return new String[] {
                topBottomLine,
                nameLine,
                authorLine,
                versionLine,
                topBottomLine
        };
    }

    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String centerText(String text, int width) {
        String stripped = ChatColor.stripColor(text);
        int padding = (width - stripped.length()) / 2;
        return repeatChar(' ', padding) + text + repeatChar(' ', padding);
    }
}


