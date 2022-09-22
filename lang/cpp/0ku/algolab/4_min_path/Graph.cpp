/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-16 08:50:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/4_graph_traverse/Graph.cpp
 */
/** Graph.cpp */

#include <iostream>
#include <vector>
#include "Graph.h"
using namespace std;

Graph::Graph(int n, int m){
    rowSize = n, colSize = m;
    //初始化两个数组
    for(int j = 0; j < rowSize; j++){
        vector<int> b;
        vector<int> c;
        for(int i = 0; i < colSize; i++){
            int tmp;
            cin >> tmp;
            //交通状况
            b.push_back(tmp);
            //最短距离初始化为极大
            c.push_back(65535);
        }
        block.push_back(b);
        cost.push_back(c);
    }
}

void Graph::minSpanTree(){
    int r = 0, c = 0;   //初始位置为（0，0）
    cost[0][0] = 0;
    int allBlock = false;  //标记所有节点都已经访问完成
    while (!allBlock){
        block[r][c] = 1;
        // 更新周围的点cost
        // 横着走会消耗2点时间
        if( c - 1 >= 0 && !block[r][c - 1] ){
            cost[r][c - 1] =  min(cost[r][c - 1], cost[r][c] + 2);
        }
        if( c + 1 < colSize && !block[r][c + 1] ){
            cost[r][c + 1] =  min(cost[r][c + 1], cost[r][c] + 2);
        }
        // 向下消耗1点时间。
        if( r - 1 >= 0 && !block[r - 1][c] ){
            cost[r - 1][c] =  min(cost[r - 1][c], cost[r][c] + 3);
        }
        // 向上会消耗3点时间
        if( r + 1 < rowSize && !block[r + 1][c] ){
            cost[r + 1][c] =  min(cost[r + 1][c], cost[r][c] + 1);
        }
        // 找到下一访问位置（最近）
        int minCost = 65535;
        allBlock = true;
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (!block[i][j] && cost[i][j] < minCost){
                    allBlock = false;
                    minCost = cost[i][j];
                    r = i;
                    c = j;
                }
            }
        }
    }
}