/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-10-25 14:41:50
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/2_string/1_match/match.cpp
 */

/**用固定的方法存字符串，并实现匹配功能*/
#include <iostream>

using namespace std;
/**
     * @description: 查找子串
     * @param src 主串
     * @param sub 子串
     * @return 若子串为空，返回-1。如果包含，返回在主串中起始位置。否则返回-1。
     */
int index(char *src, char *sub)
{
    int ret = -1;
    int length = src[0];
    int len_sub = sub[0];
    if (len_sub > length || len_sub == 0) //sub比主串长或为空，不匹配
    {
        return ret;
    }
    int index_main = 1, index_sub = 1; //记录比较到哪个位置
    //循环直到找到匹配或主串遍历完
    while (1)
    {
        //比较当前位置：
        //匹配则下标都+1
        if (sub[index_sub] == src[index_main])
        {
            index_sub++;
            index_main++;
        }
        //不匹配则子串回到初始位置，主串回到本次匹配的开始字母的下一个字母
        else
        {
            index_main = index_main - index_sub + 2;
            index_sub = 1;
        }
        //判断是否完成匹配,完成则退出循环
        if (index_sub == len_sub || index_main == length)
            break;
    }
    //判断匹配成功
    if (index_sub == len_sub)
    {
        ret = index_main - index_sub + 1;
    }
    return ret;
}
int main()
{
    char sub[10] = {3, 'd', 'e', 'f'};
    char s1[10] = {6, 'a', 'b', 'c', 'd', 'e', 'f'};
    char s2[10] = {3, 'd', 'e', 'f'};
    char s3[10] = {3, 'b', 'e', 'f'};
    char s4[10] = {2, 'e', 'f'};
    char s5[10] = {0};

    cout << index(s1, sub) << endl; //匹配
    cout << index(s2, sub) << endl; //匹配
    cout << index(s3, sub) << endl; //不匹配
    cout << index(s4, sub) << endl; //不匹配
    cout << index(s5, sub) << endl; //不匹配
    return 0;
}
