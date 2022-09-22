/*
 * @Author: 闫昭
 * @Date: 2020-07-30 01:18:38
 * @LastEditTime: 2021-06-28 10:31:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\5_encaps.cpp
 */
#include <iostream>

//!concepts's diff
//abstract: focus on ...
//encapsu:  limit visitable

//! how to immutable (only can change by self)
//1. data: all private
//2. no setter
//3. getter not return ptr / ref
//why:
//  thread-safe
enum class Gender
{
    male,
    female,
};

class Date
{
    //! 3-level access
    //private  (default):   this cls
    //protected(decendant): this cls || its child
    //public:               all
private:
    int year;
    int month;

public:
    int day;
    Date() {}
    Date(int year, int month, int day)
    {
        this->day = day;
        this->month = month;
        this->year = year;
    }
    //! friend of cls A:
    //  friend can be cls / func
    //  can visit all member of A
    friend class Employee;
    friend void print(const Date &d);
    // dis: break the encapsulation
    // use: write lib, op overload need friend (eg. >> , need obj at right position)
};
class Employee
{
private:
    std::string name;
    Gender gender;
    Date birthday;

public:
    Employee(std::string n, Gender g, Date b)
    {
        birthday = b;
        name = n;
        gender = g;
    }
    Gender getGender() { return gender; };
    Date *getBirthday() { return &birthday; }
    //! not immu : ret ptr, can be changed
    void showEmployee()
    {
        std::cout << name << std::endl;
        std::cout << birthday.year << ' ' << birthday.month << ' ' << birthday.day << std::endl;
    }
    void visitFriend() //! friend cls
    {
        std::cout << birthday.year << birthday.month << birthday.day << std::endl;
    }
};

void print(const Date &d) //! friend func
{
    std::cout << d.year << d.month << d.day << std::endl;
}

int main()
{
    Employee a{"a", Gender::female, Date{2001, 5, 1}};
    a.showEmployee();
    std::cout << a.name; // err: can't visit private var
    //!immu : changed - using getter
    Date *d = a.getBirthday();
    d->day = 0;
    a.showEmployee();
    std::cin.get();
    return 0;
}