/*
 * @Author: 闫昭
 * @Date: 2020-07-15 13:45:34
 * @LastEditTime: 2020-07-22 16:28:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\ege\1graph.cpp
 */
#include <iostream>
#include <graphics.h>
int main()
{
    initgraph(1000, 1000);
    setbkcolor(EGERGB(0x40, 0x0, 0x0)); //bkcl:dark red

    //hollow
    setcolor(GREEN);        //cl:green
    line(0, 0, 1000, 1000); //0

    //solid
    setfillcolor(EGERGB(0x0, 0x0, 0x40)); //fcl:dark blue
    bar(10, 10, 50, 50);                  //0
    fillellipse(200, 200, 150, 100);      //1
    circle(500, 300, 100);                //2
    floodfill(500, 300, GREEN);           //fcl,edge is green

    getch(); //press and change bkcl
    setbkcolor(EGERGB(0x0, 0x40, 0x0));

    getch();
    closegraph();
    return 0;
}
