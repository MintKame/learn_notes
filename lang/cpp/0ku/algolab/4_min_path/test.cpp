/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-26 09:35:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/4_min_path/test.MinPath.cpp
 */

/** test.cpp */
#include <iostream>
#include <vector>
#include "Graph.h"
using namespace std;
int main(){
    // 行数，列数，剩余时间
    int m, n, remain;
    cin >> n >> m >> remain;
    Graph graph = Graph(n, m);
    graph.minSpanTree();    //更新图的cost数组
    //输出能否在仅剩的时间内到达配送点。
    //配送地点为（0，m - 1）
    cout << ( graph.cost[0][m - 1] <= remain ? "can" : "can't") << endl;
    return 0;
}
/*
4 5 16
0 1 0 0 0
0 0 0 0 1
1 0 0 0 0
0 0 1 1 0
0       65535   8       10      12
1       3       5       7       65535
65535   4       6       8       10
7       5       65535   65535   11
 * */