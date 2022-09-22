/*
 * @Author: 闫昭
 * @Date: 2020-09-30 09:24:17
 * @LastEditTime: 2020-11-05 20:34:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\algolab\3_huffman\link_list.cpp
 */
#include "link_list.h"
#include <iostream>
#include <exception>
using namespace std;
List::List()
{
    size = 0;
    head = new Node(); //o should change base on Type
}
List::~List()
{
    clearAll();
}
void List::clearAll()
{
    size = 0;
    Node *ptr_node = head;
    while (ptr_node != nullptr)
    {
        Node *tmp = ptr_node;
        ptr_node = ptr_node->getNextPtr();
        delete tmp;
    }
}
Node *List::findNodeByIndex(int index_)
{
    Node *ptr_node = head;
    for (int i = -1; i < index_; i++) //can use to insert
    {
        ptr_node = ptr_node->getNextPtr();
    }
    return ptr_node;
}
Type List::findDataByIndex(int index_) { return findNodeByIndex(index_)->getData(); }
int List::findFirstIndexByData(Type data_)
{
    Node *ptr_node = head->getNextPtr();
    int index_ = 0;
    while (data_->data != ptr_node->getData()->data)
    {
        ptr_node = ptr_node->getNextPtr();
        index_++;
    }
    return index_;
}
void List::insertByIndex(Node *ptr_newNode, int index_)
{
    size++;
    Node *ptr_prior = findNodeByIndex(index_ - 1);
    ptr_newNode->setNextPtr(ptr_prior->getNextPtr());
    ptr_prior->setNextPtr(ptr_newNode);
}
void List::insertAtLast(Type data)
{
    Node *ptr_newNode = new Node(data);
    insertByIndex(ptr_newNode, size); //already increase
}
Type List::deleteByIndex(int index_)
{
    size--;
    Node *ptr_prior = findNodeByIndex(index_ - 1);
    Node *ptr_tmp = ptr_prior->getNextPtr();
    ptr_prior->setNextPtr(ptr_tmp->getNextPtr());
    Type ret = ptr_tmp->getData();
    delete ptr_tmp;
    return ret;
}
int List::deleteByData(Type data_)
{
    int index_ = findFirstIndexByData(data_);
    deleteByIndex(index_); //already decrease
    return index_;
}