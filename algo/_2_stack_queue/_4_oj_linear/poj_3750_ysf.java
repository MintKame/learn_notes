package _2_stack_queue._4_oj_linear;
import java.util.ArrayList;
import java.util.Scanner;

public class poj_3750_ysf {

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();    //小孩的人数
    ArrayList<String> list = new ArrayList<String>();
    in.nextLine();
    //接下来每行输入一个小孩的名字(人名不超过15个字符)
    for(int i = 0; i < size; i++) {
      list.add(in.nextLine());
    }
    //最后一行输入W,S (W < N)，用逗号","间隔
    String tmp = in.nextLine();
    int begin = Character.getNumericValue(tmp.charAt(0)) - 1;   //1
    int num = Character.getNumericValue(tmp.charAt(2)) - 1;     //2
    //N个小孩围成一圈，给他们从1开始依次编号，现指定从第W个开始报数，
    //报到第S个时，该小孩出列，然后从下一个小孩开始报数，仍是报到S个出列，
    //按人名输出小孩按顺序出列的顺序，每行输出一个人名
    for(int i = begin; list.size() > 0; ) {
      i = (i + num) % list.size();
      System.out.println(list.get(i));
      list.remove(i);
    }
  }
}