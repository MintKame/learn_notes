package _1_annotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    void add(){
        System.out.println("add.........");
    }

    void remove(){
        System.out.println("remove...........");
    }
}
