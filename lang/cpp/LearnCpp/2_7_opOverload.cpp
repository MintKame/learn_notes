/*
 * @Author: 闫昭
 * @Date: 2020-06-26 16:08:38
 * @LastEditTime: 2021-06-02 09:27:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\7_2_opOverload.cpp
 */
#include <iostream>
#include <cmath>
#include <exception>
#include <istream>
#include <ostream>
using namespace std;
//! value's types
// lvalue(can l or r) : func / obj whose addr can be taken
// pure rvalue        : dont' relate to obj / anonmous
// eXpiring value &&  : rvalue -> ref to rvalue (c++11)
//eg. 1. ++i    "abc"   int& f()      *p      (x = y)
//    2. i++    'a' 2   int f()       &x      (x + y)
//    3. int&& f() { return 2; }
//       ++f();    //rvalue can be use as lvalue
//! op overload must
//1. op:   not define new op (eg. a ** b
//         not overload: . .* :: ?: #
//2. data: can't: all opd are primitive, at least 1 opd is cls
//3. not change precedence and accociativity
//! op      as member func          not member func
//@a        (a).operator@ ()        operator@ (a)
//a@        (a).operator@ (dummy)   operator@ (a,dummy)
//a@b       (a).operator@ (b)       operator@ (a,b)
//must member: [], (), ->, =, ++, --
//friend     : <<, >>
//noMember   : arthmetric, compare    //  Prefered, caz symmetric
class Vec2D
{
private:
    double x{0.0};
    double y{0.0};

public:
    Vec2D() = default;
    Vec2D(double x_, double y_) : x{x_}, y{y_} {};
    string toString() const;
    //! why & :
    // pass &: efficiency pass, always add const
    // ret  &: if need lvalue
    //! binary-op                               usage
    Vec2D operator+(const Vec2D &secVec2D);   // v1 + v2
    Vec2D operator+(const double num);        // v1 + 2
    Vec2D &operator+=(const Vec2D &secVec2D); // v1 += 2
    int compareTo(Vec2D &secVec2D);
    // operator = (in cls_tor)
    //! unary-op
    Vec2D operator-();           // -v1     // can't change ret val
    Vec2D &operator++();         // ++v1
    Vec2D operator++(int dummy); // v1++
    //"dummy" to show it's postfix
    double &operator[](const int &index); // ret &, can modify
    operator double();                    //get magnitute
    //not declare ret type
    //double->Vec2D & Vec2D->double not both define
    //      otherwise compiler not know convert which ( runtime err )
    double direction() const;
    //!friend: 2 para
    friend Vec2D operator+(double num, const Vec2D &vec2d); // 2 + v1
    // << >> def in i/ostream cls, ret stream's ref (ostream << a << b)
    // why friend func: keep the order of para(stream bf obj)
    friend std::ostream &operator<<(std::ostream &os, const Vec2D &v);
    friend std::istream &operator>>(std::istream &is, Vec2D &v);
    // op can declared as friend, except a=b a[b] a->
};
string Vec2D::toString() const
{
    return string{"(" + to_string(x) + "," + to_string(y) + ")"};
}
//add
Vec2D Vec2D::operator+(const Vec2D &secVec2D)
{
    return Vec2D(x + secVec2D.x, y + secVec2D.y);
}
Vec2D Vec2D::operator+(const double num)
{
    return Vec2D{x + num, y + num};
}
Vec2D &Vec2D::operator+=(const Vec2D &secVec2D)
{
    x += secVec2D.x;
    y += secVec2D.y;
    return (*this);
}
int Vec2D::compareTo(Vec2D &secVec2D)
{
    double m1 = static_cast<double>(*this);
    double m2 = static_cast<double>(secVec2D);
    if (abs(m1 - m2) < 1E-10)
        return 0;
    else
    {
        return (m1 > m2 ? 1 : -1);
    }
}
//unary
Vec2D Vec2D::operator-()
{
    return Vec2D(x * -1, y * -1);
}
Vec2D &Vec2D::operator++() //++x
{
    ++x;
    ++y;
    return (*this);
}
Vec2D Vec2D::operator++(int dummy) //x++
{
    return Vec2D{x++, y++};
}
double &Vec2D::operator[](const int &index) // can modify member
{
    if (index != 0 && index != 1)
    {
        throw std::out_of_range("[] only accept 0 / 1 as para.");
    }
    return (index ? y : x);
}
Vec2D::operator double()
{
    return sqrt(x * x + y * y);
}
double Vec2D::direction() const
{
    return atan(y / x);
}
//friend
Vec2D operator+(const double num, const Vec2D &vec2d)
{
    return (Vec2D{vec2d.x + num, vec2d.y + num});
}
std::ostream &operator<<(std::ostream &os, const Vec2D &v)
{
    os << v.toString();
    return os;
}
std::istream &operator>>(std::istream &is, Vec2D &v)
{
    is >> v.x >> v.y; //! can auto pick up
    return is;
}
int main()
{
    //init
    Vec2D v1{3, 5}, v2{4, 6};
    cout << "v1 = " << v1.toString() << endl;
    cout << "v2 = " << v2.toString() << endl;
    // 向量加法： 向量+向量，向量+数
    Vec2D v3 = v1 + v2;
    Vec2D v4 = v3 + 10.0;
    cout << "v3 = " << v3.toString() << endl;
    cout << "v4 = " << v4.toString() << endl;
    // 向量减法，向量点积，向量数乘
    double v6 = v2 * v1;
    Vec2D v7 = 2.1 * v3;
    cout << "v2 - v1 = " << v5.toString() << endl;
    cout << "v2 . v1 = " << v6 << endl;
    cout << "v3 * 2.1 = " << (v3 * 2.1).toString() << endl;
    cout << "2.1 * v3 = " << v7.toString() << endl;

    Vec2D va1{10, 12}, va2{1, 2};
    cout << " va1 += va2 : " << (va1 += va2).toString() << endl;
    // 向量求负值
    Vec2D v8{-v2};
    cout << "-v2 = " << (-v2).toString() << endl;
    // 向量自增/自减
    cout << "++v8 = " << (++v8).toString() << endl;
    cout << "v8++ = " << (v8++).toString() << endl;
    cout << "v8 = " << v8.toString() << endl;
    cout << "--v2 = " << (--v2).toString() << endl;
    // 读取或者修改向量元素
    v1[0] = 31.1;
    cout << "v1.x = " << v1[0] << endl;
    cout << "v1.y = " << v1[1] << endl;
    //? v1[8] = 10.0;
    // 向量的长度magnitude
    cout << "double(v1) = " << static_cast<double>(v1) << endl;
    // 比较两个向量
    cout << "v1 compare v2 : " << v1.compareTo(v2) << endl;
    cout << "Please input a Vec2D:";
    Vec2D v9{};
    std::cin >> v9; // operator>>(std::cin, v9);
    cout << v9 << endl;
}