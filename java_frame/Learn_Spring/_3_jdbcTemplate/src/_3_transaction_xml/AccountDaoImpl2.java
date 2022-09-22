package _3_transaction_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl2 implements AccountDao2 {
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
