/*
 * @Author: 闫昭
 * @Date: 2020-07-10 12:08:37
 * @LastEditTime: 2020-07-22 09:44:09
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\0ku\game\g2ball.cpp
 */
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#define MAX 5

//multi block

/**
 * @description:refresh 
 */
void gotoxy(short x, short y)
{
    COORD pos = {x, y};
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(hOut, pos);
}

/**
 * @description: hide cursor
 */
void hideCursor()
{
    CONSOLE_CURSOR_INFO cursor_info = {1, 0};
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);
}

class win
{
private:
    int w_x; //window size
    int w_y;
    int b_x; //ball position
    int b_y;
    int p_l; //platform
    int p_r;
    int p_y;
    int b_vx; //ball velocity
    int b_vy;
    int score; //

public:
    win(/* args */);
    void show();
    void update_auto();
    void update_ctr();
    int judge();
};

win::win(/* args */)
{
    std::cout << "press to start" << std::endl;
    std::cin.get();
    score = 0;
    w_x = 20;
    w_y = 20;
    b_x = 2;
    b_y = rand() % (w_y - 1) + 1;
    b_vx = 1;
    b_vy = 1;
    p_y = w_y - 1;
    p_l = w_x / 2 - 3;
    p_r = w_x / 2 + 3;
    hideCursor();
}

void win::update_auto()
{
    //ball move
    b_x += b_vx;
    b_y += b_vy;
    //change direction
    if (b_y == 1 || b_y == p_y - 1)
    {
        b_vy *= -1;
    }
    if (b_x == 1 || b_x == w_x - 1)
    {
        b_vx *= -1;
    }
    Sleep(100);
}

void win::update_ctr()
{
    if (kbhit())
    {
        switch (getch())
        {
            //ball move up
        case 'a':
            if (p_l > 1)
            {
                p_l--;
                p_r--;
            }
            break;
            //ball move down
        case 'd':
            if (p_l < w_y - 1)
            {
                p_l++;
                p_r++;
            }
            break;
        }
    }
}

void win::show()
{
    gotoxy(0, 0);
    for (size_t y = 0; y <= w_y; y++)
    {
        for (size_t x = 0; x <= w_x; x++)
        {
            if (((x == 0) || (x == w_x)) && y > 0) //border
            {
                std::cout.put('|');
            }
            else if ((y == 0) || (y == w_y))
            {
                std::cout.put('_');
            }
            else if ((x == b_x) && (y == b_y)) //ball
            {
                std::cout.put('o');
            }
            else if ((y == p_y) && (x >= p_l) && (x <= p_r)) //platform
            {
                std::cout.put('*');
            }
            else
            {
                std::cout.put(' ');
            }
        }
        std::cout.put('\n');
    }
    //print score
    std::cout << "score:" << score << std::endl;
}

int win::judge()
{
    //ball arrives bottom
    if (b_y == p_y - 1)
    {
        //in range
        if (b_x <= p_r && b_x >= p_l)
            score++;
        //out range
        else
            return -1;
    }
    return 0;
}

int main()
{
    win w;
    int flag = 0;
    while (1)
    {
        w.update_ctr();
        w.update_auto();
        w.show();
        flag = w.judge();
        if (flag == -1)
        {
            std::cout << "You lose" << std::endl;
            break;
        }
    }
    system("pause");
    std::cin.get();
    std::cin.get();
    std::cin.get();
    std::cin.get();
    return 0;
}