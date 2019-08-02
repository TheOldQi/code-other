package com.spring.enterprise.chapter2.dao;

import com.spring.enterprise.chapter2.domain.LoginLogPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * <P>Description: springjdbc实现数据访问层 . </P>
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
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_LOG_SQL = "INSERT INTO t_login_log (user_id,ip,login_datetime) VALUES (?,?,?)";

    public void insert(LoginLogPo loginLogPo) {
        jdbcTemplate.update(INSERT_LOG_SQL, loginLogPo.getUserId(), loginLogPo.getIp(), loginLogPo.getLoginDate());
    }

    public List<LoginLogPo> list() {
        return jdbcTemplate.query("select * from t_login_log", new RowMapper<LoginLogPo>() {
            @Override
            public LoginLogPo mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                LoginLogPo loginLogPo = new LoginLogPo();
                loginLogPo.setUserId(rs.getInt(1));
                loginLogPo.setUserId(rs.getInt(2));
                loginLogPo.setIp(rs.getString(3));
                loginLogPo.setLoginDate(rs.getDate(4));
                return loginLogPo;
            }
        });
    }
}
