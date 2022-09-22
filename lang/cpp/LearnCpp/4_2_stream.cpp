/*
 * @Author: your name
 * @Date: 2021-06-02 11:38:45
 * @LastEditTime: 2021-06-28 11:21:01
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\9_2_stream.cpp
 */
#include <iostream>
#include <fstream>
#include <filesystem>
#include <string>
namespace fs = std::filesystem;
int main(int argc, char const *argv[])
{
    fs::path p = "4_.txt";
    return 0;
}

// write char at stdin, 2 bytes: char, \n
void buf()
{
    // get buf ptr of cin
    auto p = std::cin.rdbuf();

    // size of char in buf
    auto count = p->in_avail();
    std::cout << "There are " << count << " characters in the buffer." << std::endl;

    // peek: read but not change the buf
    auto x = std::cin.peek();
    std::cout << "x = " << x << std::endl;

    // get all char in buf
    for (int i = 0; i < count; i++)
    {
        std::cout << i + 1 << ": " << std::cin.get() << std::endl;
    }
}

void file_io(fs::path p)
{
    if (p.empty())
    {
        std::cout << "path is empty" << std::endl;
        return;
    }
    if (fs::exists(p))
    {
        std::cout << "already exist, will cover the content" << std::endl;
        return;
    }
    //! file out
    std::ofstream fout{p};
    fout << "123" << std::endl;
    fout.close();
    //! file in: need know the type before read
    std::ifstream fin{p};
    // diff from out: check success open, eof ?
    if (fin.fail()) // same as: !fin
    {
        std::cout << "open failed" << std::endl;
        return;
    }
    char char_read;
    // get() read each byte
    //  have para -> set para char
    //  no para   -> ret int
    while (!fin.get(char_read).eof())
    {
        std::cout << char_read << std::endl;
    }
    fin.close();
}

void getline_test(fs::path p)
{
    //! when use?
    //  >> delim is any blank char
    std::ifstream fin{p};
    if (fin.fail())
    {
        std::cout << "open failed" << std::endl;
        return;
    }
    //! istream
    constexpr int SIZE = 1024;
    std::array<char, SIZE> buf; // &buf
    while (!fin.eof())
    {
        fin.getline(&buf[0], SIZE, '#'); // delim is #
        // not use &buf, cause it's obj's addr, rather than 1st data's
        std::cout << &buf[0] << std::endl;
    }
    //! std (always)
    fin.close();
    fin.open(p);
    std::string name1{""};
    while (!fin.eof())
    {
        std::getline(fin, name1, '#');
        std::cout << name1 << std::endl;
    }
}