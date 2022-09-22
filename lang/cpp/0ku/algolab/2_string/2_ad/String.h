/*
 * @Author: 闫昭
 * @Date: 2020-10-22 13:26:02
 * @LastEditTime: 2020-10-27 15:48:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/2_string/2_ad/String.h
 */

/* String.h */
#ifndef String_yz
#include <iostream>
#include <vector>
class String
{
private:
    //用堆方式存储字符串，存储串的大小及串。
    int length;
    char *str;

public:
    String(char *str_, int length_);
    /**
     * @description: 查找子串
     * @param sub 子串
     * @param length 子串长度
     * @return 返回在主串中所有子串的起始位置。
     */
    std::vector<int> index(String sub);
    void print();
    int getLength();
    char charAt(int index);
    int *getNextTable();
};
#define String_yz
#endif