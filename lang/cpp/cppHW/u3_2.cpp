/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 20:00:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u3_2.cpp
 */
#include <iostream>
char min(char c1, char c2);
char min(char c1, char c2, char c3);
int min(int i1, int i2);
int min(int i1, int i2, int i3);

int main()
{
    std::cout << min('l', 'N') << ' ';
    std::cout << min('g', 'G', '*') << ' ';
    std::cout << min(-42, 0) << ' ';
    std::cout << min(42, 0, std::numeric_limits<int>::min());
    std::cin.get();
    return 0;
}
char min(char c1, char c2)
{
    return ((c1 < c2) ? c1 : c2);
}

char min(char c1, char c2, char c3)
{
    char c12 = (c1 < c2) ? c1 : c2;
    return ((c12 < c3) ? c12 : c3);
}

int min(int i1, int i2)
{
    return ((i1 < i2) ? i1 : i2);
}

int min(int i1, int i2, int i3)
{
    int i12 = (i1 < i2) ? i1 : i2;
    return ((i12 < i3) ? i12 : i3);
}