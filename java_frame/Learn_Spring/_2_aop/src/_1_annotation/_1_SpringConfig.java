package _1_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"_1_annotation"}) // 设置 组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true) // 开启 Aspect 生成代理对象
public class _1_SpringConfig {
}
