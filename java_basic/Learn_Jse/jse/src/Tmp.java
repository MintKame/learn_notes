// 0： X默认初始化为0
class ParentClass {
    private int parentX;
    public ParentClass() {
        setX(100);  // 1
    }
    public void setX(int x) {
        parentX = x; // 3 parentX = 100
    }
}
class ChildClass extends ParentClass{
    private int childX = 1; // 5 childX = 1
    // 子类初始化在父类ctor后？
    public ChildClass() {} // 6
    @Override
    public void setX(int x) { // 2
        super.setX(x); // 3
        childX = x; // 4 childX = 100
        System.out.println("ChildX 被赋值为 " + x); // 5
    }
    public void printX() {
        System.out.println("ChildX = " + childX);
    }

}

public class Tmp {
    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
        cc.printX(); // 7
    }
}
