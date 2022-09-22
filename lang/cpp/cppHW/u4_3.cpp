/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 21:39:26
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u4_3.cpp
 */
#include <iostream>
#include <array>
#define PI 3.14

class Circle
{
private:
    double radius;

public:
    Circle();
    Circle(double radius);
    double getArea();
};

Circle::Circle()
{
    radius = 1.0;
}
Circle::Circle(double radius)
{
    this->radius = radius;
}
double Circle::getArea()
{
    return (PI * radius * radius);
}
int main()
{
    double sum{0};
    std::array<Circle, 10> c{1.0, 2.0, 3.0, 4.0, 5.0};
    for (int i = 0; i < 10; i++)
    {
        sum += c[i].getArea();
    }
    std::cout << sum;
    std::cin.get();
    return 0;
}