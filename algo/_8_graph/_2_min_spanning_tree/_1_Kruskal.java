package _8_graph._2_min_spanning_tree;/*
 * @Author: 闫昭
 * @Date: 2020-11-14- 19:46:00
 * @LastEditors:
 * @Description:
 */

import connect.UF_v2;
import _8_graph._1_graph_.Graph_un;

import java.util.LinkedList;
import java.util.PriorityQueue;

//for undirected graph
public class _1_Kruskal {

    static class Edge implements Comparable<Edge>{
        int tail;
        int head;
        int weight;
        Edge(int tail_, int head_, int weight_){
            tail = tail_;
            head = head_;
            weight = weight_;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
        @Override
        public String toString() {
            return "( " + tail +
                    ", " + head + " )" ;
        }
    }

    // O(e * lge)
    public static LinkedList<Edge> minSpanTree_K(Graph_un graph){
        int vNum = graph.getvNum();
        UF_v2 vertex = new UF_v2(vNum);    //to union vertex
        PriorityQueue<Edge> edges = new PriorityQueue(graph.geteNum());
        LinkedList<Edge> spanEdge = new LinkedList<>();
        //  all edges -> queue(auto-sorted)
        for (int i = 0; i < vNum; i++) {
            for (int j = i + 1; j < vNum; j++) {    //from i + 1, caz undirected
                int weight = graph.getWightOf(i, j);
                if(weight > 0){
                    edges.add(new Edge(i ,j, weight));
                }
            }
        }
        //  loop until edge is enough (v - 1) / no edges provided
        while (spanEdge.size() < vNum - 1 && edges.size() != 0 ){
            //      choose the smallest e
            Edge e = edges.remove();
            //      must link 2 vertex (from diff set)
            if(!vertex.isConnected(e.head, e.tail)){
                spanEdge.addLast(e);//record span tree's edges
                vertex.union(e.head, e.tail);
            }
        }
        if(spanEdge.size() == vNum - 1){
            return spanEdge;
        }else {
            System.out.println("can't generate span tree");
            return null;
        }
    }
}


