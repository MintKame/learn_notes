package _3_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository(value = "hahaha")
public class _3_UserDaoImpl implements _3_UserDao{
    @Override
    public void add() {
        System.out.println("Dao add");
    }
}
