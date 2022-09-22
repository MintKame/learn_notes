package _2_xml;

import org.springframework.beans.factory.FactoryBean;

// _1_factoryBean实现FactoryBean接口
public class _1_factoryBean implements FactoryBean<_1_Book> {

    // 返回真正得到的对象
    @Override
    public _1_Book getObject() throws Exception {
        return new _1_Book();
    }

    @Override
    public Class<?> getObjectType() {
        return _1_Book.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
