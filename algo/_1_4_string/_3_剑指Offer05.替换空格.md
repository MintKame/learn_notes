

# 题目：剑指Offer 05.替换空格

 https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof 

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1： 
输入：s = "We are happy."    
输出："We%20are%20happy."     

# 思路

![替换空格](https://tva1.sinaimg.cn/large/e6c9d24ely1go6qmevhgpg20du09m4qp.gif)

+ 从前向后填充：O(n^2)，每次添加元素都要将后面元素向后移。腾出位置。字符不能一次移动到最终位置

+ 双指针法：从后向前替换空格：i指向新长度的末尾，j指向旧长度的末尾。

+ 数组填充类问题，先数组扩容到填充后的大小，在从后向前填充。

  好处：

1. 不用申请新数组。空间复杂度：$O(1)$
2. 时间复杂度O(n)。

   

 ```java
public class Solution3 {
    // 先求出多少空格，str增加到最终长度，双指针，移动每个非空格
    public static String replaceSpace(String str) {
        int oldLen = str.length();
        final StringBuffer sb = new StringBuffer(str);
        // 先求出多少空格
        int cnt = 0;
        for (int i = 0; i < oldLen; i++) {
            if (sb.charAt(i) == ' '){
                cnt++;
            }
        }
        // 增加到最终长度：
        // 注意：" " -> "%20", 增加了2个字符
        sb.append(new char[cnt*2]);
        int newLen = sb.length();
        // 双指针(快慢指针)，移动每个非空格
        int left = oldLen - 1;
        int right = newLen - 1;
        while (left >= 0){ // 遍历旧字符
            final char c = sb.charAt(left);
            if (c == ' '){
                sb.setCharAt(right--, '0');
                sb.setCharAt(right--, '2');
                sb.setCharAt(right--, '%');
            } else {
                sb.setCharAt(right--, c);
            }
            left--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("ab c"));
    }
}
 ```



+ 从前往后，构造法

```java
//使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
		//选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder sb = new StringBuilder();
		//使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < str.length(); i++) {
		//str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
        //if (" ".equals(String.valueOf(str.charAt(i)))){
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
```

