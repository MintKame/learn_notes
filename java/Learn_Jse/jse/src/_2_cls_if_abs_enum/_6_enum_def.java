public class _6_enum_def {
    public static void main(String[] args) {
        Sex1 sex1 = Sex1.FEMALE;
    }
}

// 等价于
final class Sex1{
    // const: 固定，不可修改： no setter, private / default ctor
    // name: XX_XX
    public static final Sex1 MALE = new Sex1("男");
    public static final Sex1 FEMALE = new Sex1("女");
    // var member
    private Sex1(){}

    public static final Sex1 UNKNOW = new Sex1("女");

    private String desc;

    private Sex1(String desc){
        this.desc = desc;
    }
}

