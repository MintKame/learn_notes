package tmp;/*
 * @Author: 闫昭
 * @Date: 2020-11-20- 19:24:00
 * @LastEditors:
 * @Description:
 */


//A min span
//B top
//C shortest path
//D shortest path
import java.util.Arrays;
import java.util.Scanner;

public class _5 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int vNum = input.nextInt();
        //        The line starts with the number of contacts (n)
        while (vNum != 0){  //each set ->  terminated 0
            int [][] graph = new int[vNum][vNum];
            for (int i = 0; i < vNum; i++) {    //each vertex
//        for each contact. lists first a number of the contact, followed time to pass a message to that person.
                int cnt = input.nextInt();
                graph[i] = new int[vNum];
                Arrays.fill(graph[i], -1);
                graph[i][i] = 0;
                for (int j = 0; j < cnt; j++) { //each connect(directed)
                    int to = input.nextInt();
                    int weight = input.nextInt();
                    graph[i][to - 1] = weight;
                }
            }
            for (int k = 0; k < vNum; k++) {
                for (int i = 0; i < vNum; i++) {
                    for (int j = 0; j < vNum; j++) {
                        if (graph[k][j] != -1 && graph[i][k] != -1){
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
//        which stockbroker to choose as your starting point,
//        and how long last person receive
            int choose = 0, maxTime = Integer.MAX_VALUE ;
            boolean canFind = false;
            for (int i = 0; i < vNum; i++) {
                int tmp = 0;
                boolean disjoint = false;
                for (int j = 0; j < vNum ; j++) {
                    if (graph[i][j] == -1){
//       some people may be unreachable. output "disjoint".
                        disjoint = true;
                        break;
                    }
                    tmp = Math.max(graph[i][j], tmp);
                }
                if (disjoint){
                    continue;
                }else {
                    canFind = true;
                    if (tmp < maxTime){
                        maxTime = tmp;
                        choose = i;
                    }
                }
            }
            if (!canFind)
            System.out.println("disjoint");
            else {
                System.out.println(choose + 1 + " " + maxTime);
            }
            vNum = input.nextInt();
        }
    }
}
/*


        the number of stockbrokers
3
2 2 4 3 5
2 1 2 3 6
2 1 2 2 2
5
3 4 4 2 8 5 3
1 5 8
4 1 6 4 10 2 7 5 2
0
2 2 5 1 5
0
        Sample Output
        3 2
        3 10
*/