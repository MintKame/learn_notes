/*
 * @Author: 闫昭
 * @Date: 2020-07-10 12:08:37
 * @LastEditTime: 2020-07-22 09:43:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\0ku\game\g1fly.cpp
 */
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#define MAX 5
#define w_x 20 //window size
#define w_y 20
#define f_x 10 //fly position
#define f_y 15

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
 * @description: hideCursor
 */
void hideCursor()
{
    CONSOLE_CURSOR_INFO cursor_info = {1, 0};
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);
}

class win
{
private:
    int screen[w_y][w_x]; //0blank 1fly 2enemy 3bullet 4border
    int gameSpeed;

public:
    int score;
    win(/* args */);
    void show(); //show screen
    void update_auto();
    void update_ctr();
    int judge();
};

win::win(/* args */)
{
    hideCursor();
    score = 0;
    gameSpeed = 0;              //slow enemy
    screen[f_y][f_x] = 1;       //fly
    for (int i = 0; i < 3; i++) //enemy
    {
        screen[1][rand() % (w_x - 1) + 1] = 2;
    }
    for (int i = 1; i < w_x; i++) //border
    {
        screen[0][i] = 4;
        screen[w_y][i] = 4;
    }
    for (int i = 1; i < w_y; i++)
    {
        screen[i][0] = 4;
        screen[i][w_x] = 4;
    }
}

//multi enemy bullet
//reward bigger bullet

void win::update_auto()
{
    for (size_t y = 1; y < w_y; y++)
    {
        for (size_t x = 1; x < w_x; x++)
        {
            if (screen[y][x] ==)
        }
    }
}

void win::update_ctr()
{
    //fly move or fire bullets
    if (kbhit())
    {
        switch (getch())
        {
        case 'w':
            if (f_y > 1)
                f_y--;
            break;
        case 's':
            if (f_y < w_y - 1)
                f_y++;
            break;
        case 'a':
            if (f_x > 1)
                f_x--;
            break;
        case 'd':
            if (f_x < w_x - 1)
                f_x++;
            break;
        case ' ':
            if (b_y == -1)
            {
                b_x = f_x;
                b_y = f_y - 1;
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
            switch (screen[w_y][w_x])
            {
            case 0:
                putchar(' ');
                break;
            case 1:
                putchar('*');
                break;
            case 2:
                putchar('@');
                break;
            case 3:
                putchar('|');
                break;
            case 4:
                putchar('+');
                break;
            }
        }
        std::cout.put('\n');
    }
    std::cout << "score:" << score << std::endl;
}

int win::judge()
{
    //lose
    if ((a_y == f_y) && (a_x == f_x))
    {
        return -1;
    }
    //win
    if (score == 5)
    {
        return 1;
    }
    return 0;
}

int main()
{
    win w;
    int flag;
    while (1)
    {
        w.update_ctr();
        w.update_auto();
        flag = w.judge();
        w.show();
        if (flag)
            break;
    }
    //print result
    if (flag == 1)
    {
        std::cout << "Congratulations,you win!" << std::endl;
    }
    else
    {
        std::cout << "You lose." << std::endl;
    }
    std::cin.get();
    return 0;
}