/*
 * @Author: your name
 * @Date: 2021-06-02 11:39:07
 * @LastEditTime: 2021-06-28 11:50:49
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\9_4_bin.cpp
 */
#include <iostream>
#include <fstream>
#include <filesystem>
#include <array>
int main()
{
    namespace fs = std::filesystem;

    fs::path p{"array.dat"};
    //! write
    std::fstream out{p, std::ios::out | std::ios::app};

    // write array(not char) to file
    std::array a{21L, 42L, 63L};
    int b{0};
    char c[2]{1, 2};
    std::streamsize size = a.size() * sizeof(a[0]); // how many bytes
    out.write(reinterpret_cast<char *>(&a[0]), size);
    out.write(reinterpret_cast<char *>(&b), size);
    out.write(c, size);
    // how get 1st para (type char*):
    //    addr of 1st data: &a[0]
    //    cast to char*: reinterpret_cast

    // reinterpret_cast: addr <-> addr; num <-> addr
    //! read
    out.close();
    out.open(p, std::ios::in); // reopen as istream

    // read an int from file
    auto x{0L};
    char s[10];
    out.read(reinterpret_cast<char *>(&x), sizeof(x));
    out.read(s, 5);
    s[5] = '\0';
    return 0;
}