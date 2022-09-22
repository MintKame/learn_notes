package _8_graph.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-22- 21:21:00
 * @LastEditors:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lg_5318_dfs_bfs {
    static Scanner input = new Scanner(System.in);
    static class Graph1{
        int vNum, eNum;
        int[][] eData;
        int[] visited;
        Graph1(){
            vNum = input.nextInt();
            eNum = input.nextInt();
            eData = new int[vNum][vNum];
            //init
            for (int i = 0; i < vNum; i++) {
                eData[i] = new int[vNum];
                Arrays.fill(eData[i], 0);
            }
            for (int i = 0; i < eNum; i++) {
                int from = input.nextInt(), to = input.nextInt();
                eData[from - 1][to - 1] = 1;
            }
        }

        void dfs(){
            visited = new int[vNum];
            Arrays.fill(visited, 0);
            for (int i = 0; i < vNum; i++) {
                if (visited[i] == 0){
                    dfs0(i);
                }
            }
        }

        void dfs0(int index){
            System.out.print(index + 1 + " ");
            visited[index] = 1;
            for (int i = 0; i < vNum; i++) {
                if (visited[i] == 0 && eData[index][i] == 1){
                    dfs0(i);
                }
            }
        }

        void bfs(){
            visited = new int[vNum];
            ArrayList<Integer> visiV = new ArrayList<Integer>();
            Arrays.fill(visited, 0);
            for (int i = 0; i < vNum; i++) {
                if (visited[i] == 0){
                    visited[i] = 1;
                    System.out.print(i + 1 + " ");
                    visiV.add(i);
                }
                while (visiV.size() != 0){
                    int index = visiV.remove(0);
                    for (int j = 0; j < vNum; j++) {
                        if (visited[j] == 0 && eData[index][j] == 1){
                            visited[j] = 1;
                            System.out.print(j + 1 + " ");
                            visiV.add(j);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph1 g = new Graph1();
        g.dfs();
        System.out.println();
        g.bfs();
    }
}
/*
分别进行 DFS 和 BFS，并输出遍历结果。
如果有很多篇文章可以参阅，请先看编号较小的那篇(
        8 9
        1 2
        1 3
        1 4
        2 5
        2 6
        3 7
        4 7
        4 8
        7 8
        1 2 5 6 3 7 8 4
        1 2 3 4 5 6 7 8
 */