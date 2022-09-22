package _8_graph._1_graph_;/*
 * @Author: 闫昭
 * @Date: 2020-11-13- 19:41:00
 * @LastEditors:
 * @Description:
 */

import _8_graph._4_topological_sort.CriticalPath;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph_l implements Graph{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("graph_d.txt");
        Graph_l graph_l = Graph_l.getDirected(file);
        System.out.println(graph_l);
        System.out.println(graph_l.getReachable(1));
        System.out.println(CriticalPath.criticalPath_l(graph_l)); //linked
    }
    static class Edge{
        Edge next;
        int vIndex;
        int weight;
        Edge(int l, int w){
            vIndex = l;
            weight = w;
        }
    }
    static class Vertex{
        int data;
        Edge firstEdge;
        Vertex(int d){
            data = d;
        }

        //only for diff vertex (same vertex can't use)
        int weightFrom(int vIndex){
            Edge edge = firstEdge;
            while (edge != null){   //tran all edge
                if(vIndex == edge.vIndex)
                    return edge.weight;
                edge = edge.next;
            }
            //not link
            return -1;
        }
        //insert at head
        void link(int linkVertex, int weight){
            Edge e = new Edge(linkVertex, weight);
            e.next = firstEdge;
            firstEdge = e;
        }
    }

    private int vNum, eNum;
    private Vertex[] vertex;
    private boolean[] visited;

    public int getvNum() {
        return vNum;
    }

    public int geteNum() {
        return eNum;
    }

    public LinkedList<Integer> getReachable(int vIndex){
        Edge edge = vertex[vIndex].firstEdge;
        LinkedList<Integer> ret = new LinkedList<Integer>();
        while (edge != null){
            ret.push(edge.vIndex);
            edge = edge.next;
        }
        ret.sort(null);
        return ret;
    }

    //O(v + e)
    public static Graph_l getDirected(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        Graph_l ret = new Graph_l();
        //init
        ret.vNum = input.nextInt();
        ret.vertex = new Vertex[ret.vNum];
        ret.visited = new boolean[ret.vNum];
        for(int i = 0; i < ret.vNum; i++){
            //set v (with data)
            ret.vertex[i] = new Vertex(input.nextInt());
        }
        //set e (note: if undirected 2 elem should set)
        //form: from, to, weight
        while (input.hasNext()){
            int from = input.nextInt();
            int to = input.nextInt();
            int weight = input.nextInt();
            if (from != to && ret.vertex[from].weightFrom(to) == -1){
                ret.eNum++;
                ret.vertex[from].link(to, weight); //insert adjacent vertex
            }
        }
        return ret;
    }
        @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.insert(sb.length(), "v:" + vNum +"\te:" + eNum + "\n");
        //v's value
        sb.insert(sb.length(), "vData:\n\t" );
        for (int i = 0; i < vNum; i++) {
            sb.insert(sb.length(), vertex[i].data + "\t");
        }
        sb.insert(sb.length(), "\n\t" );
        //v's index
        for (int i = 0; i < vNum; i++) {
            sb.insert(sb.length(), " " + i + "\t");
        }
        //edge's weight
        for (int i = 0; i < vNum; i++) {
            sb.insert(sb.length(),"\nv" + i + '\t');
                for (int j = 0; j < vNum ; j++) {
                    if(j != i)
                        sb.insert(sb.length(), vertex[i].weightFrom(j) + "\t");
                    else
                        sb.insert(sb.length(), "0\t");
                }
        }
        return sb.toString();
    }
    @Override
    public int getDataOf(int index) {
        return vertex[index].data;
    }

    @Override
    public int getWeightOf(int u, int v) {
        return vertex[u].weightFrom(v);
    }

    @Override
    public int getInDegree(int index) {
        int cnt = 0;
        for (int i = 0; i < vNum; i++) {    // O(n^2)
            cnt += vertex[i].weightFrom(index) == -1 ? 0 : 1;
        }
        return cnt;
    }

    @Override
    public int getOutDegree(int index) {
        int cnt = 0;
        for (int i = 0; i < vNum; i++) {    // O(n^2) can n
            cnt += vertex[index].weightFrom(i) == -1 ? 0 : 1;
        }
        return cnt;
    }

    @Override
    public void dfs() {
        //clear the arr
        Arrays.fill(visited, false);
        //dfs all connected component
        for (int i = 0; i < vNum; i++) {
            if (visited[i] == false){
                dfs0(i);
            }
        }
    }
    private void dfs0(int index){
        //visit this vertex
        visited[index] = true;
        System.out.print(vertex[index].data + " ");
        //dfs all not-visited adjacent vertex
        Edge edge = vertex[index].firstEdge;
        while (edge != null){
            if(!visited[edge.vIndex] ){
                dfs0(edge.vIndex);
            }
            edge = edge.next;
        }
    }

    @Override
    public void bfs() {
        //clear the arr
        Arrays.fill(visited, false);
        //init a queue
        LinkedList<Integer> q = new LinkedList<Integer>();  //record already visited vertex (to add their adjacent vertex)
        for (int i = 0; i < vNum; i++) {
            //visit all connected component
            if (!visited[i]) {
                //visit & enqueue 1st vertex of this connected component
                System.out.print(vertex[i].data + " ");
                visited[i] = true;
                q.addLast(i);
                while (q.size() != 0) {
                    //visit all adj vertex
                    int index = q.removeFirst();
                    //visit & enqueue all not-visited adjacent vertex
                    Edge edge = vertex[i].firstEdge;
                    while (null != edge){
                        if(!visited[edge.vIndex]){
                            System.out.print(vertex[edge.vIndex].data + " ");
                            visited[edge.vIndex] = true;
                            q.addLast(edge.vIndex);
                        }
                        edge = edge.next;

                    }
                }
            }
        }
    }
}

