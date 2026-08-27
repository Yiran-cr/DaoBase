package yiran.daobase.output;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageUtils {
    private static JavaPlugin plugin;
    public static String PREFIX = "§a§l[DaoBase] ";

    /**
     * 初始化工具类
     */
    public static void init(JavaPlugin pluginInstance, String prefix) {
        plugin = pluginInstance;
        PREFIX = prefix;
    }

    /**
     * 带颜色格式化消息
     */
    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', PREFIX + message);
    }

    /**
     * 发送消息给发送者
     */
    public static void send(CommandSender sender, String message) {
        sender.sendMessage(color(message));
    }

    /**
     * 日志 - 信息级别
     */
    public static void info(String message) {
        plugin.getLogger().info(color(message));
    }

    /**
     * 日志 - 警告级别
     */
    public static void warn(String message) {
        plugin.getLogger().warning(color(message));
    }

    /**
     * 日志 - 错误级别
     */
    public static void error(String message) {
        plugin.getLogger().severe(color(message));
    }
}


