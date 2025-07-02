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
        String colorCode = switch (type) {
            case "highlight" -> "§e§l";
            case "warn" -> "§6§l";
            case "error" -> "§c§l";
            default -> "§a§l";
        };
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
        int totalWidth = Math.max(40, nameLength + 12); // 动态计算宽度

        // 构建顶部和底部的装饰线
        String topBottomLine = "§b§l" + "=".repeat(totalWidth);

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

    private static String centerText(String text, int width) {
        int padding = (width - ChatColor.stripColor(text).length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text + " ".repeat(Math.max(0, padding));
    }
}


