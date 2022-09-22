/*
 * @Author: 闫昭
 * @Date: 2020-07-22 09:20:14
 * @LastEditTime: 2020-07-22 11:06:35
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\3cut.cpp
 */
#include <iostream>
#include <graphics.h>

int main()
{
    initgraph(1000, 1000);

    setviewport(200, 100, 330, 200, 1); //set vp

    setcolor(EGERGB(0x0, 0xFF, 0x0));
    setfontbkcolor(RGB(0x80, 0x00, 0x80));
    setfont(18, 0, "宋体");
    outtextxy(0, 0, "1Hello EGE Graphics");

    setbkmode(TRANSPARENT);
    outtextxy(0, 20, "2Hello EGE Graphics");

    setviewport(0, 0, getwidth(), getheight(), 1); //recover vp
    outtextxy(0, 0, "3Hello EGE Graphics");

    getch();
    closegraph();
    return 0;
}