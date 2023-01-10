package _4_num_str;

public class _1_3_convert_str {
    public static void main(String[] args) {

        //! string
        // -> str ( same result
        Integer integer1 = 1;
        String str = String.valueOf(1);
        str = String.valueOf(integer1);

        str = "" + 1;
        str = "" + integer1;  // 1. cast to int

        str = integer1.toString();

        // str -> int, Integer
        int i = Integer.parseInt("1");
        Integer iw = Integer.valueOf("1");
        iw = new Integer("1");
    }
}
