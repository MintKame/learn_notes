/*
 * @Author: 闫昭
 * @Date: 2020-07-22 09:22:23
 * @LastEditTime: 2020-07-23 00:53:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\ege\2font.cpp
 */
#include <iostream>
#include <graphics.h>

int main()
{
    initgraph(640, 480);
    setfillcolor(EGERGB(0x0, 0x80, 0x80));

    //initialize
    setcolor(EGERGB(0x0, 0xFF, 0x0));         //font cl
    setfontbkcolor(EGERGB(0x80, 0x00, 0x80)); //font bk cl
    setfont(12, 0, "宋体");                 //font

    //1.formating
    auto tmp{50};
    xyprintf(50, 50, "%d", tmp);

    //2.
    outtextxy(100, 100, "2.1 hello");
    outtextrect(100, 120, 200, 100, "2.2\thello\nege"); //ctr is allowed

    //3.bk fill(auto:opaque)
    setbkmode(TRANSPARENT);
    outtextxy(100, 150, "3hello");

    //4.align:compare to the point
    outtextxy(300, 50, "4Hello Graphics");
    settextjustify(RIGHT_TEXT, BOTTOM_TEXT);
    outtextxy(300, 50, "4Hello Graphics");

    getch();
    closegraph();
    return 0;
}