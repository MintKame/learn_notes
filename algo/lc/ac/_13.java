package lc.ac;/*
 * @Author: 闫昭
 * @Date: 2020-11-27- 17:16:00
 * @LastEditors:
 * @Description:
 */

import java.util.HashMap;

public class _13 {
    public static void main(String[] args) {
//        System.out.println(solve("I"));
//        System.out.println(solve("III"));
//        System.out.println(solve("IV"));
//        System.out.println(solve("IX"));
//        System.out.println(solve("LVIII"));
//        System.out.println(solve("MCMXCIV"));
    }

    static int solve_ac(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int val = map.get(s.charAt(0)), nextVal;
        for (int i = 1; i <= s.length() - 1; i++) {
            nextVal = map.get(s.charAt(i));
            if (nextVal > val) {
                ans -= val;
            } else {
                ans += val;
            }
            val = nextVal;
        }
        ans += val;
        return ans;
    }
    static int solve_1(String s) {  //faster
        int ans = 0;
        int val = getVal(s.charAt(0)), nextVal;
        for (int i = 1; i <= s.length() - 1; i++) {
            nextVal = getVal(s.charAt(i));
            if (nextVal > val) {
                ans -= val;
            } else {
                ans += val;
            }
            val = nextVal;
        }
        ans += val;
        return ans;
}
    static int getVal(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
