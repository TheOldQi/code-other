package com.spring.enterprise.chapter2.dao.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <P>Description: 动态数据源配置 . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/9/27</P>
 * <P>UPDATE DATE: 2017/9/27</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 指定当前线程使用的数据源.
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }
}
