package _2_stack_queue._4_oj_linear;

import java.util.ArrayList;
import java.util.Scanner;

//resule: TLE
public class _n_2058_v2 {
//arraylist list 存有效的输入（时间，人数，每人国籍）
//          nation 存国籍
//          cnt     对应nation的人数
//每次输入后，判断是否有新的船不再记录，是则改cnt
  //+记录国籍的个数
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> nation = new ArrayList<Integer>();
    ArrayList<Integer> cnt = new ArrayList<Integer>();
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
      
      //TODO cnt与nation加入本次的
      for(int m = 0; m < size; m++) {
        if(!nation.contains(arr[m + 2])) { //新的国家
          nation.add(arr[m + 2]);
          cnt.add(1);
        }
        else {  
          int index = nation.indexOf(arr[m + 2]);
          cnt.set(index, cnt.get(index) + 1);
        }
      }

      //TODO 去掉失效的node，更新cnt（cnt到0则删cnt与nation的节点）
      while(time - list.get(0)[0] >= 86400) {
        int len = list.get(0)[1];   //对于被去掉的node中的每一个人
        for(int z = 0; z < len; z++) {
          int toDelete = list.get(0)[z + 2];
          int toDelete_index = nation.indexOf(toDelete);    //出现-1
          int toDelete_cnt = cnt.get(toDelete_index);
          if( toDelete_cnt == 1) {
            cnt.remove(toDelete_index);
            nation.remove(toDelete_index);
          }
          else {
            cnt.set(toDelete_index, toDelete_cnt - 1);
          }
        }
        list.remove(0);
      }
      //输出nation的大小
      System.out.println(nation.size());
    }
  }
}
/*
4
1 4 1 2 2 3
3 2 2 3
86401 2 3 4
86402 1 5
 * */

/*          
            for(int p = 0; p < list.get(k)[1]; p++) {
              int tmp = list.get(k)[p + 2]; //要被-1的国家
              int tmp_index = nation.indexOf(tmp);
              int tmp_remain = cnt.get(cnt.indexOf(tmp));
              if(tmp_remain == 1) {
                cnt.remove(tmp_index);
                nation.remove(tmp_index);
              }
              else {
                cnt.set(tmp_index, tmp_remain - 1);
              }
            }
            list.remove(k);
            valide = false; //设置标志，之后的node都要删
          }
        }
*/