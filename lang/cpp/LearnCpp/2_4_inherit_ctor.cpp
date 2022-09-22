/*
 * @Author: 闫昭
 * @Date: 2020-09-10 15:12:22
 * @LastEditTime: 2021-06-28 10:34:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\6_inherit.cpp
 */
#include <iostream>
#include <string>
#include <array>
using namespace std;

enum class Color //! enum: used by "Color::black"
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
};

class Circle : private Shape
{
private:
    double radius{1.0};

public:
    //! ctor in child (3 ways)
    //! 2. inherit all ctors
    using Shape::Shape;
    /*  same as:
    
    Circle() : Shape() {}
    Circle(Color color_) : Shape(color_) {} //! delegate pass same para
    
    (for each ctor in parent)
    */

    //! 1. explictly defined
    // must call parent's ctor
    //      recommand: explictly call p's ctor in init list
    //      else, auto call p's default ctor
    Circle(double radius_, Color color_) : Shape(color_)
    {
        radius = radius_;
    }
    Circle(double radius_) // same as: Circle(double radius_) : Shape()
    {
        radius = radius_;
    }

    //! 3. not define ctor in child
    /* compiler generate child's default ctor, this ctor call parent's default ctor

    Circle() : Shape(){}

    */

    //! if all 3 ways exist, call which
    // priority high to low: 1-3

    //! call func in chain
    // ctor: parent > embeded obj > this
    //       (orders in init-list not matters)
    // dtor: this   > embeded obj > parent
    //      so, sub's dtor only need to destroy dynamic mem in child, not consider parent
    double getRadius() const { return radius; }
    double getArea() const { return 3.14 * radius * radius; }
    void setRadius(double radius_) { radius = radius_; }
};

int main()
{
    Circle a{Color::black}; // ctor inherited from super
    Circle b{2.0, Color::black};
    // func called in order:
    //     Shape()
    //     Shape(color)
    //     Circle(double radius, Color color)
}