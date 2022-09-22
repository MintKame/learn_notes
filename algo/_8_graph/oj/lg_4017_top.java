package _8_graph.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-26- 20:38:00
 * @LastEditors:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Scanner;

/*
一个食物网，你要求出这个食物网中最大食物链的数量。
top 最长
 总数模 80112002
第一行，两个正整数 n、m，表示生物种类 n， 关系数 m
接下来 m 行 表示被吃的生物A和吃A的生物B。
5 7
1 2
1 3
2 3
3 5
2 5
4 5
3 4
5
* */
public class lg_4017_top {
    //adj list
    static class V{
        int ind = 0;    //cnt of animal can be eat
        int maxLen = 0;
        ArrayList<Integer> to = new ArrayList<>();  //all animal can eat
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //input
        int vNum = input.nextInt();
        V[] vertex = new V[vNum];
        for (int i = 0; i < vNum; i++) {
            vertex[i] = new V();
        }
        int eNum = input.nextInt();
        for (int i = 0; i < eNum; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            vertex[to].ind++;
            vertex[from].to.add(to);
        }



        //output

    }
}
