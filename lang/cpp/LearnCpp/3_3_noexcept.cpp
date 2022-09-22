/*
 * @Author: 闫昭
 * @Date: 2020-09-14 10:35:08
 * @LastEditTime: 2021-05-30 22:49:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\8_3_noexcept.cpp
 */
#include <iostream>
using namespace std;
//! declare func throws what ex
// like java's "throws", but not must, seldom use
// cpp-11 use "noexcept",

//! 2 types
void bar() noexcept(true) {}
void zao() noexcept // noexcept func:
{
    throw 42;
    //   in func body throw a except == std::terminate()
}

void foo() {}
void yan() noexcept(false) {}
//can't use noexcept to overload func

int main()
{
    //! noexcept()
    //ret base on declare of "noexcept", rather than really throw or not
    cout << noexcept(foo()) << endl;
    cout << noexcept(bar()) << endl;
    cout << noexcept(yan()) << endl;
}