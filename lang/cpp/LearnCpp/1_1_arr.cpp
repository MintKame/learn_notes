/*
 * @Author: 闫昭
 * @Date: 2020-07-30 14:41:07
 * @LastEditTime: 2021-05-27 16:00:44
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/4_1_arr.cpp
 */
#include <iostream>
#include <array>
#include <algorithm>
int main()
{
    //! c - style
    int list[]{4, 2, 3, 6, 5, 1};
    int *min = std::min_element(list, list + 6);
    int *max = std::max_element(list, list + 6);
    std::random_shuffle(list, list + 6);
    std::sort(list, list + 6);

    //! how to make a c++ style array ?
    // ctor : <type,size(can't change)> (template)
    std::array<int, 5> s0{1, 2};
    std::array s1{7, 6, 5, 4, 3}; // type deduct -> <int, 2>

    //!visit
    s0[4];      //0 (auto)
    s0.at(1);   //2 (check boundry)
    s0.front(); //s[0]=1
    s0.back();  //s[5]=0
    s0.data();  //ret front's ptr

    //!msg
    s0.empty();    //bool: 0
    s0.size();     //5
    s0.max_size(); //5

    //!change
    s0.fill(10); //all set to 10
    s0.swap(s1); //must same type,size
    std::cout << s1[0] << std::endl;

    //!sort
    // std::sort(s0.rbegin(), s0.rend());

    //! iteration
    //s0.begin

    return 0;
}