package _8_graph._3_stortest_path;/*
 * @Author: 闫昭
 * @Date: 2020-11-14- 19:50:00
 * @LastEditors:
 * @Description:
 */

import _8_graph._1_graph_.Graph_un;
import java.util.Arrays;
public class _1_Dijkstra {


    public static void shortPath_D(Graph_un graph, int[][] adj, int[][] distance){
        //adj[a][b] - 1st vertex passed from a to b (b's pre)
        //            if no other vertex passed, = a
        int vNum = graph.getvNum();
        for (int i = 0; i < vNum; i++) {
            shortPath_0(graph, i, adj[i], distance[i]);
        }
    }
    //each vertex -> src
    public static void shortPath_0(Graph_un graph, int src, int[] adj, int[] distance){
        int vNum = graph.getvNum();
        boolean[] visited = new boolean[vNum];  //whether added to path
        Arrays.fill(visited, false);
        //visit src
        adj[src] = src;
        distance[src] = 0;
        visited[src] = true;
        //reset adj
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i : graph.getReachable(src)) {
            adj[i] = src;
            distance[i] = graph.getWightOf(src, i);
        }
        //vertex: v - 1
        for (int j = 1; j < vNum; j++) {
            //find vertex to visit
            int minDis = Integer.MAX_VALUE;
            int nearIndex = 0;
            int flag = 0;
            for (int i = 0; i < vNum; i++) {
                if (!visited[i] && distance[i] < minDis){
                    //not visit & near
                    minDis = distance[i];
                    nearIndex = i;
                    flag = 1;
                }
            }
            if (flag == 0){
                break;
            }
            //visit vertex
            visited[nearIndex] = true;
            //reset adj
            for (int i = 0; i < vNum; i++) {
                int weight = graph.getWightOf(nearIndex, i);
                if (!visited[i] && weight > 0 && distance[nearIndex] + weight < distance[i]){
                    distance[i] = distance[nearIndex] + weight;
                    adj[i] = nearIndex;
                }
            }
        }
    }
}


