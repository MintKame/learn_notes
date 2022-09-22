#include <iostream>
#include <vector>
#include <stdio.h>
#include <string>
using namespace std;

class String
{

private:
    //用堆方式存储字符串，存储串的大小及串。
    int length;

public:
    char *str;
    String(const char *str_, int length_);

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
String::String(const char *str_, int length_)
{
    length = length_;
    str = new char[length];
    for (int i = 0; i < length; i++)
    {
        str[i] = str_[i];
    }
}

void String::print()
{
    cout << str << endl;
}

int String::getLength()
{
    return length;
}
char String::charAt(int index)
{
    if (index < length && index >= 0)
        return str[index];
    else
        return 0;
}

//构造next表
int *String::getNextTable()
{
    int *next = new int[getLength() + 1]; // + 1 因为最后一个为匹配时，寻找下一个子串要回溯的位置
    next[0] = -1;                         //首个设置为-1
    //遍历每个字符
    for (int i = 1; i <= getLength(); i++)
    {
        next[i] = 0;
        //匹配之前字符的前后缀
        int cnt = i - 1; //记录公共的长度,初始化为最大
        for (; cnt > 0; cnt--)
        {
            int flag = 1;       //记录前后是否相同
            int prior = 0;      //当前比较的前缀字符的下标
            int post = i - cnt; //当前比较的后缀字符的下标
            for (; prior < cnt; prior++, post++)
            {
                //出现不匹配，改flag，退出循环尝试新公共长度
                if (charAt(prior) != charAt(post))
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) //找到最长公共前后缀
            {
                next[i] = cnt;
                break;
            }
        }
        // cout << "next " << i << " " << next[i] << endl;
    }
    return next;
}

//求出 sub 所有出现的位置。
vector<int> String::index(String sub)
{
    //初始化结果数组
    vector<int> ret;
    //构造next表
    int *next = sub.getNextTable();
    int src_index = 0, sub_index = 0; //记录当前比较位置
    //遍历主串，与子串比较字符
    //由于主串最后部分可能与子串匹配，src_index == length时仍循环，从而判断
    for (; src_index <= length; src_index++, sub_index++)
    {
        if (sub_index == -1)
        {
            continue;
        }
        //找到一个匹配
        if (sub_index == sub.getLength())
        {
            ret.push_back(src_index - sub_index);
            sub_index = next[sub_index];
        }
        //不同则回溯
        while (src_index != length &&
               sub.charAt(sub_index) != charAt(src_index) &&
               sub_index != -1)
        {
            sub_index = next[sub_index];
        }
    }
    // delete next;
    return ret;
}

int main()
{
    /*
    char a[100005] = {0};
    char b[100005] = {0};
    int index = -1;
    do
    {
        index++;
        scanf("%c", &a[index]);
    } while (a[index] != '\n');
    index = -1;
    do
    {
        index++;
        scanf("%c", &b[index]);
    } while (b[index] != '\n');
*/
    string a, b;
    cin >> a >> b;
    String src = String(a.c_str(), a.size());
    String sub = String(b.c_str(), b.size());
    vector<int> pos = src.index(sub);
    for (int i = 0; i < pos.size(); i++)
    {
        cout << pos[i] + 1 << endl;
    }

    int *next = sub.getNextTable();
    for (int i = 1; i < sub.getLength() + 1; i++)
    {
        cout << next[i] << " ";
    }
}