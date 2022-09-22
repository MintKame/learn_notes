package _8_graph;/*
 * @Author: 闫昭
 * @Date: 2020-11-13- 21:09:00
 * @LastEditors:
 * @Description:
 */

import _8_graph._1_graph_.Graph_a;
import _8_graph._1_graph_.Graph_l;
import _8_graph._4_topological_sort.CriticalPath;
import _8_graph._4_topological_sort.Topo;

import java.io.*;
import java.util.Arrays;

public class test_d {
    public static void main(String[] args) throws IOException {
        File file = new File("graph_d.txt");
        Graph_a graph = Graph_a.getDirected(file);
        Graph_l graph_l = Graph_l.getDirected(file);
        System.out.println(graph);
        System.out.println("dfs:\t");
        graph.dfs();
        System.out.println("\nbfs:\t");
        graph.bfs();
        System.out.println();
        System.out.println("top_sort: " + Topo.top_sort(graph));
        //critical path
        System.out.println("etv" + Arrays.toString(CriticalPath.etv(graph)));
        System.out.println("ltv" + Arrays.toString(CriticalPath.ltv(graph)));
        System.out.println("ete" + Arrays.toString(CriticalPath.ete(graph)));
        System.out.println("lte" + Arrays.toString(CriticalPath.lte(graph)));
        System.out.println(CriticalPath.criticalPath_a(graph)); //array
        CriticalPath.criticalPath_l(graph_l);
    }
}
