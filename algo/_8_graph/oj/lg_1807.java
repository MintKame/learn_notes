package _8_graph.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-25- 16:33:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;
import java.util.Scanner;

/* ac
图G中<1,n> 的最长路径。
    第一行有两个整数，分别代表图的点数 n 和边数 m。
    第 2 到第 (m+1) 行，每行 3 个整数: 从 u 到 v 边权为 w 的边。
    输出一行一个整数，代表 1 到 n 的最长路。
    若不联通，请输出 −1
    2 1
    1 2 1           1
*/
public class lg_1807 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //index = num - 1
        int vNum = input.nextInt();
        int eNum = input.nextInt();
        int[][] weight = new int[vNum][vNum];   //init
        for (int i = 0 ; i < vNum; i++){
            weight[i] = new int[vNum];
            Arrays.fill(weight[i], -1);
            weight[i][i] = 0;
        }
        for (int i = 0; i < eNum; i++) {
            int from = input.nextInt(), to = input.nextInt(), val = input.nextInt();
            if (val > weight[from - 1][to - 1])
            weight[from - 1][to - 1] = val;
        }
        for (int[] i : weight) {
            System.out.println(Arrays.toString(i));
        }
//        0 1
//        0 0
        for (int k = 0; k < vNum; k++) {
            for (int i = 0; i < vNum; i++) {
                for (int j = 0; j < vNum; j++) {
                    if (i != j && weight[i][k] != -1 && weight[k][j] != -1){
                        weight[i][j] = Math.max(weight[i][j], weight[i][k] + weight[k][j]);
                    }
                }
            }
        }
        System.out.println(weight[0][vNum - 1]);
    }
}
