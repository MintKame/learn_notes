/*
 * @Author: 闫昭
 * @Date: 2020-10-15 13:21:16
 * @LastEditTime: 2020-10-20 20:18:03
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/2_stack/Stack.h
 */
#ifndef STACK_YZ
#define STACK_YZ
#include <iostream>
using Type = char;
class Node
{
private:
    Type data;

public:
    Node *next;
    //getter 函数
    Type getData() const;

    //构造一个新的节点,设置数据并置空后继指针
    Node(Type data_);

    //默认构造一个节点。用于创造头节点
    Node();
};

class Stack
{
private:
    Node *head;
    int size;

public:
    //构造一个空栈，初始化头节点及栈的大小
    Stack();

    //析构栈，删除每一个节点（包含head）
    ~Stack();

    //获取大小
    int getSize() const;

    //新节点入栈
    void push(Node *newNode);
    void push(Type data);

    //栈顶节点出栈(删除)，并返回节点的数据
    Type pop();

    //获取栈顶节点的数据
    Type top() const;
};
#endif