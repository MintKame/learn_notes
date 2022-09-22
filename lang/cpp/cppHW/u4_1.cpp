/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 20:18:26
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u4_1.cpp
 */
#include <iostream>
#include <string>
class Parse
{
private:
    int first;
    int last;

public:
    Parse(std::string s);
    int getFirst();
    int getLast();
};

Parse::Parse(std::string s)
{
    int pos = s.find_first_of('-');
    first = std::stoi(s.substr(0, pos));
    last = std::stoi(s.substr(1 + pos));
}

int Parse::getFirst()
{
    return first;
}

int Parse::getLast()
{
    return last;
}

int main()
{
    std::string s{};
    std::cin >> s;
    Parse p(s);
    std::cout << p.getFirst() << ' ' << p.getLast();
    std::cin.get(); //
    std::cin.get(); //
    std::cin.get(); //
    return 0;
}
