#include "joeph.h"
#include <iostream>
using namespace std;
Node::Node(int id, int passwd)
{
    next = nullptr;
    person.id = id;
    person.passwd = passwd;
}

List::List()
{
    size = 0;
    last = nullptr;
    first = nullptr;
}

List::~List()
{
    while (size > 0)
    {
        Node *tmp = first;
        first = first->next;
        delete tmp;
        size--;
    }
}

void List::insert(int id, int passwd)
{
    //根据参数构造新节点
    Node *newNode = new Node(id, passwd);
    //单独考虑list为空
    if (size == 0)
    {
        newNode->next = newNode;
        first = newNode;
        last = newNode;
    }
    else
    {
        newNode->next = first;
        last->next = newNode;
        last = newNode;
    }
    size++;
}

int *List::deleteNext()
{
    //list为空或未设置prior
    if (size == 0 || prior == nullptr)
        return new int[2]{-1, -1};

    else
    {
        Node *tmp = prior->next; //要delete的节点
        int id = tmp->person.id;
        int passwd = tmp->person.passwd;
        //只有一个节点时
        if (size == 1)
        {
            delete tmp;
            prior = nullptr;
            first = nullptr;
            last = nullptr;
        }
        //其他情况下：
        else
        {
            prior->next = tmp->next;
            //当被删节点为last或first，更新list的指针域
            if (tmp == last)
            {
                last = prior;
            }
            if (tmp == first)
            {
                first = tmp->next;
            }
            delete tmp;
        }
        size--;
        return new int[2]{id, passwd};
    }
}

void List::count(int times)
{
    times = (times - 1) % size; // %size 可以提高效率
    for (int i = 0; i < times; i++)
    {
        prior = prior->next;
    }
}