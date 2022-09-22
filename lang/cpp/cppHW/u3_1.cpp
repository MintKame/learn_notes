/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 19:52:59
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u3_1.cpp
 */
#include <iostream>
int swap(int &a, int &b, int &c);
int main()
{
    int a{1}, b{2}, c{3};
    int max{swap(a, b, c)};
    std::cout << max << ' ';
    std::cout << a << ' ';
    std::cout << b << ' ';
    std::cout << c;
    //std::cin.get();
    return 0;
}
int swap(int &a, int &b, int &c)
{
    int tmp = a, ret = a;
    if (ret < b)
    {
        ret = b;
    }
    if (ret < c)
    {
        ret = c;
    }
    a = c;
    c = b;
    b = tmp;
    return ret;
}
