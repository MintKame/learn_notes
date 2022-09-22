package _2_stack_queue._4_oj_linear;

import java.util.ArrayList;
import java.util.Scanner;

public class lg_2058_seaPort {
//arraylist list 存有效的输入（时间，人数，每人国籍）
//          nation 存国籍
//每次输入后，判断是否有新的船不再记录，是则重新记录
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> nation = new ArrayList<Integer>();
    ArrayList<int[]> list = new ArrayList<>();  //每个船为一个node, [0]记录时间,[1]人数
    int total = in.nextInt();
    for(int i = 0; i < total; i++) {
      //in时间及人数，init数组
      int time = in.nextInt(), size = in.nextInt();
      int []arr = new int[size + 2];
      arr[0] = time;
      arr[1] = size;
      //in每个人的国籍，存到数组，并加入list
      for(int j = 0; j < size; j++) {
        arr[j + 2] = in.nextInt();
      }
      list.add(arr);
      //+本次船加入后，list是否改变（是否重新计算国籍数）
      //改变了，要重新计算
      if(time - list.get(0)[0] >= 86400) {
        nation.clear();
        boolean valide = true;
        //遍历list中之前的节点，与本次时间比较：
        for(int k = list.size() - 2; k >= 0; k--) {
          //1.无效的node，删
          if(!valide || time - list.get(k)[0] >= 86400) {
            list.remove(k);
            valide = false; //设置标志，之后的node都要删
          }
          //2.有效的node， 遍历数组，判断本国籍是否已有，无则加入nation
          else {
            int len = list.get(k)[1];
            for(int l = 0; l < len; l++) {
              if(!nation.contains(list.get(k)[l + 2])) {
                nation.add(list.get(k)[l + 2]);
              }
            }
          }
        }
      }
      //加入本次的
      for(int m = 0; m < size; m++) {
        if(!nation.contains(arr[m + 2])) {
          nation.add(arr[m + 2]);
        }
      }
      //输出nation的大小
      System.out.println(nation.size());
    }
  }
}