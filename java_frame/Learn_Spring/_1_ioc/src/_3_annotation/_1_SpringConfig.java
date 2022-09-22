package _3_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"_3_annotation",}) // 扫描所有注解，多个包用逗号隔开
public class _1_SpringConfig {
}
