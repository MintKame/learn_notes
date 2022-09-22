package _8_graph.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-26- 20:45:00
 * @LastEditors:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Scanner;

public class lg_3916 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

    }
    //reverse adj list
        static class V{
            int max;
            ArrayList<Integer> from = new ArrayList<>();
            V(int max){
                this.max = max;
            }
        }

    static void tmp(){
        int vNum = input.nextInt();
        V[] vertex = new V[vNum];
        //each vertex can reach own
        for (int i = 0; i < vNum; i++) {
            vertex[i] = new V(i);
        }
        //input edge
        int eNum = input.nextInt();
        for (int i = 0; i < eNum; i++){
            int from = input.nextInt();
            int to = input.nextInt();
            vertex[to].from.add(from);
        }
        //
    }
}
/*
给出N个点，M条边的有向图，对于每个点v，能到达的编号最大的点。
  输入:  第1 行，N,M。接下来M行，每行2个整数Ui,Vi，表示边(Ui,Vi) (1 开始)
        4 3
        1 2
        2 4
        4 3
out:  4 4 3 4
10^5
*/