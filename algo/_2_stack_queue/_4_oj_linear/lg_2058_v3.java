package _2_stack_queue._4_oj_linear;
import java.util.Scanner;

public class lg_2058_v3 {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int total = in.nextInt();
    int [][]list = new int[total][];
    int []nation = new int[100005];
    //in
    for(int i = 0; i < total; i++) {
      int time = in.nextInt();
      int cnt_people = in.nextInt();
      list[i] = new int[cnt_people + 2];
      list[i][0] = time; list[i][1] = cnt_people;
      for(int j = 0; j < cnt_people; j++) {
        list[i][j + 2] = in.nextInt();
      }
    }
    int valid_ship = 0, ret = 0;
    for(int i = 0; i < total; i++) {    //遍历所有的船
      //加本船的所有国籍
      for(int j = 0; j < list[i][1]; j++) {
        nation[list[i][j + 2]]++;
        if(nation[list[i][j + 2]] == 1) {
          ret++;
        }
      }
      //删除无效的所有国籍
      for(; list[i][0] - list[valid_ship][0] >= 86400; valid_ship++) {
        for(int k = 0; k < list[valid_ship][1]; k++) {
          nation[list[valid_ship][k + 2]]--;
          if(nation[list[valid_ship][k + 2]] == 0) {
            ret--;
          }
        }
      }
      //输出国籍数
      System.out.println(ret);
//      for(int tmp = 0; tmp < 300005; tmp++){    //
//        if(nation[tmp] != 0) {
//          System.out.println(tmp + ": " + nation[tmp]);
//        }
      }
    
  }
}
