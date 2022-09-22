import demo.Book;
import demo.BookDao;
import demo.BookDaoImpl;
import org.springframework.context.support.GenericApplicationContext;

public class _3_genericApplicationContext {
    public static void main(String[] args) {
        /*
            之前都是：xml/注解 创建对象，对象由spring管理

            函数式注册对象
                若手动new对象，需要注册才被spring管理
         */
        //! 注册
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.registerBean(Book.class, () -> new Book("活着", 123.0));
        context.registerBean("bookDao1111", BookDao.class, () -> new BookDaoImpl());
        //! 获取对象
        // 注册时起名，可根据名字获取
        Object bean = context.getBean("bookDao1111");
        System.out.println(bean);
        // 可根据类型获取
        Book bean1 = context.getBean(Book.class);
        System.out.println(bean1);

        Object bean2 = context.getBean("demo.Book"); // 类全路径
        System.out.println(bean2);
    }
}