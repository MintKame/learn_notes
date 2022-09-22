/*
 * @Author: 闫昭
 * @Date: 2020-10-15 15:36:22
 * @LastEditTime: 2020-10-16 21:44:19
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/2_stack/Convert.cpp
 */
#include <iostream>
#include "Stack.h"
using namespace std;
using Type = int;
/**
 * @description: 将十进制数转换为其它进制数。并返回结果。（>=0 为结果，-1失败）
 * @param dec 原十进制数 
 * @param base 新的进制 
 * @return 新进制下的数， 若输入有问题（dec为负，进制 <= 0），返回-1
 */
int decTo(int dec, int base)
{
    //检查输入合法
    if (dec < 0 || base <= 0)
        return -1;
    //创造一个栈
    auto stack = new Stack();
    //计算各个位数，从低位到高位顺序
    while (dec != 0)
    {
        //对dec % base，结果入栈，再更新 dec
        stack->push(dec % base);
        dec /= base;
    }
    int ret = 0; //新的进制下的数
    //按顺序出栈，产生新的数
    for (int i = stack->getSize(); i > 0; i--)
    {
        int tmp = stack->pop();
        ret = 10 * ret + tmp;
    }
    //删除栈
    delete stack;
    return ret;
}

/**
 * @description: 对于测试数据一个十进制数组，转化每一个数的进制并打印
 * @param arr  测试的数组
 * @param size 数组大小
 * @param base 转化的新进制 
 */
void printConvertNum(int arr[], int size, int base)
{
    for (int i = 0; i < size; i++)
    {
        int tmp = decTo(arr[i], 8);
        if (tmp != -1)
        {
            cout << arr[i] << "转化为 8进制：" << tmp << endl;
        }
        else
        {
            cout << arr[i] << "不是非负整数" << endl;
        }
    }
}

int main()
{
    int arr[] = {1348, 0, 1, 8, -5};
    printConvertNum(arr, 5, 8);
    return 0;
}