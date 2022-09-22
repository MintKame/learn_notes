package _1_xml_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class _4_1_AAA {
    String[] arr;
    List<String> list;
    Set<String> set;
    Map<String, String> map;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public static void main(String[] args) {
        String xmlPath = "_1_xml_DI/_4_1__DI_collection.xml";
         xmlPath = "_1_xml_DI/_4_2__DI_col_reuse.xml";

        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(xmlPath);
        final _4_1_AAA aaa = context.getBean("aaa", _4_1_AAA.class);

        System.out.println(Arrays.toString(aaa.arr));
        System.out.println(aaa.list);
        System.out.println(aaa.map);
        System.out.println(aaa.set);
    }
}
