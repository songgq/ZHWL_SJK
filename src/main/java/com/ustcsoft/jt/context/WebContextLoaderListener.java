package com.ustcsoft.jt.context;

import com.ustcsoft.jt.cache.CacheManagerUtil;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * @des 继承spring监听器
 * @author mapp
 * @date 2018/3/21.
 */
public class WebContextLoaderListener extends ContextLoaderListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // 关闭 ehcache
        CacheManagerUtil.manager.clearAll();
        CacheManagerUtil.manager.shutdown();
        super.contextDestroyed(event);
    }
}
