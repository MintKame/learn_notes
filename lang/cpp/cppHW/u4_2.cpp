/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 21:29:31
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u4_2.cpp
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
    int head, tail;
    int mid = s.find_first_of('-');
    int max = s.size() - 1;
    for (int i = mid - 1; i >= 0; i--)
    {
        if (!isdigit(s[i]))
        {
            head = i + 1;
            break;
        }
        if (i == 0)
        {
            head = 0;
        }
    }
    for (int i = mid + 1; i <= max; i++)
    {
        if (!isdigit(s[i]))
        {
            tail = i - 1;
            break;
        }
        if (i == max)
        {
            tail = max;
        }
    }
    first = std::stoi(s.substr(head, mid - head));
    last = std::stoi(s.substr(1 + mid, tail - mid));
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
