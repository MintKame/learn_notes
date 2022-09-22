/*
 * @Author: 闫昭
 * @Date: 2020-09-09 19:02:44
 * @LastEditTime: 2021-06-28 10:30:33
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\4_5_cls_tor.cpp
 */
#include <iostream>
using namespace std;
class Student
{
private:
    static int totalNumber;
    string name;
    int xy[2]{1, 2}; // position
    // arr: not auto, must give size
public:
    //! func declared in class -> inline

    //! default ctor
    // should always have
    // no para / all para have default val
    // generate by compiler if no ctor defined
    Student()
    {
        totalNumber++;
    };

    //! delegate ctor
    // must call super/self's ctor in list
    // can't in func
    //          cmp:   java must first line of func
    Student(int x_, int y_, string name_) : Student()
    {
        name = name_;
        xy = new int[2]{x_, y_};
    }
    Student(int age) // not delegate, create an anoy in func
    {
        Student();
    }

    //! copy ctor
    Student(const Student &old, string name_ = "newStudent");

    //! assign op
    Student &operator=(const Student &student);

    //! dtor
    // only 1, can't overload
    // default do nothing
    //usage:
    //  free the variable allocated in ctor
    //  dec the total size(static var)...
    ~Student()
    {
        delete xy;
        totalNumber--;
    }
    //~Student() = default
    //~Student() = delete   // means: no default dtor;
};
Student a(0, 0, "a"), b;

////////////////////////////////////////////////
//!copy (2 types)
//1.shallow (2 types)
//  1.1.default copy ctor:
//          generate by compiler if not define, just copy each field
//          Student::Student(const Student &old) = default;
//
//  1.2.assign (if not overload op=)
//          just assign, not create new obj
//
//  problem: a member var is ptr
//           after copy, point to the same addr

//2.deep
//  2.1.customize copy ctor: define ClsName(const ClsName& clsName);
//     how: if a member var is ptr
//          then allocate member, copy data(not add)
//
//  2.2.assign (overload =)
//     how: if a member var is ptr
//          then copy data to owns member (already allocated, ? add)

//eg. call which func ? copy-ctor or op=
//      Student s1 = s2            copy ctor
//      Student s1 = Student(s2)   copy ctor
//      s1 = s2                    op=
// depend on: whether is define a new obj  ?

// eg.
//! copy ctor, = , dtor: must customize!
// recommand: pass src obj as const ref (& fast, const avoid change)
// src obj at 1st, other para must have default value
// default para can't be declared both in func's declare and define
Student::Student(const Student &student, string name_)
{
    name = name_;
    xy = new int[2]{student.xy[0], student.xy[1]}; //! ptr type member
    totalNumber++;
}

// assign op =
//  why ret ref ?
//      to support (s1 = s2) = s3
Student &Student::operator=(const Student &student)
{
    this->name = student.name;   // same as default =
    *(this->xy) = *(student.xy); //! deep copy
    // diff with copy ctor:
    //      not new xy: already alocated in ctor when init
    //              (self-def member cls)
    //      don't increase totalNum (same reason)
    return (*this);
}
Student d = a, *c = new Student{a, "cc"};
//////////////////////////////////////////////////////////
int Student::totalNumber = 0;

int main()
{
    //! what's diff
    Student s0{1, 2, "yz"};
    Student s1 = {1, 2, "yz"};
    Student s2 = Student{1, 2, "yz"};
    // 0, 1: list initialize
    //    2: list init the anoy obj
    //       then copy ctor
    // aray
    Student sa0[]{{}, {}, {4, 5, "a"}};                      // list init
    Student sa1[]{Student{}, Student{}, Student{4, 6, "b"}}; // create anoy, copy

    return 0;
}