package _4_str;

public class _2_wrapper {

    //! diff cls                                            when-use ?
    //String           immutable  效率低，复用率高         rare change, ref by many obj
    //StringBuilder    mutable    效率最高，unsafe        many change, many tasks
    //StringBuffer     mutable    效率高，safe(sync)      many change, 1 task

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder(100); // 指定char[]的大小
        sb = new StringBuilder("hello world");

        //! modify
        //      change builder && ret ref
        StringBuilder sb1 = sb.append("!");
        System.out.println(sb1 == sb); // true, same obj

        sb.delete(6, 11); // [6, 11), 6 is 'w' => "hello !"
        sb.replace(5, 7, "???"); // "hello???"
        sb.setCharAt(0, 'H'); // exception, not return ref "Hello???"

        //!
        sb.indexOf("H"); // 0

        sb.length();    // actual stored size
        sb.capacity();  // arr's size, arr auto inc when not enough
        //
        sb.setLength(0);    // truncate / add 0
        sb.trimToSize();    // set cap = size

        //! null
        String s = null;
        new StringBuilder().append(s); // "null"
//        new StringBuilder(s); // NullPtrEx
        // src:
        //  super(str.length() + 16); // length() => err
        //  append(str);

        //! trans
        // str -> sb
        new StringBuilder("s");
        new StringBuilder().append("s");
        // sb -> str
        sb.toString();
        new String(sb);

        //! eg 数字整数部分每三位添加逗号
        String price = "1234567.12"; // 1,234,567.12
        sb = new StringBuilder(price);
        for (int i = sb.indexOf(".") - 3; i > 0; i -= 3){
            sb.insert(i, ',');
        }
        System.out.println(sb);
    }
}
