package _4_str;

public class Tmp {
    public static void main(String[] args) {
        String a1 = "abc";
        String a2 = new String(a1);
        String a3 = new String(new char[]{'a', 'b', 'c'});

        String b1 = new String(new char[]{'1', '2', '3'});
        b1.intern();
        String b2 = "123";
        String b3 = new String(b1);

        String s1 = new String(new char[]{'a', 'b', 'c'});
        String s2 = new String(new byte[]{97, 98, 99});
        String s3 = new String(new int[]{0x1F602}, 0, 1);
        String s4 = new String(s1);
// 使用字面量（不用 new）
        String s5 = "abc";
        String s6 = "a" + "b";
    }
}
