/*
 * @Author: 闫昭
 * @Date: 2020-09-13 10:04:34
 * @LastEditTime: 2021-06-28 10:40:12
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\8_1_excep.cpp
 */
#include <iostream>
#include <exception>
#include <stdexcept>
#include <vector>
using namespace std;
//! when not use: easy; debug(use assert); ctrl flow(use if)
//  when     use: unexcepted
//          1. external problem:
//             eg. illegal input; disk full.
//          2. func can't do what it supposed to
//             ctor fail.

// +: bring exception in callee to main; separate detection & handling
double divid(double up, double down)
{
    if (down == 0)
        throw(up);
    return (up / down);
}
int main()
{
//! try - throw - catch: (try & catch in same func
#if 1
    ///////////////
    double up, down;
    cin >> up >> down;
    try
    {
        cout << divid(up, down); // also can throw directly
        // exe in nomal case
    }
    catch (const exception &e) // can omit para just type (if not use msg)
    {
        // exe when ex
        cout << e.what() << " can't be dividend by 0" << endl;
    }
#endif
//! in catch:
// ref:  access exception poly, fast
//      if no ref: use parent exception's type to catch a child
//      -> auto-down-cast
//      -> miss msg
// const: increase performance,
//        not modify the object

//! cpp embeded ex cls: more msg
//1. runtime_error : (always can't modify)
//2. logic_error   : not match, too much (can modify)
// (first two need include stdexcept)
#if 0 // out_of_range
    vector<int> a{1, 2, 3, 4, 5};
    try
    {
        cout << a.at(10) << endl; //[] can't throw, at() can
    }
    catch (out_of_range &e)
    {
        cout << e.what() << endl;
    }

#endif
#if 0 //3. bad_cast
    class Person
    {
        virtual void foo(){};
    };
    class Woman : public Person
    {
    };
    class Man : public Person
    {
    };
    Woman w;
    Person &p = w;
    try
    {
        dynamic_cast<Man &>(p); //!dyn_cast: ptr don't throw exce; ref do
    }
    catch (bad_cast &e)
    {
        cout << e.what() << endl;
    }
#endif
#if 0 //4. bad_alloc
    try
    {
        for (int i = 0; i < 100000; i++)
            long long *ptr = new long long[1000000];
    }
    catch (bad_alloc &e)  
    {
        cout << e.what() << endl;
    }
#endif
#if 1 //5. bad_typeid
#include <typeinfo>
    try
    {
        int *ptr = NULL;
        cout << typeid(ptr).name() << endl;
    }
    catch (bad_typeid &e)
    {
        cout << e.what() << endl;
    }
#endif
}