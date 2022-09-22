package _1_crud;

import java.util.List;

public interface BookDao {
    public void add(Book book);

    public void update(Book book);

    public void delete(String name);

    public void batchAdd(List<Book> books);

    public void batchUpdate(List<Book> books);

    public void batchDelete(List<String> names);

    public List<Book> findAll();

    public Book findBookByName(String name);

    public Double findPriceByName(String name);
}
