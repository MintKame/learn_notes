package _2_stack_queue._4_oj_linear;

import java.util.ArrayList;
import java.util.Scanner;

/*
(5a^2+3a^1+2)*(4a^1+1)
(5a^1+1)* (5a^1+1)

20a^3+17a^2+11a^1+2
25a^2+10a^1+1

(1a^1+1a^2)*(1a^1+1a^2) wa
*/
//用arraylist，因为没有很多删加操作
class PolyData implements Comparable { // 每个项
  int exp;
  int coef;

  PolyData(int c, int e) {
    exp = e;
    coef = c;
  }

  @Override
  public int compareTo(Object o) {
    return exp - ((PolyData) o).exp;
  }

  @Override
  public boolean equals(Object p) {
    return ((PolyData) p).exp == exp;
  }

  // 必须是同类项
  public PolyData add(PolyData p) {
    return new PolyData(p.coef + coef, exp);
  }

  public PolyData multi(PolyData p) {
    return new PolyData(coef * p.coef, exp + p.exp);
  }

  public String toString() {
    String ret = "" + coef;
    if (exp != 0) {
      ret += "a^" + exp;
    }
    return ret;
  }
}

public class lg_2553_poly {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ArrayList<PolyData> out;
    while (in.hasNext()) {
      // input:
      String str = in.nextLine();
      // 输入的str转化为输出的list
      // 若有乘法
      if (str.contains("*")) {
        printPoly(hasMulti(str));
      }
    }
  }

  // 各项都是 xa^y 的形式(只有符号a)，可能出现空白字符
  // 1a^1+1a^2
  static ArrayList<PolyData> noMulti(String str) {
    ArrayList<PolyData> ret = new ArrayList<>();
    // 初始化开始与结束位置
    int start, end;
    // 处理括号
    if (str.contains("(")) {
      start = str.indexOf("(") + 1;
      end = str.indexOf(")") - 1;
    } else {
      start = 0;
      end = str.length() - 1;
    }
//    System.out.print(start);
    // 遍历字符串（无括号，只有加法）
    for (int i = start; i <= end; i++) {
      // 跳过空白,a,^,+
      for (; i <= end
          && (str.charAt(i) == ' ' || str.charAt(i) == 'a' || str.charAt(i) == '^' || str.charAt(i) == '+'); i++)
        ;
      // 获取数字
      int c;
      for (c = 0; i <= end && str.charAt(i) <= '9' && str.charAt(i) >= '0'; i++) {
        c = c * 10 + (str.charAt(i) - '0');
      }
//      System.out.println("i: " + i + "c: " + c);
      // 跳过空白,a,^,+
      for (; i <= end
          && (str.charAt(i) == ' ' || str.charAt(i) == 'a' || str.charAt(i) == '^' || str.charAt(i) == '+'); i++)
        ;
//      System.out.println("i: " + i );
      // 加入多项式 (判断是否为0次项)
      if (i == end + 1) {
        ret.add(new PolyData(c, 0));
      } else {
        int e;
        for (e = 0; i <= end && str.charAt(i) <= '9' && str.charAt(i) >= '0'; i++) {
          e = e * 10 + (str.charAt(i) - '0');
        }
//        System.out.println("i: " + i + "e: " + e);
        ret.add(new PolyData(c, e));
      }
    }
    // 返回list
    return ret;
  }

  static ArrayList<PolyData> hasMulti(String str) {
    // 创建2个arraylist，分别设置两个多项式
    ArrayList<PolyData> a = noMulti(str.substring(0, str.indexOf('*')));
    ArrayList<PolyData> b = noMulti(str.substring(str.indexOf('*')));
    // multi
    ArrayList<PolyData> ret = new ArrayList<PolyData>();
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < b.size(); j++) {
        ret.add(a.get(i).multi(b.get(j)));
      }
    }
    ret = mergePoly(ret); // 合并同类项
    return ret;
  }

  static void printPoly(ArrayList<PolyData> p) {
    //特例：只有一项为0
    if(p.size() == 1 && p.get(0).coef == 0) {
      System.out.println(0);
    }
    // 逆序输出
    int tag = 0;
    for (int i = p.size() - 1; i >= 0; i--) {
      if (p.get(i).coef != 0) {
        if (tag != 0)
          System.out.print("+");
        System.out.print(p.get(i).toString());
        tag = 1;
      }
    }
  }

  static ArrayList<PolyData> mergePoly(ArrayList<PolyData> s) {
    // 按照从小到大排序
    s.sort(null);
    ArrayList<PolyData> ret = new ArrayList<PolyData>();
    for (int i = 0; i < s.size(); i++) { // 直到最后项
      PolyData tmp = s.get(i);
      while (i < s.size() - 1 && tmp.equals(s.get(i + 1))) {
        tmp = tmp.add(s.get(i + 1));
        i++;
      }
      ret.add(tmp);
    }
    return ret;
  }
}
