import org.springframework.lang.Nullable;

public class _2_Nullable {

    // 属性值可以为空
    @Nullable
    String s1;

    // 方法返回值可以为空
    @Nullable
    String hello1(){
        return null;
    }

    // 方法参数可以为空
    void hello2(@Nullable String str){
        System.out.println(str);
    }

}
