package _2_stack_queue._4_oj_linear;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lg_2234_money {
  public static void main(String[] args) throws FileNotFoundException {
//输入由文件’turnover.in’读入。
    Scanner in = new Scanner("turnover.in");
    //    Scanner in = new Scanner(System.in);
    ArrayList<Long> src = new ArrayList<>(); // 不变
    List<Long> sorted;
    // 第一行为正整数n（n<=32767）天数，
    int n = in.nextInt();
    //n行每行一个整数ai(|ai|<=1000000) ，表示第i天公司的营业额，可能负
    for (int i = 0; i < n; i++) {
      src.add(in.nextLong());
    }
    // 第一天的最小波动值为第一天的营业额。
    long sum = src.get(0); // 初始为第一天波动
    // 遍历原数据每一天
    for (int i = 1; i < n; i++) {
      long today = src.get(i);
      // 获取今天+之前的营业额并排序
      sorted = src.subList(0, i + 1);
      sorted.sort(null);
      // 获取这一天的位置
      int inde = sorted.indexOf(today);
      System.out.println(sorted.toString() + " index: " + inde + " today: " + today);
      // 该天的最小波动值 = min{|之前某天的营业额-该天|}。
      if (inde == 0) {
        sum += Math.abs(sorted.get(1) - today);
      } else if (inde == i) {
        sum += Math.abs(sorted.get(i - 1) - today);
      } else {
        long left = today - sorted.get(inde - 1);
        long right = sorted.get(inde + 1) - today;
        sum += (left > right) ? right : left;
      }
    }
    // 输出正整数到turnover.out
    PrintWriter pw = new PrintWriter("turnover.out");
    pw.print(sum);
  }
}
