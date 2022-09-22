package _9_reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tmp {
    // 使用反射，创建File对象，并创建文件
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final Class<?> aClass = Class.forName("java.io.File");
        // 创建File对象
        final Constructor<?> constructor = aClass.getConstructor(String.class);
        final Object abc = constructor.newInstance("abc");
        // 创建文件
        final Method method = aClass.getMethod("createNewFile");
        method.invoke(abc);
    }
}
