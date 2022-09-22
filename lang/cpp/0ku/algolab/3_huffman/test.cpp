/*
 * @Author: 闫昭
 * @Date: 2020-11-05 18:56:18
 * @LastEditTime: 2020-11-06 09:38:24
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/3_huffman/test.cpp
 */

/** test.cpp */
#include "huffman.h"
#include <iostream>
using namespace std;
int main()
{
    cout << "please input the string: " << endl;
    //  输入待传送的字符信息；
    //  根据字符的种类数和各自出现的次数建立哈夫曼树；
    string str;
    cin >> str;
    Huffman h = Huffman(str);
    cout << "the code is: " << endl;
    //  利用以上哈夫曼树求出各字符的哈夫曼编码；
    h.encode(str);
    cout << "\nplease input the code: " << endl;
    getchar();
    string code;
    cin >> code;
    cout << "the str is: " << endl;
    //  对编码信息进行翻译，即将编码信息还原成发送前的字符信息
    h.decode(code);
    cout << endl;
}
