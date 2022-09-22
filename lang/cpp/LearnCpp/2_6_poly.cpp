/*
 * @Author: 闫昭a
 * @Date: 2020-06-26 16:08:38
 * @LastEditTime: 2021-06-28 10:38:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\7_1_poly.cpp
 */
#include <iostream>
using namespace std;
//! poly:
//    1. child pass as super type
//          need: pass ptr/ref, else value will trans to para's type (parent type)
//    2. (override) call obj's which member func:
//          depends on actual type, if not define in child, call nearst parent's func
//! how to override:
class Parent
{
public:
    //! virtual func
    // "virtual" only added to parent's func, child auto become virtual
    virtual void ovr() { cout << "P::or()" << endl; }
    virtual void ovr(int a) { cout << "P::or(int)" << endl; }
    void nh() { cout << "P::nh()" << endl; }
    void nh(int a) { cout << "P::nh(int)" << endl; }
};

// abs cls's can't create instance
// abs cls's parent no need to be abs
class AbsCls
{
    //! pure virtual func -> abstract cls
    virtual void pvFun() = 0; //not implement in parent
    // child must: implement "pv-func" / become abstract

    //! in parent, dtor always virtual
    // to avoid (child dtor not called)
    virtual ~AbsCls() {}
};

class Child final : public Parent
{
public:
    void ovr() final override
    //! keyword:
    // "final" - cls/fun cant' be override
    // "override"  must virtual && child override parent && use in cls define:
    //      prevent mispell child's func, which may call nearst super's func
    {
        cout << "C::or()" << endl;
    }
    void nh() { cout << "C::nh()" << endl; }
};
int main()
{
    Parent *pRefC = new Child{}; //poly
    Child *cRefC = new Child{};
    //! steps:
    // compile: check dType & d-super has func
    //          but, if   d & d-super has same-name fun, hide super's ( even para not same)
    // run-time:    virtual -> check aType   (dynamic binding)
    //          not-virtual -> call  dType's (static)
    pRefC->nh();   //p
    pRefC->nh(1);  //p
    pRefC->ovr();  //c
    pRefC->ovr(1); //p

    cRefC->nh();  //c
    cRefC->ovr(); //c
    //cRefC->nh(1);
    //cRefC->ovr(1);

    ((Parent *)cRefC)->nh(1);

    //! how diff handle to diff sub-type (java: instanceOf)
    // s1: if(typeid(pRefC) == typeid(Child))
    // s2: try dynamic_cast to sub (2 ways ptr / ref)
    // 1. ptr
    Child *c1 = dynamic_cast<Child *>(pRefC);
    if (c1 != nullptr)
        ; // cast success
    // 2. ref
    try
    {
        Parent &p = *pRefC; // ref
        Child &c2 = dynamic_cast<Child &>(p);
        // exe if success
    }
    catch (bad_cast ex) // cast fail
    {
    }
    //! cast between parent and child:
    //  child can tunacate, parent can't

    delete pRefC;
    delete cRefC;
}