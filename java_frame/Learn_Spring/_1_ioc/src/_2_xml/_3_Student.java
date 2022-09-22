package _2_xml;

public class _3_Student {
    String name;
    // 1
    public _3_Student(){
        System.out.println("无参ctor");
    }
    // 2
    public void setName(String name) {
        this.name = name;
        System.out.println("property setter");
    }

    @Override
    public String toString() {
        return "Student-" +  name;
    }
    // 3
    // 需要xml中配置为 init-method
    private void init(){
        System.out.println("init-method");
    }
    // 5
    // 需要xml中配置为 destroy-method
    private void destroy(){
        System.out.println("destroy-method");
    }
}
