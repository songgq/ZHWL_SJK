package com.ustcsoft.jt.datasource;

/**
 * @author mapp
 * @des 存储当前线程中使用的数据源标识
 * @date 2018/4/26
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> dateSource = new ThreadLocal<String>();

    public static String getDateSource() {
        return dateSource.get();
    }

    public static void setDataSource(String key) {
        dateSource.set(key);
    }

    public static void clearDateSource() {
        dateSource.remove();
    }
}
