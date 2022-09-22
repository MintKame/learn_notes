package com.yz.sb._2_properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class _1_test {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(_1_test.class);

        _1_Car car = run.getBean(_1_Car.class);
        System.out.println(car); // Car{brand='byd', price=100000}
    }
}
