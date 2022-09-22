package _8_graph._1_graph_;/*
 * @Author: 闫昭
 * @Date: 2020-11-13- 18:38:00
 * @LastEditors:
 * @Description:
 */

import java.io.*;
import java.util.*;

//adj_matrix
//wighted directed edge (assume all >= 0)
public class Graph_a implements Graph{
    private int vNum, eNum;
    private int[] vData;
    private int[][] eData;
    private boolean[] visited;

    //O(v^2 + v + e)
    public static Graph_a getDirected(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        Graph_a ret = new Graph_a();
        //init
        ret.vNum = input.nextInt();
        ret.vData = new int[ret.vNum];
        ret.eData = new int[ret.vNum][];
        ret.visited = new boolean[ret.vNum];
        for(int i = 0; i < ret.vNum; i++){
            //set v
            ret.vData[i] = input.nextInt();
            //init edges -> infinite(-1) / 0
            ret.eData[i] = new int[ret.vNum];
            for(int j = 0; j < ret.vNum; j++){
                if(i == j)
                    ret.eData[i][j] = 0;
                else
                    ret.eData[i][j] = -1;
            }
        }
        //set e (note: if undirected 2 elem should set)
        //form: from, to, weight
        while (input.hasNext()){
            int from = input.nextInt();
            int to = input.nextInt();
            int weight = input.nextInt();
            System.out.println("from " + from + " to " + to + " weight " + weight);
            if (from != to && ret.eData[from][to] == -1){
                ret.eNum++;
                ret.eData[from][to] = weight;
            }
        }
        return ret;
    }

    public int getvNum(){
        return vNum;
    }

    public int geteNum() {
        return eNum;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.insert(sb.length(), "v:" + vNum +"\te:" + eNum + "\n");
        //v's value
        sb.insert(sb.length(), "vData:\n\t" );
        for (int i = 0; i < vNum; i++) {
            sb.insert(sb.length(), vData[i] + "\t");
        }
        sb.insert(sb.length(), "\n" );
        //v's index
        for (int i = 0; i < vNum; i++) {
            sb.insert(sb.length(), "\t " + i );
        }
        //edge's weight
        for (int j = 0; j < vNum ; j++) {
            sb.insert(sb.length(), "\nv" + j + '\t');
            for (int i = 0; i < vNum; i++) {
                sb.insert(sb.length(),  + eData[j][i] + "\t");
            }
        }
        return sb.toString();
    }

    @Override
    public int getDataOf(int index) {
        return vData[index];
    }

    @Override
    public int getWeightOf(int u, int v) {
        return eData[u][v];
    }

    @Override
    public int getInDegree(int index) {
        int cnt = 0;
        for(int i = 0; i < vNum; i++){
            cnt += eData[i][index] == -1 ? 0 : 1;
        }
        return cnt - 1; //delete self
    }

    @Override
    public int getOutDegree(int index) {
        int cnt = 0;
        for(int i = 0; i < vNum; i++){
            cnt += eData[index][i] == -1 ? 0 : 1;
        }
        return cnt - 1; //delete self
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
        System.out.print(vData[index] + " ");
        //dfs all not-visited adjacent vertex
        for(int i = 0; i < vNum; i++){
            if(eData[index][i] != -1 && !visited[i]){
                dfs0(i);
            }
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
                System.out.print(vData[i] + " ");
                visited[i] = true;
                q.addLast(i);
                while (q.size() != 0) {
                    //visit all adj vertex
                    int index = q.removeFirst();
                    //visit & enqueue all not-visited adjacent vertex
                    for (int j = 0; j < vNum; j++) {
                        if (-1 != eData[index][j] && !visited[j]) {
                            System.out.print(vData[j] + " ");
                            visited[j] = true;
                            q.addLast(j);
                        }
                    }
                }
            }
        }
    }
}