/*
 * @Author: 闫昭
 * @Date: 2020-09-30 09:06:59
 * @LastEditTime: 2020-10-10 15:43:20
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/1_1_city/city.h
 */
#ifndef CITY
#define CITY
#include <iostream>
#include <string>
using namespace std;

class Position
{
public:
    double x = 0;
    double y = 0;
    Position() = default;
    Position(double x_, double y_)
    {
        x = x_;
        y = y_;
    }
    string toString() const;
};

class City
{
public:
    Position position;
    string name = "unset";
    City(){};
    City(double x_, double y_, const string &name_)
    {
        position = Position(x_, y_);
        name = name_;
    }
    //拷贝构造：深拷贝
    City(const City &city);
    double distanceFrom(double x_, double y_) const;
    void setX(double x) { position.x = x; }
    void setY(double y) { position.y = y; }
    //以 “城市名 at （ x坐标，y坐标 ）” 形式返回城市信息
    string toString() const;
};

class Node
{
public:
    City city;
    Node *next_ptr = nullptr;
    Node() = default;
    Node(const City &city_);
};

class List
{
public:
    Node *head_ptr; //头指针指向头节点
    Node *tail_ptr;
    int size = 0;
    //构造list，初始化一个头节点,设置两个Node指针
    List();

    //析构list，删除所有节点
    ~List();

    //加入一个城市到List最后
    void insert(double x, double y, const string &name);
    void insert(const City &city); //深拷贝city，而不是复制引用

    //根据名字找到前一个节点
    Node *priorOf(const string &name) const;

    //删除第一个找到的名为name_的节点，int为0成功，为-1未找到
    int deleteByName(const string &name);

    /**
    * @description: 根据城市名name，从List中找到城市。
    * @param {string} name 被查的城市名。
    * @return {Position} position 城市位置指针.未找到返回nullptr。 
    */
    Position *positionOf(const string &name) const;

    /**
    * @description: 在list中寻找距离position小于distance的节点，并用new构造出一个List
    * @param {Position} position 被比较的位置
    *        {double} distance 距离 
    * @return {List*} 构造出的表的指针, distance 非法则返回nullptr
    */
    List *distanceToPositionLessEqual(double x, double y, double distance);

    //展示list所有城市信息
    void show() const;
};
#endif