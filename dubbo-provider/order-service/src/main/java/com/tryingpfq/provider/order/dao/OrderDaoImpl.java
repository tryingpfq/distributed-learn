package com.tryingpfq.provider.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author tryingpfq
 * @Date 2020/4/1
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    JdbcTemplate orderJdbcTemplate;

    @Override
    public void insert() {
        orderJdbcTemplate.execute("insert into order(id,price) values(1,10)");
    }
}
