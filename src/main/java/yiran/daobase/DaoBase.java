package yiran.daobase;

import org.bukkit.plugin.java.JavaPlugin;
import yiran.daobase.output.MessageUtils;

/**
 * DaoBase - 1.7.10 Bukkit 开发框架
 * 提供基础工具类供其他插件使用
 */
public final class DaoBase extends JavaPlugin {

    private static DaoBase instance;

    @Override
    public void onEnable() {
        instance = this;
        // 初始化消息工具
        MessageUtils.init(this, "§a§l[DaoBase] ");
        MessageUtils.info("§bDaoBase 框架已启用");
    }

    @Override
    public void onDisable() {
        MessageUtils.info("§bDaoBase 框架已卸载");
        instance = null;
    }

    /**
     * 获取插件实例
     */
    public static DaoBase getInstance() {
        return instance;
    }
}
