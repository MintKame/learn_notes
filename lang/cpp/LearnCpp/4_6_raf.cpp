/*
 * @Author: your name
 * @Date: 2021-06-02 11:39:24
 * @LastEditTime: 2021-06-28 12:10:20
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\9_5_raf.cpp
 */
#include <iostream>
#include <fstream>
#include <filesystem>
#include <array>
#include <vector>
namespace fs = std::filesystem;
using std::cout;
using std::endl;
using std::fstream;

int main()
{
    fs::path p{"test.dat"};
    fstream file{p, std::ios::out | std::ios::in | std::ios::trunc};
    // mode: both can read and write

    //! write
    auto x{12LL}, y{24LL};
    char str[]{"Hello World"};

    file.write(reinterpret_cast<char *>(&x), sizeof(x));
    file.write(reinterpret_cast<char *>(&y), sizeof(long long int));
    file.write(str, sizeof(str));

    //! read "Hello" from file
    char buf[100]{0};
    //! move positioner
    file.seekg(2 * sizeof(long long int), std::ios::beg);

    file.read(buf, 5);
}