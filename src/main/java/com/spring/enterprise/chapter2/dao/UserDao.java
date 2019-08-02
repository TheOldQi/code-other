package com.spring.enterprise.chapter2.dao;

import com.spring.enterprise.chapter2.domain.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <P>Description: 使用SpringJdbc实现的数据访问层 . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/9/27</P>
 * <P>UPDATE DATE: 2017/9/27</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
@Repository
public class UserDao {

    private static final String COUNT_MATCH_SQL = "select count(*) from t_user where user_name=? and password=?";
    private static final String UPDATE_LOGIN_INFO_SQL = "update t_user set last_visit=? ,last_ip=?,credits=? where user_id=?";
    private static final String QUERY_BY_USERNAME_SQL = "select * from t_user from t_user where user_name=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询符合用户名和密码的数据是否存在.
     *
     * @param userName
     * @param password
     * @return
     */
    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(COUNT_MATCH_SQL, new Object[]{userName, password}, Integer.class);
    }

    /**
     * 更新用户登录信息.
     *
     * @param userPo 用户表持久化对象
     */
    public void updateLoginInfo(UserPo userPo) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, userPo.getLastVisit(), userPo.getLastIp(), userPo.getCredits(), userPo.getUserId());
    }

    /**
     * 根据用户名查询
     *
     * @param userName
     * @return
     */
    public List<UserPo> listByUserName(String userName) {
        return jdbcTemplate.queryForList(QUERY_BY_USERNAME_SQL, new Object[]{userName}, UserPo.class);
    }
}
