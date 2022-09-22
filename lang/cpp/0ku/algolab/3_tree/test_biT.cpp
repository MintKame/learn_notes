/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-05 19:20:10
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /algolab/3_tree/test_biT.cpp
 */
/* test_biT.cpp: 测试*/
#include <iostream>
#include "biT.h"
using namespace std;
int main()
{
  //从键盘接受输入（先序）建立二叉树
  Tree *t = init();
  //遍历（先序、中序、后序），将遍历结果打印输出。
  cout << "inorder: ";
  inorder(t);
  cout << "\npreorder: ";
  preorder(t);
  cout << "\npostorder: ";
  postorder(t);
  cout << endl;
  return 0;
}