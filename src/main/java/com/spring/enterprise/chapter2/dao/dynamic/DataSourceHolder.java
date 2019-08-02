package com.spring.enterprise.chapter2.dao.dynamic;

/**
 * <P>Description: 数据源持有者 . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/9/27</P>
 * <P>UPDATE DATE: 2017/9/27</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> THREAD_DATASOURCE = new ThreadLocal<String>();

    /**
     * 获取当前数据源标识（targetDataSources中Map的key）.
     *
     * @return 当前数据源beanid
     */
    public static String getDataSource() {
        return THREAD_DATASOURCE.get();
    }

    public static void setDatasource(String datasource) {
        THREAD_DATASOURCE.set(datasource);
    }

}
