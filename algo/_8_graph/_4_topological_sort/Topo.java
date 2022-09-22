package _8_graph._4_topological_sort;
/*
 * @Author: 闫昭
 * @Date: 2020-11-21- 21:02:00
 * @LastEditors:
 * @Description:
 */

import _8_graph._1_graph_.Graph_a;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Topo {

    /** print if exist loop, return the sequence */
    public static LinkedList<Integer> top_sort(Graph_a graph) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        int vNum = graph.getvNum();
        //record in-degree
        int[] ind = new int[vNum];
        for (int i = 0; i < vNum; i++) {
            ind[i] = graph.getInDegree(i);
        }
        // loop: all ind != 0 (circle -> cnt < vNum)
        //       find 1st vertex ind == 0 && delete (dec ind of to-vertex & set this ind = -1 )
        int cnt = 0; // record vertex already delete
        for (int k = 0; k < vNum; k++) {
            int toVisit = -1;
            //find vertex to visit
            for (int i = 0; i < vNum; i++) {
                if (ind[i] == 0) {  // find ind == 0
                    toVisit = i;
                    ret.add(i);
                    ind[i] = -1;    // delete
                    break;
                }
            }
            if (toVisit == -1) {
                System.out.print("loop exist !\n");
                return null;
            }
            //reset adj
            for (int j = 0; j < vNum; j++) {
                if (graph.getWeightOf(toVisit, j) > 0) {
                    ind[j]--;
                }
            }
        }
        return ret;
    }


    /** faster - use queue O(n + e) */
    public static void top_sort_1(Graph_a graph){
        System.out.println("top sort:");
        int vNum = graph.getvNum();
        //record in-degree
        int[] ind = new int[vNum];
        //record index of vertex(ind == 0) (why priority ? small vertex first)
        PriorityQueue<Integer> ind0 = new PriorityQueue<>(vNum);
        int cnt = 0;    //cnt print time
        for (int i = 0; i < vNum; i++) {
            ind[i] = graph.getInDegree(i);  //set ind
            if (ind[i] == 0){                   //enqueue ind0
                ind0.add(i);
            }
        }
        while (ind0.size() != 0){
            //dequeue & delete ind0 vertex
            int index = ind0.remove();
            ind[index] = -1;
            System.out.print(index + " ");
            cnt ++;
            //delete edge
            for (int i = 0; i < vNum ; i++) {
                if (graph.getWeightOf(index, i) > 0){
                    ind[i]--;
                    //enqueue adj ind0
                    if (ind[i] == 0){
                        ind0.add(i);
                    }
                }
            }
        }
        if (cnt < vNum){
            System.out.println("loop exist !");
        }
        System.out.print('\n');
    }
}
