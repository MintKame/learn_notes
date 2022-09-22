/*
 * @Author: 闫昭
 * @Date: 2020-07-31 19:17:27
 * @LastEditTime: 2020-07-31 22:06:58
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\u4_4.cpp
 */
#include <iostream>
//! problem 
class Screen
{
private:
    int height;
    int width;

public:
    Screen();
    Screen(int width, int heigth);
    int getWidth();
    int getHeight();
    int setWidth(int width);   //return width
    int setHeight(int height); //return height
};

Screen::Screen(int width, int heigth)
{
    this->height = height;
    this->width = width;

    std::cout << "screen" << std::endl;
}
Screen::Screen()
{
    this->height = 480;
    this->width = 640;
    std::cout << "screen" << std::endl;
}
int Screen::getWidth()
{
    return width;
}
int Screen::getHeight()
{
    return height;
}
int Screen::setWidth(int width) //return width
{
    this->width = width;
    return width;
}
int Screen::setHeight(int height) //return height
{
    this->height = height;
    return height;
}
int main()
{
    int width, height;
    std::cin >> width >> height;

    Screen screen1{width, height};
    Screen screen2;

    screen2.setWidth(800);
    screen2.setHeight(600);

    std::cout << screen1.getWidth() << ' ' << screen1.getHeight() << std::endl;
    std::cout << screen2.getWidth() << ' ' << screen2.getHeight();

    std::cin.get();
    std::cin.get();
    std::cin.get();
    std::cin.get();
    return 0;
}