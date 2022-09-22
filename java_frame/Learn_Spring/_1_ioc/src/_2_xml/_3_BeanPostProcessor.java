package _2_xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

// 后置处理器：只要在xml中添加为bean，就作用于所有bean
public class _3_BeanPostProcessor implements BeanPostProcessor {
    // before 3 （作用于所有bean
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessor - BeforeInit");
        return bean;
    }

    // after 3 （作用于所有bean
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessor - AfterInit");
        return bean;
    }
}
