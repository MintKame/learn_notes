/*
 * @Author: 闫昭
 * @Date: 2020-09-30 09:24:17
 * @LastEditTime: 2020-10-10 15:42:45
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/1_1_city/city.cpp
 */
#include "city.h"
#include <iostream>
#include <exception>
#include <string>
#include <cmath>
using namespace std;

string Position::toString() const
{
    return "( " + to_string(x) + ", " + to_string(y) + " )";
}

City::City(const City &city)
{
    name = city.name;
    position = Position(city.position.x, city.position.y);
}

double City::distanceFrom(double x, double y) const
{
    return sqrt((position.x - x) * (position.x - x) + (position.y - y) * (position.y - y));
}

string City::toString() const
{
    return name + " at " + position.toString();
}

Node::Node(const City &city_)
{
    city = City(city_);
}

List::List()
{
    head_ptr = new Node();
    tail_ptr = head_ptr;
}

List::~List()
{
    //删除包括头节点
    Node *ptr = head_ptr;
    while (ptr != nullptr)
    {
        Node *tmp = ptr;
        ptr = ptr->next_ptr;
        delete tmp;
    }
}

void List::insert(const City &city)
{
    //构造节点
    Node *node = new Node(City(city)); //深拷贝city
    node->next_ptr = nullptr;
    //更新数据
    size++;
    tail_ptr->next_ptr = node;
    tail_ptr = node;
}

void List::insert(double x, double y, const string &name)
{
    //构造节点
    Node *node = new Node(City(x, y, name));
    node->next_ptr = nullptr;
    //更新数据
    size++;
    tail_ptr->next_ptr = node;
    tail_ptr = node;
}

Node *List::priorOf(const string &name) const
{
    //遍历list，对比name
    Node *ptr = head_ptr;
    for (; ptr->next_ptr != nullptr; ptr = ptr->next_ptr)
    {
        if (ptr->next_ptr->city.name == name)
            break;
    }
    //循环因找到而结束
    if (ptr->next_ptr)
        return ptr;
    //循环因到达表尾而结束
    else
        return nullptr;
}

int List::deleteByName(const string &name)
{
    //找到前驱的指针
    Node *prior = priorOf(name);
    //若为空，则不存在寻找的城市；则找到，删除节点。
    if (prior != nullptr)
    {
        Node *tmp = prior->next_ptr;
        //若为最后一个，需要更新tail_ptr
        if (tmp == tail_ptr)
        {
            tail_ptr = prior;
        }
        prior->next_ptr = tmp->next_ptr;
        delete tmp;
        size--;
        return 0;
    }
    else
    {
        return -1;
    }
}
Position *List::positionOf(const string &name) const
{
    Position *ret = nullptr;
    //找到前一个节点
    Node *prior = priorOf(name);
    //找到则返回位置指针，否则nullptr
    if (prior)
    {
        ret = &(prior->next_ptr->city.position);
    }
    return ret;
}

List *List::distanceToPositionLessEqual(double x, double y, double distance)
{
    List *ret = nullptr;
    //非法输入， 返回nullptr
    if (distance < 0)
        return ret;
    //合法输入
    else
    {
        ret = new List();
        Node *ptr = head_ptr -> next_ptr;
        //遍历节点，符合的城市加入ret所指的List
        for(int i = 0; i < size; i++, ptr = ptr -> next_ptr)
        {
            double tmp = ptr->city.distanceFrom(x, y);
            if (tmp < distance || fabs(tmp - distance) < 1e-6)
            {
                ret->insert(City(ptr->city));
            }
        }
        return ret;
    }
}

void List::show() const
{
    Node *ptr = head_ptr->next_ptr;
    //根据城市size，输出不同语句
    switch (size)
    {
    case 0:
        cout << "There is 0 city" << endl;
        break;
    case 1:
        cout << "There is 1 city:" << endl;
        break;
    default:
        cout << "There are " << size << " cities." << endl;
        break;
    }
    //输出每一个城市信息
    while (ptr != nullptr)
    {
        cout << ptr->city.toString() << endl;
        ptr = ptr->next_ptr;
    }
    cout << endl;
}