package _8_graph._1_graph_;/*
 * @Author: 闫昭
 * @Date: 2020-11-13- 20:52:00
 * @LastEditors:
 * @Description:
 */

interface Graph{
    /** Return the value for the specified vertex index */
    public int getDataOf(int index);

    /** Return the weight for the specified edge */
    public int getWeightOf(int u, int v);

    /** Return the in-degree for a specified vertex */
    public int getInDegree(int index);

    /** Return the out-degree for a specified vertex */
    public int getOutDegree(int index);

    /** depth-first search the graph */
    void dfs();

    /** bread-first search the graph */
    void bfs();

    /** Obtain a depth-first search tree */
//    public AbstractGraph<V>.Tree dfs(int v);
//
//    /** Obtain a breadth-first search tree */
//    public AbstractGraph<V>.Tree bfs(int v);
}
