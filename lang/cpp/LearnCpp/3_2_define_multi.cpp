/*
 * @Author: 闫昭
 * @Date: 2020-09-13 13:55:27
 * @LastEditTime: 2021-06-28 10:43:35
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\8_2_define_multi.cpp
 */
#include <iostream>
#include <exception>
#include <stdexcept>
using namespace std;

//! use which: better predefined than creating
//  why extends stdex?
//      to overload what(), not must extend
class NotPositive : public logic_error
{
private:
    double side;

public:
    // super except only call in list
    NotPositive(double side) : logic_error("Not positive.")
    {
        this->side = side;
    }
    double getSide() { return side; }
};

class InvalidTri : public logic_error
{
private:
    double side1, side2, side3;

public:
    InvalidTri(double side1, double side2, double side3) : logic_error("Not invalid.")
    {
        this->side1 = side1;
        this->side2 = side2;
        this->side3 = side3;
    }
};

//! use defined ex
class Triangle
{
private:
    double side1{1}, side2{1}, side3{1};

public:
    Triangle() = default;
    Triangle(double side1, double side2, double side3)
    {
        //! detect & throw exception
        checkSingle(side1);
        checkSingle(side2);
        checkSingle(side3);
        checkTogether(side1, side2, side3);

        this->side1 = side1;
        this->side2 = side2;
        this->side3 = side3;
    }
    void setSide1(double side1)
    {
        checkSingle(side1);
        checkTogether(side1, side2, side3); //1 is para, 23 are obj's member

        this->side1 = side1;
    }
    // modeling detect % throw
    void checkSingle(double side)
    {
        if (side <= 0)
            throw NotPositive(side);
    }
    void checkTogether(double side1, double side2, double side3)
    {
        if ((side1 + side2 <= side3) || (side3 + side2 <= side1) || (side1 + side3 <= side2))
            throw InvalidTri(side1, side2, side3);
    }
};

int main()
{
    double side1, side2, side3;
    cin >> side1 >> side2 >> side3;
    try
    {
        Triangle t(side1, side2, side3);
    }
    //! catch multi ex: order ?
    // child bf parent
    catch (NotPositive &e)
    {
        cout << e.getSide() << " is not positive" << endl;
    }
    catch (InvalidTri &e)
    {
        cout << e.what() << endl;
    }
    catch (exception &e)
    {
        cout << e.what() << endl;
    }
    catch (...) //! all sorts of exceptions
    {
        cout << "all other exceptions" << endl;
    }
}