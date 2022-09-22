package _1_4_string;

public class _0_MyString {

    public static void main(String[] args) {
        String a = "aaazabababaaaazfa", b = "ababab";
        char[] string = new char[a.length()], pattern = new char[b.length()];
        a.getChars(0, a.length(), string, 0);
        b.getChars(0, b.length(), pattern, 0);
        int pos = kmpMatch(string, pattern);
        System.out.println(pos);
    }

    // todo
    // using char[]'s length -> need str use entire array
    public static int[] getKey(char[] string){
        return new int[]{-1, 0, 0, 1, 2, 3, 4};
    }

    // return pos in string
    public static int kmpMatch(char[] string, char[] pattern){
        int[] key = getKey(pattern);
        int mainIndex = 0, subIndex = 0;
        // loop char in string
        while (true){
            // loop char in pattern
            while (subIndex < pattern.length && mainIndex < string.length &&
                    pattern[subIndex] == string[mainIndex]){
                subIndex++;
                mainIndex++;
            }
            //
            if (subIndex == pattern.length){  // pattern end -> success
                return mainIndex - pattern.length;
            } else if (mainIndex == string.length){ // string end, but pattern not -> fail
                return -1;
            } else {    // not match -> next loop
                subIndex = key[subIndex];
                if (subIndex == -1){
                    subIndex++;
                    mainIndex++;
                }
            }
        }
    }
}
