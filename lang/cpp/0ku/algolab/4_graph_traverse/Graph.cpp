/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-23 09:08:19
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/4_graph_traverse/Graph.cpp
 */
/** Graph.cpp */

#include <iostream>
#include <vector>
#include "Graph.h"
using namespace std;

Vertex::~Vertex()
{
    while (firstEdge != nullptr)
    {
        Edge *tmp = firstEdge;
        firstEdge = firstEdge->next;
        delete tmp;
    }
}

void Vertex::connect(int index){
    if(isConnectTo(index)){
        return;
    }
    Edge *e = new Edge(index);
    e->next = firstEdge;
    firstEdge = e;
}

int Vertex::isConnectTo(int index)
{
    Edge *edge = firstEdge;
    while (edge != nullptr)
    {
        if (edge->index == index)
        {
            return 1;
        }
        edge = edge->next;
    }
    return 0;
}

Graph::Graph()
{
    cin >> vNum >> eNum;
    visited = new int[vNum];
    vertex = new Vertex[vNum];
    //input edge
    for (int i = 0; i < eNum; i++)
    {
        int x, y;
        cin >> x >> y;
        vertex[x - 1].connect(y - 1);
        vertex[y - 1].connect(x - 1);
    }
}

Graph::~Graph()
{
    delete[] visited;
    delete[] vertex;
}

void Graph::dfs(int start)
{
    cout << endl;
    //初始化visited表
    for (int i = 0; i < vNum; i++)
    {
        visited[i] = 0;
    }
    // 初始化生成树的边集
    treeEdge.clear();
    //递归 dfs
    cout << "dfs：" << endl;
    dfs0(start - 1);
    // 输出边集
    cout << "\n边集： " << endl;
    for (int i = 0; i < treeEdge.size(); i += 2)
    {
        cout << "(" << treeEdge[i] + 1 << ", " << treeEdge[i + 1] + 1 << ")" << endl;
    }
}

void Graph::dfs0(int index)
{
    //访问当前vertex
    cout << index + 1 << " ";
    visited[index] = 1;
    //递归dfs每个未访问的邻接点
    Edge *edge = vertex[index].firstEdge;
    while (edge != nullptr)
    {
        if (visited[edge->index] == 0)
        {
            treeEdge.push_back(index);
            treeEdge.push_back(edge->index);
            dfs0(edge->index);
        }
        edge = edge->next;
    }
}

void Graph::bfs(int start)
{
    cout << endl;
    cout << "bfs：" << endl;
    //初始化visited表
    for (int i = 0; i < vNum; i++)
    {
        visited[i] = 0;
    }
    // 初始化生成树的边集
    treeEdge.clear();
    // 创建queue,存访问的vertex
    vector<int> queue;
    // 访问第一个节点
    cout << start << " ";
    start--;
    visited[start] = 1;
    queue.push_back(start);
    // 访问queue的队首的邻接点
    while (0 != queue.size())
    {
        int index = queue[0];
        queue.erase(queue.begin());
        Edge *edge = vertex[index].firstEdge;
        while (edge != nullptr)
        {
            if (!visited[edge->index])
            {
                cout << edge->index + 1 << " ";
                visited[edge->index] = 1;
                treeEdge.push_back(index);
                treeEdge.push_back(edge->index);
                queue.push_back(edge->index);
            }
            edge = edge->next;
        }
    }
    // 输出边集
    cout << "\n边集： " << endl;
    for (int i = 0; i < treeEdge.size(); i += 2)
    {
        cout << "(" << treeEdge[i] + 1 << ", " << treeEdge[i + 1] + 1 << ")" << endl;
    }
}

void Graph::print()
{
    cout << endl;
    for (int i = 0; i < vNum; i++)
    {
        cout << "v" << i + 1 << "  ";
        for (int j = 0; j < vNum; j++)
        {
            cout << vertex[i].isConnectTo(j) << " ";
        }
        cout << endl;
    }
    cout << endl;
}