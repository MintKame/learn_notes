package _8_graph.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-27- 14:29:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;
import java.util.Scanner;

public class tmp {
    static int [][]graph;
    static int []cost;
    static int []ind;
    static int []etv;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
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
            while (from != -1){
                graph[from][to - from - 1] = 1;
                ind[to]++;
                from = input.nextInt() - 1;
            }
            if(ind[to] == 0){
                etv[to] = 0;
            }
        }
        //top + etv
        boolean complete = false;
        while (!complete)
        {
            complete = true;
            // find to visit
            for (int j = 0; j < vNum; j++) {
                if (ind[j] == 0) {
                    complete = false;
                    ind[j] = -1;
                    for (int k = j + 1; k < vNum; k++) {
                        if (graph[j][k - j - 1] == 1){
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
}
