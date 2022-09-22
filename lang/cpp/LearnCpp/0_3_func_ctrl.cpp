/*
 * @Author: 闫昭
 * @Date: 2020-07-30 01:19:56
 * @LastEditTime: 2021-06-28 09:23:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/1_func_ctrl.cpp
 */
#include <iostream>
#include <typeinfo>
#define LENGTH 5

//! 1. how to visit global var (hinded) in func ?
int a; // global var
void visitGlobleP()
{
    double a;
    std::cout << typeid(a).name() << std::endl;   //d
    std::cout << typeid(::a).name() << std::endl; //i //! ::
}

//! 2. what is the restrict of default para ?
void defaultPara(int a, int b = 0) //at right
{
}

//! overload:
// same name, diff para's type / order / size
int max(int a, int b)
{
    return a > b ? a : b;
}

unsigned max(unsigned a, unsigned b)
{
    return a > b ? a : b;
}
//! main
// ret:  must int
// para: have / not have
// can not ret, compiler auto generate
//      always ret 0 if success; nozero if err defined by system
int main()
{
    defaultPara(1);
    defaultPara(1, 2);

    // set can be:
    int v1[] = {1, 2, 3};
    std::array<int, 4> v2{2, 4, 6, 8};
    std::vector<int> v3[] = {1, 2, 3};
    //! what is diff between for & foreach ?
    for (int i : v1) //i is the value, can't change orginal
    {
        i *= 2;
    }
    //! how to change orginal using foreach
    for (int &i : v2) // add &, can change member
    {
        i *= 2;
    }
    tmp(v1);
    tmp(v2);

    //! when use
    if (auto x = 1; x > 40)
        ;
    switch (auto x = 1; x)
        ;
    //initialize the x only used once (modeling)
    return 0;
}
void tmp(int *v)
{
    std::cout << "----" << std::endl;
    std::cout << v[0] << std::endl;
    std::cout << v[1] << std::endl;
    std::cout << v[2] << std::endl;
}
