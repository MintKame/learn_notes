/*
 * @Author: 闫昭
 * @Date: 2020-07-30 08:47:09
 * @LastEditTime: 2021-05-27 16:47:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/2_assert_constexpr.cpp
 */
#include <iostream>
#include <array>
#include <cassert> //assert()

#if 1
#define NDEBUG //block assert //?
int n = 1;

//! ptr && const
const int *p1;
// const ptr: value can't change by ptr
int *const p1;
// ptr const: ptr can't change
//
// can't change: thing after const
// how to read: same as the order of const and *

//! what are types of const ?
const int a = 1;
const int b = n;
// compile-time (when can set value)
// run-time

int sa[a];
//int sb[b]; error

//! what is constexpr ?
// must compile-time const
constexpr int aa = 1;
// constexpr int bb = n; error
std::array<int, factorial(aa)> arr; //<a,b>: b should be constexpr

// ! how can func return constexpr ?
//must: input is constexpr; have && 1 ret && ret a constexpr
constexpr int factorial(int n)
{
    if (n <= 1)
    {
        return 1;
    }
    else
    {
        return (n * factorial(n - 1));
    }
}
//! what result in c and cpp ?
char *s1 = "Hello";       // compile: c can
const char *s2 = "World"; // C++ must const
*s1 = 'a';
// C  : runtime err
// cpp: compile err

int main()
{
    //! Is assert a func ?
    //a keyword

    //! when to use
    //debug
    //don't use to dispose err input

    assert(factorial(1) == 0); //tell at run

    //static_assert (bool_constexpr, message)
    static_assert(factorial(4) == 24, "f4 != 24"); //tell at compile, expr must be compile-time const
    // usage: when write a lib
    static_assert(sizeof(void *) == 4,
                  "64-bit code generation is not supported.");
    return 0;
}
#endif