/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-05 19:14:01
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /algolab/3_tree/biT.h
 */

/*biT.h: 二叉树3种遍历*/
#ifndef BIT_YZ
#define BIT_YZ
#include <iostream>
#include <string>
using namespace std;
class Tree
{

private:
    char data;

public:
    Tree *l = nullptr;
    Tree *r = nullptr;
    Tree(int data);
    char getData() { return data; }
};
//以前序的方式，生成一颗二叉树
Tree *init();
//采用递归算法对其进行遍历（先序、中序、后序）,结果打印输出。
//中序遍历
void inorder(Tree *node);
//先序遍历
void preorder(Tree *node);
//后序遍历
void postorder(Tree *node);
#endif