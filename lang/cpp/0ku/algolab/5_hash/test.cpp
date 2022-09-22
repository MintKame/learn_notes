/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-12-03 16:00:13
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/5_hash/test.cpp
 */
/** test.cpp */
#include "Hash.h"
#include <string>
#include <iostream>
using namespace std;
string names[30] = {"abc", "def", "gh", "jkl", "mn", "op",
                    "qq", "rs", "ttt", "uv", "za", "pp",
                    "ww", "zyr", "yz", "gc", "sz", "lqy",
                    "wxr", "jhw", "nxp", "yjy", "lyq", "hhh",
                    "rra", "bz", "cxk", "zt", "eee", "asdqfs"};

int main()
{
    Hash hash = Hash(30);
    for (size_t i = 0; i < 30; i++)
    {
        hash.insert(names[i]);
    }
    int cnt = 0;
    for (size_t i = 0; i < 30; i++)
    {
        cnt += hash.search(names[i]);
    }
    //some err case
    hash.insert(names[10]);
    hash.insert("xq");
    hash.search("xq");
    //out put ASL
    cout << "ASL " << 1.0 * cnt / 30 << endl;
    return 0;
}