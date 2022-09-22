package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "bookDao")
public class BookDaoImpl implements BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        String sql = "select * from springBook";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

}
