/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-06 09:38:14
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/3_huffman/huffman.cpp
 */
/** huffman.cpp */
#include "huffman.h"
#include "link_list.h"
#include <iostream>
#include <string>
#include <vector>
#include <list>
using namespace std;
Tree::Tree(char data, int cnt)
{
    this->data = data;
    this->cnt = cnt;
}
Tree::Tree(int cnt)
{
    this->cnt = cnt;
}

char Tree::getData()
{
    return data;
}

int Tree::compareTo(Tree *t)
{
    return cnt - t->cnt;
}

// 递归求出各字符的哈夫曼编码
string Tree::getCode(string str, char c)
{
    //递归的base：当前节点为leaf，为c则返回位置串， 否则返回空
    if (data != 0)
    {
        if (data == c)
            return str;
        else
            return "";
    }
    //求孩子的串
    string lcode = "";
    string rcode = "";
    if (left != nullptr)
        lcode = left->getCode(str + "0", c);
    if (right != nullptr)
        rcode = right->getCode(str + "1", c);
    //若孩子返回的串非空，则返回该串， 否则返回空
    if (lcode != "")
        return lcode;
    else if (rcode != "")
        return rcode;
    else
        return "";
}

Huffman::Huffman(string str)
{
    cntChar(str);
    createTree();
}

// 统计字符信息中出现的字符种类数和各字符出现的次数（频率）；
void Huffman::cntChar(string str)
{
    for (int i = 0; i < str.size(); i++)
    {
        cnt[str[i]]++;
    }
}

// 根据字符的种类数和各自出现的次数建立哈夫曼树；
void Huffman::createTree()
{
    List list;
    //create nodes
    for (int i = 0; i < 256; i++)
    {
        if (cnt[i] != 0)
        {
            list.insertAtLast(new Tree(i, cnt[i]));
        }
    }
    Tree *parent; //to be the parent of 2 merged node
    //special: 1 char
    if (list.getSize() == 1)
    {
        parent = new Tree();
        parent->left = list.findNodeByIndex(0)->getData();
        parent->right = nullptr;
    }
    //merge 2-min, until the list is empty
    while (list.getSize() >= 2)
    {
        //init the min
        Tree *min1 = list.findDataByIndex(0), *min2 = list.findDataByIndex(1);
        if (min1->compareTo(min2) > 0)
        {
            Tree *tmp = min1;
            min1 = min2;
            min2 = tmp;
        }
        //choose 2 min
        for (int i = 2; i < list.getSize(); i++)
        {
            Tree *tmp = list.findDataByIndex(i);
            if (tmp->compareTo(min2) < 0)
            {
                if (tmp->compareTo(min1) < 0)
                {
                    min2 = min1;
                    min1 = tmp;
                }
                else
                {
                    min2 = tmp;
                }
            }
        }
        //merge them (change the list)
        parent = new Tree(min1->cnt + min2->cnt);
        parent->left = min1;
        parent->right = min2;
        list.deleteByData(min1);
        list.deleteByData(min2);
        list.insertAtLast(parent);
    }
    tree = parent;
}

// 将字符信息转换成对应的编码信息
void Huffman::encode(string str)
{
    for (int i = 0; i < str.size(); i++)
    {
        cout << tree->getCode("", str[i]);
    }
    cout << endl;
}

// 将编码信息还原成发送前的字符信息。
void Huffman::decode(string str)
{
    Tree *node = tree;
    //逐个扫描str, 遇到叶子节点则输出并重置为树的root
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == '0')
            node = node->left;
        else
            node = node->right;
        if (node->data != 0)
        {
            cout << node->data;
            node = tree;
        }
    }
}