/*
 * @Author: 闫昭
 * @Date: 2020-07-28 10:27:10
 * @LastEditTime: 2020-07-28 12:46:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\assembler.cpp
 */
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

#define A_COMMAND 0
#define C_COMMAND 1
#define L_COMMAND 2

class parser
{
private:
    std::string iFname;
    std::string oFname;
    std::ifstream iFile;
    std::ofstream oFile;
    std::vector<std::string> allLines;
    std::string thisLine;

public:
    int current;
    parser(std::ifstream fin);
    ~parser();
    bool hasMoreCommands();
    void advance();
    int commandType(std::string currentCommand);
    void symbol(std::string s);
    void dest(std::string d);
    void comp(std::string c);
    void jump(std::string j);
};

parser::parser(std::ifstream f)
{
    std::cout << "the input filename:" << std::endl;
    std::cin >> iFname;
    iFile.open(iFname);

    std::cout << "the output filename:" << std::endl;
    std::cin >> oFname;
    oFile.open(oFname);
    while (getline(iFile, thisLine))
    {
        words.push_back(allLines);
    }
    current = -1;
}

parser::~parser()
{
    iFile.close();
    oFile.close();
}

bool parser::hasMoreCommands()
{
    if (current < allLines.max_size())
    {
        return true;
    }
    else
    {
        return false;
    }
}
void parser::advance()
{
    current++;
}

int parser::commandType(std::string currentCommand)
{
    switch (currentCommand[0])
    {
    case '@':
        return A_COMMAND;
        break;
    case '(':
        return L_COMMAND;
        break;
    default:
        return C_COMMAND;
        break;
    }
}

std::string parser::symbol()
{
    std::string tmp = 1 + allLines.at(current);
    if (commandType(allLines.at(current)) == L_COMMAND)
    {
        tmp[tmp.size() - 1] = 0;
    }
    return tmp;
}

std::string parser::dest()
{
    std::string tmp = allLines.at(current);
    int i = 0;
    for (; tmp[i] != '=' && tmp[i] != '0'; i++)
        ;
    tmp[i] = 0;
    return tmp;
}

std::string parser::comp() //!
{
    std::string tmp = allLines.at(current);
    int i = 0;
    int max = tmp.size() - 1;
    for (; i <= max; i++)
    {
        if (c == '=' || c == '0')
        {
        }
    }
    return tmp;
}

std::string parser::jump()
{
    std::string tmp;
    char c;
    for (int j = 0; tmp[j] != ';'; j++)
        ;

    return tmp;
}
/////////////////////////////////
class code
{
private:
    /* data */
public:
    code(/* args */);
    ~code();
};

code::code(/* args */)
{
}

code::~code()
{
}

/////////////////////////

int main()
{
    std::string return 0;
}