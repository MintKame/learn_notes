/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-12-03 15:18:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/5_hash/Hash.h
 */

/** Hash.cpp */
#ifndef YZ_HASH
#define YZ_HASH
#include <iostream>
#include <string>
using namespace std;

class Hash
{
private:
    string *records;
    int size;
    int m;
    // 根据名字返回存储地址
    int hash(string name);

public:
    Hash(int size);
    ~Hash();
    // 插入记录，若表满或已经存在，返回false
    bool insert(string name);
    // 查找记录，若未找到返回-1, 找到返回次数
    int search(string name);
};
#endif