/*
 * @Author: 闫昭
 * @Date: 2020-09-10 15:12:22
 * @LastEditTime: 2021-06-28 10:37:20
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\6_inherit.cpp
 */
#include <iostream>
#include <string>
#include <array>
using namespace std;

enum class Color
{
    black,
    white,
};

class Shape
{
private:
    Color shapeColor{Color::white};

public:
    Shape() = default;
    Shape(Color color_) : Shape() { shapeColor = color_; }
    Color getColor() const // const func: not change member var
    {
        return shapeColor;
    }
    void setColor(Color color_) { shapeColor = color_; }
    string toString()
    {
        return "a " + (shapeColor == (Color::white) ? "white" : "black") + " shape.";
    }
};

//! 3 ways to inherit               visible in super        sub be access by else
// class Circle : public Shape                              same as super
// class Circle : protect Shape     public, protect         protect
//                                  private                 private
//
// class Circle : private Shape     public, protect,private private
//! not influence:
// sub can access public/protect func in super
class Circle : private Shape
{
private:
    double radius{1.0};

public:
    //! can't inherit what:
    // dtor && friend

    //! func of same name in p and c:
    //in p: void func(){}
    //in child:
    //      void func(int i){}
    //          diff para: name hide
    //      void func(){}
    //          same para: redefine (1 usage of name hide)
    //      solve name hide:
    //          1. to inherit from parent, in child:
    //              using P::func;
    //          2. not inherit, just call
    //              c.P::func();

    using Shape::Shape;

    Circle(double radius_, Color color_) : Shape(color_)
    {
        radius = radius_;
    }
};

int main()
{
    Circle a{Color::black};
    Circle b{2.0, Color::black};
}