/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-30 16:08:56
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/5_search/test.cpp
 */
/** test.cpp */
#include <iostream>
#include "BST.h"
int main()
{
    int arr[] = {9, 6, 2, 7, 1, 3, 5, 4};
    BST *t = new BST(arr[0]);
    //insert
    for (int i = 1; i <= 7; i++)
    {
        BST::insert(t, arr[i]);
    }
    //traverse
    BST::inOrder(t);
    cout << endl;
    //remove
    BST::remove(t, 6);
    //traverse
    BST::inOrder(t);
    cout << endl;
    //search
    cout << BST::search(t, 9) << ' ';
    cout << BST::search(t, 6) << ' ';
    cout << BST::search(t, 4) << '\n';
}