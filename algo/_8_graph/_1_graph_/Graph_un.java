package _8_graph._1_graph_;/*
 * @Author: 闫昭
 * @Date: 2020-11-21- 21:06:00
 * @LastEditors:
 * @Description:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph_un {
    private int vNum, eNum;
    private int[] vData;
    private int[][] eData;
    private boolean[] visited;

    public static Graph_un getUnDirected(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        Graph_un ret = new Graph_un();
        //init
        ret.vNum = input.nextInt();
        ret.vData = new int[ret.vNum];
        ret.eData = new int[ret.vNum][];
        ret.visited = new boolean[ret.vNum];
        for(int i = 0; i < ret.vNum; i++){
            //set v
            ret.vData[i] = input.nextInt();
            //init edges -> infinite / 0
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
             if (from != to && ret.eData[from][to] == -1) {
                 ret.eNum++;
                 ret.eData[from][to] = ret.eData[to][from] = weight;
            }
        }
        return ret;
    }

    public int geteNum() {
        return eNum;
    }

    public int getvNum() {
        return vNum;
    }

    public int getWightOf(int from, int to){
        return eData[from][to];
    }

    public LinkedList<Integer> getReachable(int vIndex){
        LinkedList<Integer> ret = new LinkedList<Integer>();
        for (int i = 0; i < vNum; i++){
            if (eData[vIndex][i] > 0)
                ret.add(i);
        }
        return ret;
    }

    public int getDegree(int index){
        int ret = 0;
        for (int i = 0; i < vNum; i++) {
            ret += eData[index][i];
        }
        return ret;
    }

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
}
