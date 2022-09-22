package _8_graph.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-26- 20:40:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;
import java.util.Scanner;


public class lg_1113 {
    static Scanner input = new Scanner(System.in);

    public static void mle() {
        // MLE： top关系大在小之后，下标用偏移存关系
        int[][] graph;
        int[] cost;
        int[] ind;
        int[] etv;
        //init
        int vNum = input.nextInt();
        graph = new int[vNum][vNum];
        cost = new int[vNum];
        ind = new int[vNum];
        etv = new int[vNum];
        Arrays.fill(etv, 0);
        for (int i = 0; i < vNum; i++) {
            int to = input.nextInt() - 1;
            graph[to] = new int[vNum - to - 1];
            cost[to] = input.nextInt();
            int from = input.nextInt() - 1;
            while (from != -1) {
                graph[from][to - from - 1] = 1;
                ind[to]++;
                from = input.nextInt() - 1;
            }
            if (ind[to] == 0) {
                etv[to] = 0;
            }
        }
        //top + etv
        boolean complete = false;
        while (!complete) {
            complete = true;
            // find to visit
            for (int j = 0; j < vNum; j++) {
                if (ind[j] == 0) {
                    complete = false;
                    ind[j] = -1;
                    for (int k = j + 1; k < vNum; k++) {
                        if (graph[j][k - j - 1] == 1) {
                            ind[k]--;
                            etv[k] = Math.max(etv[k], etv[j] + cost[j]);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < vNum; i++) {
            max = Math.max(max, cost[i] + etv[i]);
        }
        System.out.println(max);
    }

    //前置条件为更小的标号。可输入后直接更新，不用存制约关系。
    public static void ac() {
        int vNum = input.nextInt();
        int[] end = new int[vNum]; //最早完成时间
        Arrays.fill(end, 0);
        int ans = 0; //end[] 中最大值
        //输入并设置end数组
        for (int i = 0; i < vNum; i++) {
            input.nextInt();    //标号
            int cost = input.nextInt();
            int pre = input.nextInt() - 1;  // -1 (index from 1)
            while (pre != -1){
                end[i] = Math.max(end[i], end[pre]);    //先设置为最早开始时间
                pre = input.nextInt() - 1;
            }
            end[i] += cost;
            ans = Math.max(ans, end[i]);
        }
        System.out.println(ans);
        /*
        for (int i = 0; i < vNum; i++) {
            System.out.print(end[i] + "\t");
        }
         */
    }

    public static void main(String[] args) {
        ac();
    }
}

//第1行：一个整数n 必须完成的杂务的数目(3≤n≤10,000)；
//        第2至(n+1)行： 共有n 行，每行有一些用1个空格隔开的整数
//        * 工作序号(1至n,在输入文件中是有序的)；
//        * 完成工作所需要的时间
//        * 一些必须完成的准备工作，总数不超过100，由0结束。
//整数，表示完成所有杂务所需的最短时间。
//        杂务k 准备工作只可能在杂务1 - k−1中。
/*
        7
        1 5 0
        2 2 1 0
        3 3 2 0
        4 6 1 0
        5 1 2 4 0
        6 8 2 4 0
        7 4 3 5 6 0
        23
*/