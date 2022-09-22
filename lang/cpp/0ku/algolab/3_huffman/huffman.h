/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-05 21:57:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/3_huffman/huffman.h
 */
/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-05 19:29:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /algolab/3_huffman/huffman.h
 */
/** huffman.h */
#ifndef HFM_YZ
#define HFM_YZ
#include <string>
#include <iostream>
using namespace std;
class Tree
{
public:
    char data;
    int cnt = 0;

    Tree *left = nullptr;
    Tree *right = nullptr;
    Tree() = default;
    Tree(int cnt);
    Tree(char data, int cnt);
    char getData();
    int compareTo(Tree *t);
    // 利用哈夫曼树求出各字符的哈夫曼编码
    string getCode(string str, char c);
};

class Huffman
{
public:
    Tree *tree;
    int cnt[256] = {};
    Huffman(string str);
    // 将字符信息转换成对应的编码信息
    void encode(string str);
    // 将编码信息还原成发送前的字符信息。
    void decode(string str);

private:
    // 统计字符信息中出现的字符种类数和各字符出现的次数（频率）；
    void cntChar(string str);
    // 根据字符的种类数和各自出现的次数建立哈夫曼树；
    void createTree();

    void static preorder(Tree *tree)
    {
        if (tree == nullptr)
            return;
        cout << "a node: " << tree->data << " times: " << tree->cnt << endl;
        preorder(tree->left);
        preorder(tree->right);
    }
};
#endif