package yiran.daobase;

import org.bukkit.plugin.java.JavaPlugin;
import yiran.daobase.output.MessageUtils;

public final class DaoBase extends JavaPlugin {

    @Override
    public void onEnable() {
        // 初始化工具类
        MessageUtils.init(this, "§a§l[刀牌框架] "); // 自定义前缀

        // 获取插件信息
        String pluginName = getDescription().getName();
        String author = String.join(", ", getDescription().getAuthors());
        String version = getDescription().getVersion();

        // 生成并打印面板
        String[] banner = MessageUtils.getBanner(pluginName, author, version);
        for (String line : banner) {
            getLogger().info(line);
        }
    }

    @Override
    public void onDisable() {
    }
}
