/*
 * @Author: your name
 * @Date: 2021-06-02 11:38:57
 * @LastEditTime: 2021-06-27 23:34:59
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\9_3_form.cpp
 */
#include <iostream>
// 控制输出数据所占的位宽，控制数据的精度
#include <iomanip>
int main(int argc, char const *argv[])
{
    // others see 4_0
    //! set precision (total cnt of num, not include point)
    float f = 17 / 7.0;
    std::cout << f << std::endl;                         // 2.42857
    std::cout << std::setprecision(0) << f << std::endl; // 2
    std::cout << std::setprecision(1) << f << std::endl; // 2
    std::cout << std::setprecision(2) << f << std::endl; // 2.4
    std::cout << std::setprecision(3) << f << std::endl; // 2.43
    std::cout << std::setprecision(6) << f << std::endl; // 2.42857
    std::cout << std::setprecision(8) << f << std::endl; // 2.4285715
    //! set width
    std::cout << std::setw(2) << 'a' << 'b' << std::endl;
    // "_ab". just for first data;
    // if para not enough, not tunacate
    //! set fill
    std::cout << std::setfill('%') << std::setw(5) << "a" << std::endl;
    return 0;
}
