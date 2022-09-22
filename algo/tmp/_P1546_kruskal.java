package tmp;/*
 * @Author: 闫昭
 * @Date: 2020-11-20- 19:24:00
 * @LastEditors:
 * @Description:
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
//A min span
//B top
//C shortest path
//D shortest path
public class _P1546_kruskal {
    public static void main(String[] args) {

        new Graph5().Kruskal();
    }
}

class Graph5{
    static class Edge{
        int from;
        int to;
        int wight;
        Edge(int from, int to, int wight){
            this.from = from;
            this.to = to;
            this.wight = wight;
        }
    }

    private int vNum;
    private int[][] eData;
    Graph5(){
        //input
        Scanner input = new Scanner(System.in);
        vNum = input.nextInt();
        eData = new int[vNum][vNum];
        for (int i = 0; i < vNum; i++) {
            eData[i] = new int[vNum];
            for (int j = 0; j < vNum; j++) {
                eData[i][j] = input.nextInt();
            }
        }
    }


    int Kruskal(){
        int cost = 0;
        PriorityQueue<Edge> remain = new PriorityQueue(vNum, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return  o1.wight - o2.wight;
            }
        });
        UF union = new UF(vNum);
        for (int i = 0; i < vNum; i++) {
            for (int j = i + 1; j < vNum; j++) {
                remain.add(new Edge(i , j, eData[i][j]));
            }
        }
        int cnt = 0;
        while (cnt < vNum - 1){
            Edge e = remain.remove();
            if(!union.isConnected(e.from, e.to)){
                union.union(e.from, e.to);
                cnt++;
                cost += e.wight;
            }
        }
        System.out.print(cost);
        return cost;
    }

}

class UF{
    private int []arr;
    private int size;
    private int []cnt;  //*store the node's child's size
    public UF(int size)                      //O(n)
    {
        this.size = size;
        arr = new int[size];
        cnt = new int [size]; //*
        for(int i = 0; i < size; i++)
        {
            arr[i] = i;
        }
    }

    // return the p's root's index
    private int root(int p) //!
    {
        while(p != arr[p])
        {
            arr[p] = arr[arr[p]]; //* make the height shorter
            p = arr[p];
        }
        return p;
    }

    public void union(int p, int q)
    {
//old:  arr[root(p)] = root(q);
        //problem: make the tree shorter
        //blow are new
        int root_p = root(p);
        int root_q = root(q);
        if(root_p == root_q)
        {
            return;
        }// take node which has smaller descend-size
        else if(cnt[root_p] > cnt[root_q])
        {
            arr[root_q] = root_p;
            //* update cnt
            cnt[root_p] += cnt[root_q];
        }
        else
        {
            arr[root_p] = root_q;
            cnt[root_q] += cnt[root_p];
        }
    }

    public boolean isConnected(int p, int q)  //!
    {
        return (boolean)(root(p) == root(q));
    }

}