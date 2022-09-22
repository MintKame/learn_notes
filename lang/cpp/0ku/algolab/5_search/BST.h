/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-30 15:54:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/5_search/BST.h
 */
/** BST.h */
#ifndef BST_YZ
#define BST_YZ
#include <iostream>
using namespace std;

class BST
{
public:
    BST *left, *right;
    int val;

    BST(int val);
    // 查: 找到则返回长度（比较次数），否则返回-1
    static int search(BST *root, int target);
    static BST *getParent(BST *root, int target);
    // 插入一个值
    static void insert(BST *root, int newVal);
    // 删除一个值
    static void remove(BST *root, int toDel);
    // 中序遍历
    static void inOrder(BST *root);
};

#endif