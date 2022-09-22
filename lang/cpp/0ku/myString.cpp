/*
 * @Author: 闫昭
 * @Date: 2020-08-31 15:59:25
 * @LastEditTime: 2020-09-09 20:22:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\myString.cpp
 */
#include <iostream>
#include <string>
using namespace std;
class MyString
{
private:
    char *myS;

public:
    MyString() //todo
    {
    }
    MyString(const char *cString)
    {
        myS = new char[sizeof(cString)]{*cString};
    }
    char at(int index) const;
    int length() const;
    void clear();
    bool empty();
    int compare(const MyString &s) const;
    int compare(int index, int n, const MyString &newS) const;
    void copy(char s[], int index, int n);
    char *data() const;
    int find(char ch) const;
    int find(char ch, int index) const;
    int find(const MyString &newS, int index) const;

    ~MyString();
};
char MyString::at(int index) const
{
    return myS[index];
}
int MyString::length() const
{
    return sizeof(myS);
}
void MyString::clear()
{
}
bool MyString::empty()
{
}
int MyString ::compare(const MyString &s) const {}
int MyString ::compare(int index, int n, const MyString &newS) const {}
void MyString::copy(char s[], int index, int n) char MyString *data() const {}
int MyString ::find(char ch) const {}
int MyString ::find(char ch, int index) const {}
int MyString ::find(const MyString &newS, int index) const {}
MyString::~MyString()
{
}
