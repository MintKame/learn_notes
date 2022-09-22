# 题目：剑指Offer58-II.左旋转字符串

 https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例 1：    
输入: s = "abcdefg", k = 2   
输出: "cdefgab"      

示例 2：     
输入: s = "lrloseumgh", k = 6     
输出: "umghlrlose"        

限制：      
1 <= k < s.length <= 10000        

# 思路

+ 如何时间O(n) 空间O(1)？

  双指针不可，因为左右2部分长度不同

+ 具体步骤：

1. 反转区间为前n的子串
2. 反转区间为n到末尾的子串
3. 反转整个字符串

类似上一题目[字符串：花式反转还不够！](https://programmercarl.com/0151.翻转字符串里的单词.html)

+ 例如 ：字符串abcdefg，n=2

  

<img src='https://code-thinking.cdn.bcebos.com/pics/剑指Offer58-II.左旋转字符串.png' width=600> </img></div>

+ 构造


```java
 // 时间O(n) 空间O(n)
public class Solution5 {
    public String reverseLeftWords(String s, int n){
        final StringBuffer sb = new StringBuffer(s.length());
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    } 
}
```

+ 双旋转

```java
// 时间O(n) 空间O(1)  
public class Solution5 {
      public String reverseLeftWords(String s, int n){
          final char[] chars = s.toCharArray();
          reverse(chars, 0, n-1);
          reverse(chars, n, s.length() - 1);
          reverse(chars, 0, s.length() - 1);
          return new String(chars);
      }
  
      static void reverse(char[] chars, int left, int right){
          while (left < right){
              char tmp = chars[left];
              chars[left] = chars[right];
              chars[right] = tmp;
              left++;
              right--;
          }
      }
  }
```

  