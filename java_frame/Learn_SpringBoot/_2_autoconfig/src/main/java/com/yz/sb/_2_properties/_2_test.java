package com.yz.sb._2_properties;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigurationProperties(_2_Car.class)
@SpringBootApplication
public class _2_test {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(_2_test.class);

        _2_Car car = run.getBean(_2_Car.class);
        System.out.println(car); // Car{brand='bmw', price=5000000}
    }
}
