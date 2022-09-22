/*
 * @Author: 闫昭
 * @Date: 2020-03-16 13:35:38
 * @LastEditTime: 2021-06-28 09:21:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/0_init_type.cpp
 */
#include <iostream>
#include <array>
#include <typeinfo>
// include "not std,local lib"

// !compile
// g++ -std=c++17 -o yz -Wall -Wextra
//  -std=c++17
//  -o FileName (defaule: a.out)

// recommand:
//  -Wall (all the warnings, generate warning about problem constructs)
//  -Wextra (some extra warning flags that are not enabled by -Wall)

// get main's ret: echo $?

//! using's 2 usages
using UInt = unsigned int; //type name
// ==
typedef unsigned int UInt;
//
using Uu = UInt *; // can

// namespace:
//  why: avoid collision, same names from diff lib.
//  how: can't use keyword; can define, can nest
using namespace std; // not recommand
using std::cout;     // recommand
// All standard library are in std namespace

// statically typed: type checking at compile time
class classType
{
};
//! auto (ret type of a func)
auto f(double) -> int;
auto f(double){/*…*/};
auto f = [](double) { /*… */ }; //anoy func

int main()
{
    //! bool
    bool bl = true;                    // c use 0 / 1
    std::cout << std::boolalpha << bl; // true
    std::cout << bl;                   //1
    // boolalpha is a func

    //! list init
    int x{};  // x is 0;
    int y{1}; // y is 1;
    int array1[]{1, 2, 3};
    char s1[3]{'o', 'k'};
    char s3[]{"Hello"};

    // cmp diff ways:
    int a1{1};
    // clearer and less error-prone
    // +  not allow narrowing (can: char -> int; can't int -> char)
    int a2 = {1};
    int a3 = 1;
    int a4(1);

    //! auto
    // always use auto,
    auto a1{'a'};
    auto a2 = 3;
    auto a3 = 42ul;
    // if want to specify type
    auto a4 = int{3};

    // constrain: 1 line vars must same type; can't be array

    // how degenerate ? (const / ref / array)
    const int m = 1;
    auto m1 = m;  //m1 not const
    auto &m2 = m; //m2     const, but become same thing

    int &rm = m;
    auto rm2 = rm; // rm2 not ref to m

    int s[]{1, 2, 3};
    auto s1 = s; //s1 is a ptr
    auto &s2 = s;

    //! how to getType ?
    std::cout << "s1 " << typeid(s1).name() << std::endl;
    std::cout << "s2 " << typeid(s2).name() << std::endl;

    //! decltype
    // used for template,
    // diff from auto:
    //      declare type same as the expr, but not same val
    //      preserve const, ref (not degenerate)
    decltype(x) d;
    // x's type is return type of fun1()
    decltype(fun1()) x; // not exe fun1

    //!binding: to declare
    //!form: cv-auto &/&& [x1,x2,..] =/{}/()
    //1.num(l) == num(r)
    //2.for cls's member, must be public;
    //3.all of struct's members are public

    //c-style array
    int aa[3]{1, 2, 3};
    auto [a1, a2, a3]{aa};

    //c++ array
    std::array bb{'a', 'b', 'c'};
    auto &[b1, b2, b3](bb);

    //cls / struct
    class C
    {
    public:
        int i = 1;
        char cc[3]{0, 1, 2};
    };
    C cc;
    const auto [c1, c2] = cc;

    //!alloc: anonymous + {} list init
    //  diff: malloc not call ctor,dtor
    int *a = new int; //int
    //       new int{1};
    delete a;
    a = nullptr; //! always

    int *b = new int[10]; //int array, b is ptr of 1st var
    //       new int[10]{1, 2};
    delete[] b;
    b = nullptr;

    classType *c = new classType{}; //class
    delete c;
    c = nullptr;

    //! explicitly cast ?
    double y = static_cast<double>(1);
    return 0; // [0, 255], if -1 -> 255
}