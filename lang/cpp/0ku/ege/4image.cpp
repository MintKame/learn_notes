/*
 * @Author: 闫昭
 * @Date: 2020-07-22 09:20:14
 * @LastEditTime: 2020-07-22 13:07:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\4image.cpp
 */
#include <iostream>
#include <graphics.h>

int main()
{
    initgraph(1000, 1000);

    //make pimage obj
    PIMAGE img;
    img = newimage();            //delimage
    getimage(img, 0, 0, 80, 60); //cut from bk
    setbkcolor(EGERGB(0x80, 0x80, 0x80));

    //paint on the image
    setfillcolor(EGERGB(0x0, 0x70, 0x0), img); //fill cl
    sector(15, 15, 0, 90, 5, 5, img);

    cleardevice();

    //put image
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            //putimage(i * 80, j * 60, img);
            //putimage(i * 80, j * 60, 80, 60, img, 0, 0, 160, 120);//scale
        }
    }

    //4-transparency compare
    putimage(0, 0, img);
    putimage_alphablend(NULL, img, 160, 0, 0x80);               //transparency为0x80
    putimage_transparent(NULL, img, 0, 80, BLACK);              //transparent,BLACK ->bk
    putimage_alphatransparent(NULL, img, 160, 80, BLACK, 0xA0); //transparent & alpha

    delimage(img); //a!

    getch();
    closegraph();
    return 0;
}