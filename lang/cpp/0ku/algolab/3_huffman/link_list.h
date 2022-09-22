/*
 * @Author: 闫昭
 * @Date: 2020-09-30 09:06:59
 * @LastEditTime: 2020-11-05 20:34:09
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\algolab\3_huffman\link_list.h
 */
#include <iostream>
#include "huffman.h"
using Type = Tree *;
class Node
{
private:
    Type data;
    Node *next;

public:
    Node(){};
    Node(Type data_)
    {
        data = data_;
    }
    Type getData() { return data; }
    Node *getNextPtr() { return next; }
    void setNextPtr(Node *next_) { next = next_; }
};

//have head node
class List
{
private:
    Node *head;
    int size;

public:
    List();  //make a head node
    ~List(); //delete all node
    bool isEmypty() { return size == 0; }
    int getSize() { return size; }
    void clearAll();
    Type findDataByIndex(int index_);
    Node *findNodeByIndex(int index_);
    int findFirstIndexByData(Type data_);
    void insertByIndex(Node *ptr_newNode, int index_);
    void insertAtLast(Type data);
    Type deleteByIndex(int index_); //return data
    int deleteByData(Type data_);   //return index
};