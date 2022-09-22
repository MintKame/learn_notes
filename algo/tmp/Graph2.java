package tmp;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
//A min span
//B top
//C shortest path
//D shortest path
/*
只知道每场比赛的结果，即P1赢P2，用P1，P2表示，排名时P1在P2之前.  编号小的队伍在前
        4 3
        1 2
        2 3
        4 3
        1 2 4 3
 */
public class Graph2 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        new Graph2().top();
    }
    int vNum = 0;
    int[][] weight;
    Graph2(){
        vNum = input.nextInt();
        weight = new int[vNum][vNum];
        int eNum = input.nextInt();
        for (int i = 0; i < vNum; i++) {
            Arrays.fill(weight[vNum - 1], 0);
        }
        for (int i = 0; i < eNum; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            weight[from - 1][to - 1] = 1;
        }
    }
    void top(){
        int[] ind = new int[vNum];
        Arrays.fill(ind, 0);
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                ind[j] += weight[i][j];
            }
        }
        for (int i = 0; i < vNum; i++) {
            int ind0 = -1;
            for (int j = 0; j < vNum && ind0 == -1; j++) {
                if (ind[j] == 0){
                    System.out.print(j + 1 + " ");
                    ind[j] = -1;
                    ind0 = j;
                }
            }
            if (ind0 != -1){
                for (int j = 0; j < vNum; j++) {
                    if (weight[ind0][j] == 1)
                        ind[j]--;
                }
            }
        }
    }
}

