/* tool.cpp */
#include <iostream>
#include <vector>
#include <fstream>
#include "String.h"
using namespace std;

String input(char *fileName);
bool isLegal(String src, vector<String> tool);

int main()
{
    cout << "请输入广告的文件名" << endl;
    char *in;
    cin >> in;
    //根据文件名导入主串
    String src = input(in);
    //加入违法词： 电话号码，微信号，学区，大学，小学，中学，幼儿园等
    vector<String> tool = {};
    tool.push_back(String("telephone", 9));
    tool.push_back(String("wx", 2));
    tool.push_back(String("school", 6));
    //判断是否合法，若不则给出提示
    //遍历，直到在主串发现敏感词，或遍历完敏感串也没发现。
    bool isLegal = 1;
    for (String s : tool)
    {
        if (src.index(s).size() > 0)
        {
            if (isLegal == 1)
                cout << "不合法，出现: ";
            s.print();
            cout << " ";
            isLegal = 0;
        }
    }
    if (isLegal)
    {
        cout << "合法" << endl;
    }
    cout << endl;
}

/**
 * @description: 输入内容，返回一个String对象存储
 * @param fileName 输入文件名
 * @return 存储内容的对象
 */
String input(char *fileName)
{
    fstream in;
    char tmp; //逐个字符读入，临时存放字符
    char str[1000];
    int cnt = 0;
    in.open(fileName, ios::in);
    while (!in.eof())
    {
        in >> tmp;
        str[cnt] = tmp;
        cnt++;
    }
    return String(str, cnt);
}
