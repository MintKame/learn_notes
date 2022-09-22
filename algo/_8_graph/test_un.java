package _8_graph;

import _8_graph._1_graph_.Graph_un;
import _8_graph._2_min_spanning_tree._1_Kruskal;
import _8_graph._2_min_spanning_tree._2_Prim;
import _8_graph._3_stortest_path._1_Dijkstra;
import _8_graph._3_stortest_path._2_Floyd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class test_un {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("graph.txt");
        Graph_un graph2 = Graph_un.getUnDirected(file);
        int vNum = graph2.getvNum();
        System.out.println(graph2);
        //minSpan Tree
        System.out.println("min_span_tree_k");
        System.out.println(_1_Kruskal.minSpanTree_K(graph2));
        System.out.println("min_span_tree_p");
        int[] adj = _2_Prim.minSpanTree_P(graph2);
        for (int i = 1; i < vNum; i++) {
            System.out.print("("  + adj[i] + ", " + i + ") " );
        }
        //short path
        System.out.println("\n\nshort_path_d");
        int [][] path = new int[vNum][vNum];
        int [][] dis = new int[vNum][vNum];
        _1_Dijkstra.shortPath_D(graph2, path, dis);
        System.out.println("\npath");
        for (int i = 0; i < vNum; i++) {
            System.out.println(Arrays.toString(path[i]));
        }
        System.out.println("\ndistance");
        for (int i = 0; i < vNum; i++) {
            System.out.println(Arrays.toString(dis[i]));
        }

        System.out.println("short_path_f");
        _2_Floyd.shortPath_F(graph2, path, dis);
        System.out.println("\npath");
        for (int i = 0; i < vNum; i++) {
            System.out.println(Arrays.toString(path[i]));
        }
        System.out.println("\ndistance");
        for (int i = 0; i < vNum; i++) {
            System.out.println(Arrays.toString(dis[i]));
        }


    }
}
