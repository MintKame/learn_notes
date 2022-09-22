/*
 * @Author: 闫昭
 * @Date: 2020-09-14 10:57:19
 * @LastEditTime: 2020-09-29 19:48:14
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\8_4_propagate.cpp
 */
#include <iostream>
#include <exception>
using namespace std;

//! spend more: caz stack's change
class Exception
{
};
class Exception1
{
};
void f2()
{
    cout << "f2 - bf" << endl;
    throw(exception{});
    cout << "f2 - af" << endl;
}
void f1()
{
    //!if have exception not solve, statement after catch not exe
    try
    {
        cout << "f1 - try - 1" << endl;
        f2();
        cout << "f1 - try - 2" << endl;
    }
    catch (Exception1)
    {
        cout << "f1 - catch" << endl;
    }
    cout << "f1 - end" << endl;
}
int main()
{
    try
    {
        cout << "main - try - 1" << endl;
        f1();
        cout << "main - try - 2" << endl;
    }
    catch (Exception)
    {
        cout << "main - catch" << endl;
    }
    cout << "main - end" << endl;
}
/* f2 throw Exception
main - try - 1
f1 - try - 1
f2 - bf
main - catch
main - end
*/
        
/* f2 throw Exception1
main - try - 1
f1 - try - 1
f2 - bf
f1 - catch
f1 - end
main - try - 2
main - end
*/

/* other
main - try - 1
f1 - try - 1
f2 - bf
*/
