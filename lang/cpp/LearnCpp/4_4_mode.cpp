/*
 * @Author: your name
 * @Date: 2021-06-28 01:09:31
 * @LastEditTime: 2021-06-28 11:23:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\4_4_mode.cpp
 */
#include <filesystem>
#include <iostream>
#include <fstream>
namespace fs = std::filesystem;
int main()
{
    fs::path p1{"city1.txt"}, p2{"city2.txt"};

    // fstream = ifstream + ofstream
    // need pass mode: use | (bitwise OR) to combine
    //! out
    std::fstream out1{p1, std::ios::out | std::ios::app};   // append
    std::fstream out2{p2, std::ios::out | std::ios::trunc}; // clear file(default)

    // write to 2 stream
    char c;
    while (!std::cin.get(c).eof()) // from std
    {
        out1.put(c); // to file
        out2.put(c);
    }
    out1.close();
    out2.close();

    //! in
    std::fstream in1{p1, std::ios::in};
    std::fstream in2{p2, std::ios::in | std::ios::ate}; // cursor at end

    // print content of 2 stream
    std::cout << p1 << std::endl;
    while (!in1.get(c).eof()) // from file
    {
        std::cout << c; // to std
    }

    std::cout << p2 << std::endl;
    while (!in2.get(c).eof())
    {
        // not reach, cause cursor at eof
        std::cout << c;
    }
    in1.close();
    in2.close();
}