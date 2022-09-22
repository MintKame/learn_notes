/*
 * @Author: 闫昭
 * @Date: 2020-03-16 16:53:50
 * @LastEditTime: 2020-07-22 09:49:57
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\0ku\cppSynax\multiInher.cpp
 */
#include <iostream>
using namespace std;
class Person
{
public:
    std::string name;
    void intro();
    Person(std::string theName);
};

Person::Person(std::string theName)
{
    name = theName;
}
void Person::intro()
{
    std::cout << "i m " << name << std::endl;
}

class Ta : public Person //teacher assistant
{
protected:
    std::string classes;

public:
    void intro();
    Ta(std::string theName, std::string teachingCls);
};

Ta::Ta(std::string theName, std::string teachingCls) : Person(theName)
{
    classes = teachingCls;
}
void Ta::intro()
{
    std::cout << "i m " << name << " i teach" << classes << std::endl;
}

class sT : public Person //student
{
protected:
    std::string cls;

public:
    void intro();
    sT(std::string theName, std::string teachedCls);
};

sT::sT(std::string theName, std::string teachedCls) : Person(theName)
{
    cls = teachedCls;
}
void sT::intro()
{
    std::cout << "i m " << name << " i study in" << cls << std::endl;
}

class Ts : public Ta, public sT //student & ta
{
public:
    void intro();
    Ts(std::string theName, std::string teachingCls, std::string teachedCls);
};

Ts::Ts(std::string theName, std::string teachingCls, std::string teachedCls) : Ta(theName, teachingCls), sT(theName, teachedCls)
{
}

void Ts::intro()
{
    std::cout << "i m " << Ta::name << " i teach " << classes << ", and i study in " << cls << std::endl;
}
int main()
{
    Person a("a");
    Ta b("b", "middle");
    sT c("c", "base");
    Ts d("d", "base", "advance");
    a.intro();
    b.intro();
    c.intro();
    d.intro();
    std::cin.get();
    return 0;
}
