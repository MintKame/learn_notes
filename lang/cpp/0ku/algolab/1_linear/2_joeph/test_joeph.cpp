/*
 * @Author: 闫昭
 * @Date: 2020-10-10 16:55:27
 * @LastEditTime: 2020-10-11 10:09:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/2_joeph/test_joeph.cpp
 */
#include <iostream>
#include "joeph.h"
using namespace std;

int main()
{
    List list;
    //输入报数初始值
    int m, n;
    cout << "请输入初始报数" << endl;
    cin >> m;
    //输入密码，构造循环链表
    cout << "请输入密码（以0结束）:" << endl;
    int tmp = -1;
    for (int i = 1; 1; i++)
    {
        cout << "第" << i << "个人的密码" << endl;
        cin >> tmp;
        if (!tmp)
            break;
        list.insert(i, tmp);
    }
    //prior置为尾指针 (因为最开始为第一个人报数)
    list.setPrior(list.last);
    //当size大于0，找到下一个出队节点的prior，
    //（prior指针置为next （m - 1）% size次）
    int isFirst = 1; //用于确定输出格式
    cout << "出列顺序：" << endl;
    while (list.size)
    {
        list.count(m);
        int *tmp = list.deleteNext();
        //输出被删的序号，更新m
        if (!isFirst)
            cout << ", ";
        cout << tmp[0];
        m = tmp[1];
        isFirst = 0;
    }
    cout << endl;
    return 0;
}