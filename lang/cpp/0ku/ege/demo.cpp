/*
 * @Author: 闫昭
 * @Date: 2020-07-22 18:42:11
 * @LastEditTime: 2020-07-22 18:55:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\demo.cpp
 */
#include <iostream>
#include <graphics.h>

int main()
{
    initgraph(400, 400, 1);
    setbkcolor(EGERGB(0, 0xFF, 0xFF));
    setcolor(BLACK);
    for (int i = 0; i < 400; i += 10)
    {
        line(10, i, 390, i);
        line(i, 10, i, 390);
    }

    getch();
    closegraph();
    return 0;
}
