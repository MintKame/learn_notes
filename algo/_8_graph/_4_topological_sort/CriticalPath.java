package _8_graph._4_topological_sort;/*
 * @Author: 闫昭
 * @Date: 2020-11-22- 14:07:00
 * @LastEditors:
 * @Description:
 */

import _8_graph._1_graph_.Graph_a;
import _8_graph._1_graph_.Graph_l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CriticalPath {

    public static int[] etv(Graph_a graph){
        if (graph == null) {
            return null;
        }
        LinkedList<Integer> top = Topo.top_sort(graph);
        int[] ret = new int[graph.getvNum()];
        ret[top.getFirst()] = 0;        //init 1st vertex in top
        for (int i = 1; i < top.size(); i++) {  //each vertex in top's positive order
            int index = top.get(i);     //index of vertex
            //max (pre-vertex + weight)
            int max = 0;
            for (int j = 0; j < i; j++) {
                int pre = top.get(j);  //index of pre-vertex
                int weight = graph.getWeightOf(pre, index);
                if (weight > 0 && ret[pre] + weight > max){ //link & greater than
                    max = ret[pre] + weight;
                }
            }
            ret[index] = max;
        }
        return ret;
    }

    public static int[] ltv(Graph_a graph){
        if (graph == null) {
            return null;
        }
        LinkedList<Integer> top = Topo.top_sort(graph);
        int[] ret = new int[graph.getvNum()];
        //last vertex in top
        ret[top.getLast()] = (etv(graph))[graph.getvNum() - 1];
        //each vertex in top's negative order
        for (int i = top.size() - 2; i >= 0; i--) {
            int index = top.get(i);     //index of vertex
            //min [(post vertex) - weight]
            int min = ret[top.getLast()];   //init min
            for (int j = i; j < top.size(); j++) {
                int post = top.get(j);  //index of post-vertex
                int weight = graph.getWeightOf(index, post);
                if (weight > 0 && ret[post] - weight < min) { //link & less than
                    min = ret[post] - weight;
                }
            }
            ret[index] = min;
        }
        return ret;
    }

    //edge order (from: inc, to: inc)
    public static int[] ete(Graph_a graph){
        if (graph == null) {
            return null;
        }
        int[] ret = new int[graph.geteNum()];
        int[] etv = etv(graph);
        int index = 0;
        for (int i = 0; i < graph.getvNum(); i++) {
            for (int j = 0; j < graph.getvNum(); j++) {
                if (graph.getWeightOf(i, j) > 0){   //find an edge
                    ret[index++] = etv[i];          //set == etv[from]
                }
            }
        }
        return ret;
    }

    public static int[] lte(Graph_a graph){
        if (graph == null) {
            return null;
        }
        int[] ret = new int[graph.geteNum()];
        int[] ltv = ltv(graph);
        int index = 0;
        for (int i = 0; i < graph.getvNum(); i++) {
            for (int j = 0; j < graph.getvNum(); j++) {
                int weight = graph.getWeightOf(i, j);
                if (weight > 0){   //find an edge
                    ret[index++] = ltv[j] - weight;          //set == ltv[to] - weight
                }
            }
        }
        return ret;
    }

    //return list of critical edges
    public static ArrayList<Integer> criticalPath_a(Graph_a graph){
        int[] ete = ete(graph);
        int[] lte = lte(graph);
        int eNum = graph.geteNum();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < eNum; i++) {    //find equal
            if (ete[i] == lte[i]) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static ArrayList<Integer> criticalPath_l(Graph_l graph) {
        int vNum = graph.getvNum();
        int eNum = graph.geteNum();
        int[] etv = new int[vNum];
        int[] ltv = new int[vNum];
        int[] ete = new int[eNum];
        int[] lte = new int[eNum];
        ArrayList<Integer> ret = new ArrayList<Integer>();

        // init ind & enqueue ind0
        int[] ind = new int[vNum];
        PriorityQueue<Integer> ind0 = new PriorityQueue<>();
        for (int i = 0; i < vNum; i++) {
            ind[i] = graph.getInDegree(i);
            if (ind[i] == 0){
                ind0.add(i);
            }
        }
        //get top sequence & etv  
        int cnt = 0;
        Arrays.fill(etv, 0);
        int[] topSeq = new int[vNum];
        while (ind0.size() != 0){
            //delete vertex
            int pos = ind0.remove();
            topSeq[cnt++] = pos;
            ind[pos] = -1;  //to indicate already used
            //delete edges (dec ind && set etv of adj-vertex)
            for (int adj : graph.getReachable(pos)){
                if (--ind[adj] == 0){
                    ind0.add(adj);
                }
                etv[adj] = Math.max( graph.getWeightOf(pos, adj) + etv[pos], etv[adj]);
            }
        }
        if (cnt < vNum){
            System.out.println("loop exist !");
            return null;
        }
        System.out.println("top " + Arrays.toString(topSeq));        //top
        System.out.println("etv " + Arrays.toString(etv));        //top
        //get ltv
        Arrays.fill(ltv, etv[topSeq[vNum - 1]]); //init with biggest
        for (int i = vNum - 2; i >= 0; i--) {   //neg traverse topSeq
            int pos = topSeq[i];
            //min(reachable - weight)
            for (int adj : graph.getReachable(pos)){
                ltv[pos] = Math.min(ltv[pos], ltv[adj] - graph.getWeightOf(pos, adj));
            }
        }
        System.out.println("ltv " + Arrays.toString(ltv));
        //get ete, lte, critical path
        int index = 0;
        for (int i = 0; i < vNum; i++) {
            for (int j : graph.getReachable(i)) {
                ete[index] = etv[i];
                lte[index] = ltv[j] - graph.getWeightOf(i, j);
                if (ete[index] == lte[index]){
                    ret.add(index);
                }
                index++;
            }
        }
        System.out.println("ete " + Arrays.toString(ete));
        System.out.println("lte " + Arrays.toString(lte));
        return ret;
    }
}
