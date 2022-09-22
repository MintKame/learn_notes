/*
 * @Author: 闫昭
 * @Date: 2020-07-30 13:12:27
 * @LastEditTime: 2021-05-28 10:29:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/LearnCpp/4_2_str.cpp
 */
#include <iostream>
#include <string>
using namespace std::string_literals;
int main()
{
    //! ctor
    std::string s0;
    std::string s5{"welcome to cpp"};
    std::string s10{'a', 'b', 'c'};
    char tmp[3]{'a', 'b', 'c'};
    std::string s11{tmp};

    //! how to read a string with space ?
    // can't use >>
    const int MAXSIZE = 10;
    char deli = '\n'; //default is '\n'
    char a0[MAXSIZE];
    std::cin.getline(a0, MAXSIZE, deli);

    //! str msg
    s5.at(1);      //'e'
    s5.length();   //14
    s5.capacity(); //15

    //! find
    s5.find("co");                 //3  (ret position)
    std::cout << s5.find("co", 6); //string::npos(not found)
    s5.find('o');                  //4
    s5.find('o', 6);               //9

    //! orig str +
    // append / assign : where ; how many
    s0 + s0;
    s0 = {"hello "};     //hello 012345
    s0.append("012345"); //0 all

    s0 = {"hello "};        //hello 012
    s0.append("012345", 3); //0 three

    s0 = {"hello "};           //hello 34
    s0.append("012345", 3, 2); //3 two

    s0 = {"hello "}; //hello 0000
    s0.append(4, '0');

    //insert / replace
    s0 = {"abcd"};
    s0.insert(1, "++");    //"a++bcd"
    s0.insert(1, 4, '-');  //"a----++bcd"
    s0.replace(4, 2, "*"); //"a---*+bcd"
    std::cout << s0 << std::endl;

    //! orig str -
    // erase,empty,clear
    std::string s1{s0}; //"hello "
    s1.erase(1, 2);     //"hlo "
    s1.empty();         //isEmpty
    s1.clear();
    // generate from str
    std::string s4{"hello world"};
    s4.substr(3);    //"lo world"
    s4.substr(3, 3); //"lo "

    //! compare
    std::string s2{"cat"};
    std::string s3{"can"};
    s2.compare(s3);                       //'t' - 'n'
    s3.compare(s2);                       //'n' - 't'
    std::cout << (s2 == s3) << std::endl; //0
    std::cout << (s2 != s3) << std::endl; //1
    std::cout << (s2 > s3) << std::endl;  //1
    std::cout << (s2 < s3) << std::endl;  //0

    //! trans
    std::string s8{"123"};
    int is8 = std::stoi(s8);
    std::string sis8 = std::to_string(is8);

    //! String Literals
    const char *ss1{R"delim(1
    23)delim"};                // delim can be any other word
    const char *ss2 = "1\n23"; // same as before

    //c++ 14: implie with op overload
    auto ss3 = "ab\0\0cd"s; //string        out: ab  cd  //! std=c++17
    auto ss4 = "ab\0\0cd";  //const char*   out: ab

    std::string s1 = "Hello\0World";
    auto s2 = "Hello\0World"s;
    std::cout << s1.size() << '\t' << s2.size(); // 5 11
}