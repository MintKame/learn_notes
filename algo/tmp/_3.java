package tmp;/*
 * @Author: 闫昭
 * @Date: 2020-11-20- 19:24:00
 * @LastEditors:
 * @Description:
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//A min span
//B top
//C shortest path
//D shortest path
public class _3 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            int v = input.nextInt();
            if (v == 0){
                break;
            }
            int from = input.nextInt();
            int to = input.nextInt();
            G3 graph = new G3(v);
            graph.min_path();
            System.out.println(graph.weight[from - 1][to - 1]);
        }
    }
    static class G3{
        int vNum ;
        int[][] weight;
        G3(int vNum){
            this.vNum = vNum;
            weight = new int[vNum][vNum];
            for (int i = 0; i < vNum; i++) {
                Arrays.fill(weight[i], -1);
                weight[i][i] = 0;
                int k = input.nextInt();
                if (i + k < vNum){
                    weight[i][i + k] = 1;
                }
                if (i - k >= 0){
                    weight[i][i - k] = 1;
                }
            }
        }
        void min_path(){
            for (int i = 0; i < vNum; i++) {
                for (int j = 0; j < vNum; j++) {
                    for (int k = 0; k < vNum; k++) {
                        if (weight[j][k] < weight[j][i] + weight[i][k] && weight[j][i] != -1 && weight[i][k] != -1){
                            weight[j][k] = weight[j][i] + weight[i][k];
                        }
                    }
                }
            }
        }
    }
}
/*
      a number Ki(0 <= Ki <= N) on every floor.
      just two buttons: up and down.
        at floor i  press  "UP" , you will go to the i+Ki th floor
         can't go up high than N,and can't go down lower than 1.
          5 floors, and k1 = 3, k2 = 3,k3 = 1,k4 = 2, k5 = 5.
         when you are on floor A,and you want to go to floor B,
        how many times at least press the button "UP" or "DOWN"?

        The first line contains three integers N ,A,B( 1 <= N,A,B <= 200)
        which describe above,The second line consist N integers k1,k2,....kn.
        A single 0 indicate the end of the input.
        Output
        For each case of the input output a interger, the least times you have to press the button when you on floor A,and you want to go to floor B.If you can't reach floor B,printf "-1".

        several test cases -> two lines.
        5 1 5
        3 3 1 2 5
        0
         Output
        3
 */