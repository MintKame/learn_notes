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
#include <vector>
using namespace std;
class Edge
{
public:
    int index;
    Edge *next;
    Edge(int index_) { index = index_; }
};
class Vertex
{
public:
    Edge *firstEdge;
    ~Vertex();
    // 连接一个点
    void connect(int index);
    // 判断与index是否相连
    int isConnectTo(int index);
};

/** 邻接表存储 */
class Graph
{
public:
    int vNum, eNum;       //点和边的个数
    Vertex *vertex;       //点数组
    int *visited;         //遍历时用于记录
    vector<int> treeEdge; //遍历时记录生成树的边
    Graph();
    ~Graph();
    /** 从start开始dfs, 输出结点访问序列 和 相应生成树的边集 */
    void dfs(int start);
    /** 递归dfs */
    void dfs0(int index);
    /** 从start开始bfs, 输出结点访问序列 和 相应生成树的边集 */
    void bfs(int start);
    void print();
};
#endif
