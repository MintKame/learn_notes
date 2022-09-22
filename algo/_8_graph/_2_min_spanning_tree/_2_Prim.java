package _8_graph._2_min_spanning_tree;/*
 * @Author: 闫昭
 * @Date: 2020-11-14- 19:44:00
 * @LastEditors:
 * @Description:
 */


import connect.UF_v2;
import _8_graph._1_graph_.Graph_un;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class _2_Prim {

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

    //O(n^2)
    public static int[] minSpanTree_P(Graph_un graph){
        int vNum = graph.getvNum();
        int[] adj = new int[vNum];
        int[] cost = new int[vNum];    //0 -> already visit
        Arrays.fill(cost, Integer.MAX_VALUE);
        //init: link v0
        cost[0] = 0;
        //reset adj vertex's cost && adj
        for (int i : graph.getReachable(0)) {
            adj[i] = 0;
            cost[i] = graph.getWightOf(0, i);
        }
        //vertex: v - 1
        for (int i = 1; i < vNum; i++) {    //i start from 1
            //find vertex to link
            int toLink = 0; //index of vertex to link
            int flag = 0;         // can generate span_tree (whether get a min edge)
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < vNum; j++) {
                if (cost[j] != 0 && cost[j] < minCost){
                    //not visit && less
                    toLink = j;
                    minCost = cost[j];
                    flag = 1;
                }
            }
            if (flag == 0) {   //not finish tree, but no edge
                System.out.println("can't generate spanning tree");
                return null;
            }
            //link
            cost[toLink] = 0;
            //reset adj vertex's cost && adj
            for (int j : graph.getReachable(toLink)){
                int weight = graph.getWightOf(toLink, j);
                if (weight < cost[j]){
                    cost[j] = weight;
                    adj[j] = toLink;
                }
            }
        }
        return adj;
    }

    public static LinkedList<Edge> minSpanTree_0(Graph_un graph){
        UF_v2 uf = new UF_v2(graph.getvNum());
        PriorityQueue<Edge> attachedEdges = new PriorityQueue<Edge>();  //1st - min weight edge
        LinkedList<Edge> spanEdge = new LinkedList<>(); //record spanTree's branch
        //init set -> already reach v[0]
        for (int adj : graph.getReachable(0)){
            attachedEdges.add(new Edge(0, adj, graph.getWightOf(0, adj)));
        }
        // take edges
        while (attachedEdges.size() != 0){
            Edge edge = attachedEdges.remove();
            // whether adj
            int tail = edge.tail, head = edge.head;
            int newVertex;
            if (!uf.isConnected(tail, 0)){
                newVertex = tail;
            }else if (!uf.isConnected(head, 0)){
                newVertex = head;
            }else {
                //already adj:
                continue;
            }
            //not adj:
            // union vertex
            uf.union(newVertex, 0);
            // record edge
            spanEdge.add(edge);
            // add all new edges
            for (int adj : graph.getReachable(newVertex)){
                attachedEdges.add(new Edge(newVertex, adj, graph.getWightOf(newVertex, adj)));
            }
        }
        if (spanEdge.size() < graph.getvNum() - 1){
            System.out.println("can't generate span tree");
            return null;
        }else {
            return spanEdge;
        }
    }
}
