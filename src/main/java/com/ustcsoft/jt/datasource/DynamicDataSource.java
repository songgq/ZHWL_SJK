package com.ustcsoft.jt.datasource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author mapp
 * @des 动态数据源选择
 * @date 2018/4/26
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     *  切换数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("当前数据源为 ----------" + DataSourceHolder.getDateSource());
        return DataSourceHolder.getDateSource();
    }
}
