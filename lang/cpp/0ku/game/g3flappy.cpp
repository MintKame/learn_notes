/*
 * @Author: 闫昭
 * @Date: 2020-07-10 12:08:37
 * @LastEditTime: 2020-07-22 09:45:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\0ku\game\g3flappy.cpp
 */
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#define SPED 2

//multi column

/**
 * @description: refresh
 */
void gotoxy(int x, int y)
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
    int b_y; //bird position
    int c_x; //colum position
    int c_y;
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
    score = 0;
    w_x = 40;
    w_y = 20;
    b_y = w_y / 2;
    c_x = w_x - 1;
    c_y = rand() % (w_y - 10) + 5;
    hideCursor();
}

void win::update_auto()
{
    //bird move
    b_y += SPED;
    //
    c_x--;
    if (c_x == -1)
    {
        c_y = rand() % (w_y - 10) + 5;
        c_x = w_x - 1;
    }
    Sleep(200);
}

void win::update_ctr()
{
    if (kbhit())
    {
        switch (getch())
        {
            //bird move up
        case ' ':
            b_y -= 2 * SPED;
            if (b_y < 0)
            {
                b_y = 0;
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
            if ((x == 2) && (y == b_y)) //bird
            {
                std::cout.put('p');
            }
            else if ((x == c_x) && abs((int)(y - c_y)) > 2) //platform
            {
                std::cout.put('|');
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
    //bird arrives bottom
    if (b_y == w_y || (abs(b_y - c_y) > 2 && c_x == 2))
    {
        return -1;
    }
    //in range
    else if (abs(b_y - c_y) <= 2 && c_x == 2)
        score++;
    else
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