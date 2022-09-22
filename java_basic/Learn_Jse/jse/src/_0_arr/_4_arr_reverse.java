package _0_arr;

public class _4_arr_reverse {
    public static void main(String[] args) {
        System.out.println(strReverse("abc"));
        System.out.println(strReverse("abcd"));
        System.out.println(strReverse(""));
        System.out.println(strReverse(null));
    }

    static String strReverse(String str){
        if (str == null){
            System.out.println("字符串为null");
            return null;
        }
        char[] chars = str.toCharArray();
        char tmp = ' ';
        for (int i = 0, j = chars.length - 1; i < j ;i++, j-- ){
            tmp = chars[i] ;
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
