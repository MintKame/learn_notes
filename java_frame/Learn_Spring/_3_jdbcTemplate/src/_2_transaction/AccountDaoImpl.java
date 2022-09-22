package _2_transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void incBalance(String name, int amount) {
        String sql = "update springAccount set balance = balance + ? where name = ?";
        Object[] args = {amount, name};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void decBalance(String name, int amount) {
        String sql = "update springAccount set balance = balance - ? where name = ?";
        Object[] args = {amount, name};
        jdbcTemplate.update(sql, args);
    }
}
