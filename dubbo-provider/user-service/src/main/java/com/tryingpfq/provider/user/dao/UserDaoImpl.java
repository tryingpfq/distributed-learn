package com.tryingpfq.provider.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author tryingpfq
 * @Date 2020/4/1
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate orderJdbcTemplate;

    @Override
    public void insert() {
        orderJdbcTemplate.execute("insert into user(name,psw) values(root,root)");
    }
}
