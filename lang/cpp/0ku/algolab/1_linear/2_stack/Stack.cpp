/*
 * @Author: 闫昭
 * @Date: 2020-10-15 13:22:23
 * @LastEditTime: 2020-10-20 20:18:44
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/2_stack/Stack.cpp
 */
#include "Stack.h"
#include <exception>
#include <stdexcept>

using namespace std;
Node::Node()
{
    next = nullptr;
}

Node::Node(Type data_)
{
    data = data_;
    next = nullptr;
}

Type Node::getData() const
{
    return data;
}

Stack::Stack()
{
    //初始化头节点及栈的大小
    head = new Node();
    size = 0;
}
Stack::~Stack()
{
    Node *ptr = head;
    //删除每一个节点（包含head）
    for (int i = 0; i < size; i++)
    {
        Node *tmp = ptr;
        ptr = ptr->next;
        delete tmp;
    }
}

int Stack::getSize() const
{
    return size;
}

void Stack::push(Node *newNode)
{
    newNode->next = head->next;
    head->next = newNode;
    size++;
}

void Stack::push(Type data)
{
    push(new Node(data));
}

Type Stack::pop()
{
    //空栈抛出异常
    if (size == 0)
        throw new logic_error("stack为空，无法pop");
    Node *tmp = head->next;
    Type ret = tmp->getData();
    head->next = tmp->next;
    delete tmp;
    size--;
    return ret;
}
Type Stack::top() const
{
    //空栈抛出异常
    if (size == 0)
        throw new logic_error("stack为空，无法获取栈顶");
    return head->next->getData();
}