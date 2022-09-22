/*
 * @Author: 闫昭
 * @Date: 2020-03-14 15:22:14
 * @LastEditTime: 2021-06-28 09:30:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/3_ref.cpp
 */
#include <iostream>

//! if return ref, what should pay attention ?
//the returned ref should be the ref-para passed to the func,
//local var(pass by val / create in-func) is destored after return
const int &niceFunc(int &x)
{
    return x;
}

int &badFunc() // result undef
{
    int a = 1;
    return a;
}

//! & as ref: only when declare (func para,ret's type / var's type)
//      in asm, compile to code same as ptr(def var / func)
int f(int x)
{
    x++;
    return 0;
}
int pf(int *x)
{
    (*x)++; //wrong: *x++
    return 0;
}
//! ref - func para
//  operate on passed data
int rf(int &x)
{
    x++;
    return 0;
}

int main()
{
    int a = badFunc();

    // rx, x are var at same addr, diff name
    int x = 0, &rx = x; //! ref - var
    // must be init in declaration
    // cannot be assigned to other var

    const char *s1 = "Hello";
    const char *s2 = "World";
    const char *&sr = s1;

    f(x);
    rf(x);  //++
    pf(&x); //++
    // func pass var(same addr, diff name)
    f(rx);
    rf(rx);  //++
    pf(&rx); //++
    std::cout << "x=" << x << std::endl;
    return 0;
}
