/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 19:22:58
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u2_2.cpp
 */
#include <iostream>
namespace NS1
{
    int x{1};
} // namespace NS1
namespace NS2
{
    int x{2};
} // namespace NS2
int main()
{
    std::cout << NS1::x << std::endl;
    std::cout << NS2::x << std::endl;
    std::cin.get();
    return 0;
}