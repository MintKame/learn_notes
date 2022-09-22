/*
 * @Author: 闫昭
 * @Date: 2020-10-10 17:00:15
 * @LastEditTime: 2020-10-11 09:01:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/2_joeph/joeph.h
 */
#ifndef JOEPH
#define JOEPH
#include <iostream>

class Person
{
public:
    int id;
    int passwd;
};

class Node
{
public:
    Node *next;
    Person person;
    //构造节点，next设置为nullptr
    Node(int id, int passwd);
};

class List
{
public:
    Node *first;
    Node *last;
    Node *prior = nullptr; //当前报数者的前驱
    int size;
    //构造链表，size设置为0,2个指针置为nullptr。
    List();
    ~List();
    void setPrior(Node *prior_) { prior = prior_; }
    //加人到表尾。先构造节点。加入并更新List数据。
    void insert(int id, int passwd);
    /**
     * @description: 析构prior的next节点。更新List数据。
     *               若只一人则删自身。并更新指针。
     * @return {int[]} 被删节点的人的 id和passwd.若空list或未设置prior，返回-1
     */
    int *deleteNext();
    //prior向后移动times次
    void count(int times);
};
#endif