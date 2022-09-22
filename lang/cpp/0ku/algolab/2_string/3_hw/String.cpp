/*
 * @Author: 闫昭
 * @Date: 2020-10-22 13:39:51
 * @LastEditTime: 2020-10-28 16:54:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/2_string/3_hw/String.cpp
 */
/* String.cpp */
#include "String.h"
#include <iostream>
using namespace std;

String::String(char *str_, int length_)
{
    length = length_;
    str = new char[length];
    for (int i = 0; i < length; i++)
    {
        str[i] = str_[i];
    }
}

void String::print()
{
    for (int i = 0; i < length; i++)
        cout << str[i];
}

int String::getLength()
{
    return length;
}

char String::charAt(int index)
{
    if (index < length && index >= 0)
        return str[index];
    else
        return 0;
}

//构造next表
int *String::getNextTable()
{
    int *next = new int[getLength() + 1]; // + 1 因为最后一个为匹配时，寻找下一个子串要回溯的位置
    next[0] = -1;                         //首个设置为-1
    //遍历每个字符
    for (int i = 1; i <= getLength(); i++)
    {
        next[i] = 0;
        //匹配之前字符的前后缀
        int cnt = i - 1; //记录公共的长度,初始化为最大
        for (; cnt > 0; cnt--)
        {
            int flag = 1;       //记录前后是否相同
            int prior = 0;      //当前比较的前缀字符的下标
            int post = i - cnt; //当前比较的后缀字符的下标
            for (; prior < cnt; prior++, post++)
            {
                //出现不匹配，改flag，退出循环尝试新公共长度
                if (charAt(prior) != charAt(post))
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) //找到最长公共前后缀
            {
                next[i] = cnt;
                break;
            }
        }
    }
    return next;
}

//求出 sub 所有出现的位置。
vector<int> String::index(String sub)
{
    //初始化结果数组
    vector<int> ret;
    int *next = sub.getNextTable();   //构造next表
    int src_index = 0, sub_index = 0; //记录当前比较位置
    //遍历主串，与子串比较字符
    //由于主串最后部分可能与子串匹配，src_index == length时仍循环，从而判断
    for (; src_index <= length; src_index++, sub_index++)
    {
        if (sub_index == -1)
        {
            continue;
        }
        //找到一个匹配
        if (sub_index == sub.getLength())
        {
            ret.push_back(src_index - sub_index);
            sub_index = next[sub_index];
        }
        //不同则回溯
        while (src_index != length &&
               sub.charAt(sub_index) != charAt(src_index) &&
               sub_index != -1)
        {
            sub_index = next[sub_index];
        }
    }
    return ret;
}