package tmp;/*
 * @Author: 闫昭
 * @Date: 2020-11-20- 19:24:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;
import java.util.Scanner;

//A min span
//B top
//C shortest path
//D shortest path
public class _4 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            int v = input.nextInt();
            G3 graph = new G3();
            graph.min_path();
            graph.getFar();
    }
    static class G3{
        int vNum ;
        int[][] weight = new int[10005][10005];
        G3(){
            while (input.hasNext()){
                int f = input.nextInt();
                int t = input.nextInt();
                int w = input.nextInt();
                vNum = Math.max(t, Math.max(f, vNum));
                weight[f - 1][t - 1] = w;
            }

        }
        void min_path(){

        }

        int getFar(){
            return 0;
        }
    }
}
/*
find (two most) remote villages
        <= 10,000 villages， numbered from 1.
        Input a sequence of lines (undirect)
         the number,  length of road segment connecting

        Output
        2 single integer:
        distance between the two most remote villages.
        5 1 6
        1 4 5
        6 3 9
        2 6 8
        6 1 7
        22
 */