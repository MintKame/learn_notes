/*
 * @Author: your name
 * @Date: 2021-06-26 21:38:28
 * @LastEditTime: 2021-06-26 22:38:58
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\6_1_itr.cpp
 */
#include <iostream>
#include <vector>
#include <map>
int main()
{
    //! create
    std::vector<int> v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);

    std::map<int, double> map;
    map.insert(std::map<int, double>::value_type(1, 1.1));

    //! diff container, diff itr type
    std::vector<int>::iterator itr1;
    for (itr1 = v.begin(); itr1 != v.end(); itr1++)
    {
        std::cout << *itr1 << " ";
    }
}