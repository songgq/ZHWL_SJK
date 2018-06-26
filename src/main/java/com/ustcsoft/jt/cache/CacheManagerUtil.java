package com.ustcsoft.jt.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @des 缓存工具类
 * @author mapp
 * @date 2018/3/21.
 */
public class CacheManagerUtil {

    public static final CacheManager manager = new CacheManager(CacheManagerUtil.class.getClassLoader().getResourceAsStream("ehcache.xml"));

    /**
     * 取
     * @return
     */
    public static Object get(String cacheName, Object key) {
        Cache cache = manager.getCache(cacheName);
        if (cache != null) {
            Element element = cache.get(key);
            if (element != null) {
                return element.getObjectValue();
            }
        }
        return null;
    }

    /**
     * 放
     */
    public static void add(String cacheName, Object key, Object value) {
        Cache cache = manager.getCache(cacheName);
        if (cache != null) {
            cache.put(new Element(key, value));
        }
    }

    /**
     * 删
     */
    public static void remove(String cacheName, Object key) {
        Cache cache = manager.getCache(cacheName);
        if (cache != null) {
            cache.remove(key);
        }
    }

    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerUtil.manager;
//        manager.
        System.out.println(cacheManager);
    }

}
