/*
 * @Author: 闫昭
 * @Date: 2020-09-14 11:59:52
 * @LastEditTime: 2021-06-28 10:45:58
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\cppSyntax\8_5_reThrow.cpp
 */
#include <iostream>
#include <exception>
//! when rethrow:
// handler can't handle
// to notify its caller
void f()
{
    try
    {
        throw std::logic_error("err in f()");
    }
    catch (std::exception &e)
    {
        std::cout << "catch in f()" << std::endl;
        //! rethrow: throw in catch
        throw; // 1. throw same ex

        //2. throw another ex
        // cast ptr not throw
        std::logic_error *p = dynamic_cast<std::logic_error *>(&e);
        // cast ref may throw std::bad_cast
        std::logic_error &p = dynamic_cast<std::logic_error &>(e);
    }
}
int main()
{
    try
    {
        f();
    }
    catch (std::exception)
    {
        std::cout << "catch in main()" << std::endl;
    }
    return 0;
}