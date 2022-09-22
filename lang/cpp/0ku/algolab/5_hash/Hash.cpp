/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-12-03 15:59:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/5_hash/Hash.cpp
 */

/** Hash.h */
#include "Hash.h"

int maxPrime(int num)
{
    int isPrime = false;
    for (size_t i = num; i > 2; i--)
    {
        isPrime = true;
        for (size_t j = 2; j * j <= i; j++)
        {
            if (i % j == 0)
            {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
        {
            return i;
        }
    }
    return 2;
}

Hash::Hash(int size)
{
    // 初始化
    this->size = size;
    records = new string[size];
    for (size_t i = 0; i < size; i++)
    {
        records[i] = "";
    }
    // 设置m为最大质数
    m = maxPrime(size);
}

Hash::~Hash()
{
    delete[] records;
}
int Hash::hash(string name)
{
    int add = 0;
    for (int i = 0; i < name.size(); i++)
    {
        add += name[i] - 'a';
    }
    add %= m;
    return add;
}

// 插入记录，若表满或已经存在，返回false
bool Hash::insert(string name)
{
    int add = hash(name);
    bool isFirst = true;
    while (true)
    {
        if (!records[add].compare("")) //insert
        {
            records[add] = name;
            cout << name << "\tinsert\tsuccess" << endl;
            return true;
        }
        else if (!records[add].compare(name)) //already exist
        {
            cout << name << "\tinsert\talready exist" << endl;
            return false;
        }
        else if (!isFirst && add == hash(name))
        {
            cout << name << "\tinsert\tno place" << endl;
            return false;
        }
        else
        {
            add = (add + 1) % size;
            isFirst = false;
        }
    }
}

// 查找记录，若未找到返回false
int Hash::search(string name)
{
    int add = hash(name);
    int cnt = 1;
    while (true)
    {
        if (!records[add].compare("") || (add == hash(name) && cnt != 1))
        {
            cout << name << "\tsearch\tnot exist" << endl;
            return -1;
        }
        else if (!records[add].compare(name))
        {
            cout << name << "\tsearch\texist"
                 << "\tcnt: " << cnt << endl;
            return cnt;
        }
        else
        {
            cnt++;
            add = (add + 1) % size;
        }
    }
}