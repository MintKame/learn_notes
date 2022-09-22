package _1_xml_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class _4_3_BBB {
    _4_3_CCC[] arr;

    public void setArr(_4_3_CCC[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("_1_xml_DI/_4_3__DI_col_obj.xml");
        final _4_3_BBB bbb = context.getBean("bbb", _4_3_BBB.class);

        System.out.println(Arrays.toString(bbb.arr));
    }
}
