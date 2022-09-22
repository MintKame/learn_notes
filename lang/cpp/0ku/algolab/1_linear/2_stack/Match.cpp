/*
 * @Author: 闫昭
 * @Date: 2020-10-15 13:28:21
 * @LastEditTime: 2020-10-16 21:33:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/2_stack/Match.cpp
 */
#include <iostream>
#include "Stack.h"
using namespace std;
using Type = char;

/**
 * @description: 括号匹配的检验
 * @param expr 需要检查的括号序列
 * @param size 括号个数
 * @return 检验的结果。匹配为 1，不匹配为 0
 */
int isMatched(char *expr, int size)
{
    //创造一个栈
    Stack *stack = new Stack();
    //遍历每读入一个括号
    for (int i = 0; i < size; i++)
    {
        //若是左括号，则压入栈中
        if (expr[i] == '[' || expr[i] == '(')
        {
            stack->push(expr[i]);
        }
        //若是右括号，检查是否合法
        else
        {
            //栈空则不合法
            if (stack->getSize() == 0)
            {
                return 0;
            }
            //获取当前栈顶
            char top = stack->top();
            //与当前栈顶的左括号匹配，则将当前栈顶的左括号pop
            if ((top == '[' && expr[i] == ']') || (top == '(' && expr[i] == ')'))
            {
                stack->pop();
            }
            //与当前栈顶的左括号不匹配，则不合法。
            else
            {
                return 0;
            }
        }
    }
    //有未配对的括号，非法
    if (stack->getSize() != 0)
    {
        return 0;
    }
    //删除栈
    delete stack;
    return 1;
}

void printResult(char *expr, int size)
{
    if (isMatched((char *)(expr), size))
    {
        cout << expr << " 匹配" << endl;
    }
    else
    {
        cout << expr << " 此串括号匹配不合法" << endl;
    }
}

int main()
{
    printResult("", 0);
    printResult("[", 1);
    printResult(")", 1);
    printResult("([]())", 6);
    printResult("[()]", 4);
    printResult("[(]", 3);
    return 0;
}