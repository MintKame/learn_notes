/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-10-28 08:29:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/2_string/3_hw/concat.cpp
 */

/*定长方式存储字符串，实现连接*/
#include <iostream>

using namespace std;

char *concat(char *head, char *tail)
{
    int len_h = head[0];
    int len_t = tail[0];
    char *ret = new char[len_h + len_t];
    ret[0] = len_t + len_h;
    for (int i = 1; i <= len_h; i++)
    {
        ret[i] = head[i];
    }
    for (int j = 1; j <= len_h; j++)
    {
        ret[len_h + j] = tail[j];
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

    char *r1 = concat(s1, s2);
    cout << r1 + 1 << endl;
    return 0;
}
