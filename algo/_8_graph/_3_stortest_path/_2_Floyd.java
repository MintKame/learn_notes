package _8_graph._3_stortest_path;/*
 * @Author: 闫昭
 * @Date: 2020-11-14- 19:50:00
 * @LastEditors:
 * @Description:
 */
//
import _8_graph._1_graph_.Graph_un;
//get reverse of pass sequence (not contain 2 ends)
//        int a = 0, b = 0;
//                while (path[a][b] != a){
//                b = path[a][b];
//                System.out.println(b);
//                }

public class _2_Floyd {
    //return shortest path: each vertex <-> another vertex
    public static void shortPath_F(Graph_un graph, int[][] path, int[][] distance) {
        int vNum = graph.getvNum();
        //init -> weight
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                path[i][j] = i;
                distance[i][j] = graph.getWightOf(i, j);
                if (distance[i][j] == -1)
                    distance[i][j] = Integer.MAX_VALUE;
            }
        }
        //dp
        for (int k = 0; k < vNum; k++) {
            for (int i = 0; i < vNum; i++) {
                for (int j = 0; j < vNum; j++) {    //avoid overflow
                    int newDistance;
                    if (distance[i][k] == Integer.MAX_VALUE ||distance[k][j] == Integer.MAX_VALUE){
                        newDistance = Integer.MAX_VALUE;
                    } else {
                        newDistance = distance[i][k] + distance[k][j];
                    }
                    if (newDistance < distance[i][j]){
                        distance[i][j] = newDistance;
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }
}
