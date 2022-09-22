/*
 * @Author: 闫昭
 * @Date: 2020-08-31 15:59:25
 * @LastEditTime: 2020-09-11 19:42:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\tmp.cpp
 */
#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector words{"write", "that", "string", "zoe"};
class Hangman
{
private:
    string ans;
    string result;
    int size;
    char input;
    int missed{0};
    void print() const;
    void read();
    void change();
    bool isFinished() const;
    void gameOver() const;

public:
    Hangman();
};
Hangman::Hangman()
{
    bool cont = 1;
    while (cont)
    {

        ans = words[rand() % words.size()];
        size = ans.size();
        result.clear();
        result.append(size, '*');
        while (!isFinished())
        {
            print();
            read();
            change();
        }
        gameOver();
        cin >> cont;
    }
}

void Hangman::print() const
{
    string tmp{ans};
    cout << "(Guess) Enter a letter in word " << result << " > ";
}
void Hangman::read()
{
    cin >> input;
}
void Hangman::change()
{
    int tmpAns = ans.find(input);
    int tmpRes = result.find(input);
    if (tmpAns == string::npos && tmpRes == string::npos)
    {
        missed++;
        cout << "\t" << input << " is not in the word" << endl;
    }
    else if (tmpAns == string::npos && tmpRes != string::npos)
    {
        missed++;
        cout << "\t" << input << " is already in the word" << endl;
    }
    else
    {
        result[tmpAns] = input;
        ans[tmpAns] = '*';
    }
}
bool Hangman::isFinished() const
{
    return !(result.find('*') != string::npos);
}
void Hangman::gameOver() const
{
    cout << "The word is " << result << " You missed " << missed << " time." << endl;
    cout << "\nDo you want to replay? 1 for yes,0 for no" << endl;
}

int main()
{
    Hangman game; //todo rand words
    return 0;
}