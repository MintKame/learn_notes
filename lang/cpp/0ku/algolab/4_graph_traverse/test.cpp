/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-15 21:33:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/4_graph_traverse/test.cpp
 */

/** test.cpp */

#include <iostream>
#include "Graph.h"
using namespace std;
int main()
{
    //邻接表存储连通无向图
    Graph graph;
    //深度优先和广度优先遍历。
    // 注意编号从1开始
    graph.dfs(1);
    graph.bfs(1);
}