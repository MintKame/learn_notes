package _1_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository(value = "bookDao")
public class BookDaoImpl implements BookDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into springBook values(?,?)";
        Object[] args = {book.getName(), book.getPrice()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Book book) {
        String sql = "update springBook set price = ? where name = ?";
        Object[] args = {book.getPrice(), book.getName()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void delete(String name) {
        String sql = "delete from springBook where name = ?";
        jdbcTemplate.update(sql, name);
    }

    // 每条sql 对应 1个参数数组
    // 所有sql的数组，存于一个list中
    @Override
    public void batchAdd(List<Book> books) {
        String sql = "insert into springBook values(?,?)";

        List<Object[]> argsList = new ArrayList<>();
        for (Book book : books) {
            Object[] args = {book.getName(), book.getPrice()};
            argsList.add(args);
        }
        jdbcTemplate.batchUpdate(sql, argsList);
    }

    @Override
    public void batchUpdate(List<Book> books) {
        String sql = "update springBook set price = ? where name = ?";

        List<Object[]> argsList = new ArrayList<>();
        for (Book book : books) {
            Object[] args = {book.getPrice(), book.getName()};
            argsList.add(args);
        }
        jdbcTemplate.batchUpdate(sql, argsList);

    }

    @Override
    public void batchDelete(List<String> names) {
        String sql = "delete from springBook where name = ?";

        List<Object[]> argsList = new ArrayList<>();
        for (String name : names) {
            Object[] args = {name};
            argsList.add(args);
        }
        jdbcTemplate.batchUpdate(sql, argsList);
    }

    @Override
    public List<Book> findAll() { // 查询到结果，封装到pojo（无参ctor + setter，因此，需要提供）
        String sql = "select * from springBook";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        // BeanPropertyRowMapper：
        // T：为了确定返回对象的类型
        // class对象：利用反射 获取pojo信息，从而 将结果转化为pojo
        return books;
    }

    @Override
    public Book findBookByName(String name) {
        String sql = "select * from springBook where name = ?";
        Book books = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), name);
        return books;
    }

    @Override
    public Double findPriceByName(String name) {
        String sql = "select price from springBook where name = ?";
        Double price = jdbcTemplate.queryForObject(sql, Double.class, name); // 基础数据类型,不用RowMapper封装到pojo
        return price;
    }
}
