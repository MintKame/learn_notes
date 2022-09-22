/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-12-08 21:46:19
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/6_grade/test.cpp
 */

/** test.cpp */
#include "Student.hpp"
#include <iostream>
using namespace std;
int main()
{
    int st, su;
    cin >> st >> su; // 学生，考试个数
    Table table = Table(st, su);
    table.quickSort();
    table.printTable();
}