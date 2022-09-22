/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-16 08:50:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/4_graph_traverse/Graph.h
 */
/** Graph.h */

#ifndef GRAPH_YZ
#define GRAPH_YZ
#include <iostream>
#include <vector>
using namespace std;
class Graph {
public:
    int rowSize, colSize; //2方向位置个数
    vector <vector<int>> block;    //是否无法通行 / 一个点确定最短距离后，标记为1
    vector <vector<int>> cost;     //最小距离
    //初始化图，并输入block数组
    Graph(int n, int m);
    //更新图的cost数组
    void minSpanTree();
};
#endif
