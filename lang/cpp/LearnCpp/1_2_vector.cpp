/*
 * @Author: 闫昭
 * @Date: 2020-09-10 11:36:59
 * @LastEditTime: 2021-05-28 10:06:24
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/4_3_vector.cpp
 */
#include <vector>
#include <iostream>
#include <string>
//! what different between lib: vector & array ?
// array: fixed size

////////////////////////////////////////////////////////////////yy/
#define PRINT(x) std::cout << #x << ": " << x << std::endl;
template <typename T>
std::ostream &operator<<(std::ostream &s, const std::vector<T> &v)
{
    s.put('[');
    char comma[3] = {'\0', ' ', '\0'};
    for (const auto &e : v)
    {
        s << comma << e;
        comma[0] = ',';
    }
    return s << ']';
}
////////////////////////////////////////////////////////////////yy

using namespace std;
int main()
{
    //! init
    vector w1{"welcome to", "c"};
    vector w2{w1};                       // init with copy ctor
    vector w3(w1.begin() + 1, w1.end()); // init with iterator
    vector<string> w4(3, "c++");
    PRINT(w1); // w1: [ welcome to, c ]
    PRINT(w2); // w2: [ welcome to, c ]
    PRINT(w3); // w3: [ c ]
    PRINT(w4); // w4: [ c++, c++, c++ ]

    //! change
    w1.erase(w1.end() - 1); //! -1 must be iterator
    w1.push_back("c++");
    PRINT(w1); // w1: [ welcome to, c++ ]

    w2.insert(w2.begin() + 1, "the world of");
    PRINT(w2); // w2: [ welcome to, the world of, c ]

    w3.swap(w2);
    PRINT(w2);
    PRINT(w3);

    w4[1] = "cpp";
    PRINT(w4);
}