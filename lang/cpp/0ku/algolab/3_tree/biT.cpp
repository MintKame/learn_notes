/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-05 19:17:33
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /algolab/3_tree/biT.cpp
 */

/*biT.cpp: 函数实现*/
#include "biT.h"
#include <iostream>
using namespace std;

Tree::Tree(int data)
{
    this->data = data;
}

//以前序的方式，生成一颗二叉树
Tree *init()
{
    Tree *ret;
    char in;
    cin >> in;
    //判断是否为空指针
    if (in != '#')
    {
        ret = new Tree(in);
        ret->l = init();
        ret->r = init();
    }
    else
    {
        ret = nullptr;
    }
    return ret;
}

void inorder(Tree *node)
{
    if (node != nullptr)
    {
        inorder(node->l);
        cout << node->getData();
        inorder(node->r);
    }
}
//先序遍历
void preorder(Tree *node)
{
    if (node != nullptr)
    {
        cout << node->getData();
        preorder(node->l);
        preorder(node->r);
    }
}
//后序遍历
void postorder(Tree *node)
{
    if (node != nullptr)
    {
        postorder(node->l);
        postorder(node->r);
        cout << node->getData();
    }
}