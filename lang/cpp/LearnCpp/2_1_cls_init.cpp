/*
 * @Author: 闫昭
 * @Date: 2020-07-25 08:15:24
 * @LastEditTime: 2021-06-28 10:20:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/4_4_cls_init.cpp
 */
#include <iostream>
#include <typeinfo>
class Circle
{
public:
    double r = 1.0; // not declare var which can be derived from other member

    std::string s1{'h', 'e'};
    std::string s2{"hello"};

    //in-Cls initialize:
    //array must have size & not auto
    double pi{3.14};

    //! static
    // declare
    static int totalShape;
    // must init out cls (or link err)
    // (except constexpr
    static constexpr double pii{3.14}; //must init in cls

    // visit
    // ClassName::
    //      rather than objName.(readable)

public:
    //! init list:
    Circle() : r{1.0}
    {
        r = 1.0; // default
        totalShape++;
    }
    // order:  init:   default - list
    //         assign: in ctor
    //  if have init-list, not exe default

    //! if an obj has a member obj
    // must init inner obj bf outter, using list init
    //      if no list for inner, auto call default ctor of inner obj
    //          if no default ctor -> error. because can't init in ctor
    Circle(double r)
    {
        this->r = r; // avoid ambiguilty, this(keyword) point to the obj
                     // another way: para's name add tail: _
    }

    //use getter & setter
    static int getTotalShape()
    {
        return totalShape;
    }
    Circle &setRadius(int r);
    double getArea() const;
};
int Circle::totalShape = 0;

//! const func: not change data
//how: "const" after declare & define
//no static & const func,caz static func doesn't have "this ptr"
//must: if para is declared const, the called cls func must be const

double Circle::getArea() const
{
    return (3.14 * r * r);
}
Circle &Circle::setRadius(int r)
{
    this->r = r;
    return (*this);
}

int main()
{
    //! obj init
    // no para
    Circle c11;
    Circle c12{}; // recommend
    Circle c13(); // err (func call)
    // with para
    Circle c2{2};
    auto c3 = c2;        //copy
    auto c4 = Circle{3}; //copy an anony obj

    // heap
    Circle *c5 = new Circle{};
    Circle *cc3 = new Circle[3]{2, 4, {}}; // ptr to 1st obj in arr
    delete c5;
    delete[] cc3;

    //! cls func
    std::cout << c11.getArea() << std::endl;
    std::cout << Circle{4}.getArea() << std::endl;
    std::cout << Circle::getTotalShape() << std::endl; // static func: both class & obj can visit
    std::cout << c11.getTotalShape() << std::endl;
    std::cin.get();
    return 0;
}
void printCircle(const Circle &c)
{
}
//! pass obj to func:
//by val: need copy & more memory
//by ref: efficient (no obj copy
//      + const : when no change

//! ret obj:
//  reted obj should be para / global
//  in func, not create then ret obj's ptr / ref,
//         caz stack auto destroy after the func