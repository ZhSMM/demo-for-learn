package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/13
 * @description details
 **/
@Repository // dao层
public class UserDaoImpl implements UserDao {
    @Autowired
   private JdbcTemplate jdbcTemplate;

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        String sql="insert into user (username,usersex) values (?,?)";
        this.jdbcTemplate.update(sql,user.getUserName(),user.getUserSex());
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        // RowMapper：提供结果集的映射
        return this.jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setUserId(resultSet.getInt("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setUserSex(resultSet.getString("usersex"));
                return user;
            }
        });
    }

    @Override
    public User selectById(Integer id) {
        User user =new User();
        String sql = "select * from user where userid = ?";
        Object[] arr = new Object[]{id};
        this.jdbcTemplate.query(sql,arr,new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setUserSex(resultSet.getString("usersex"));
            }
        });
        return user;
    }

    // 更新用户
    @Override
    public void updateById(User user) {
        String sql = "update user set username = ?,usersex=? where userid=?";
        this.jdbcTemplate.update(sql,user.getUserName(),user.getUserSex(),user.getUserId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from user where userid = ?";
        this.jdbcTemplate.update(sql,id);
    }
}
