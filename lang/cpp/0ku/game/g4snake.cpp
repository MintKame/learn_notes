/*
 * @Author: 闫昭
 * @Date: 2020-07-18 10:16:03
 * @LastEditTime: 2020-07-18 10:16:03
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\Untitled-2.cpp
 */
/*
 * @Author: 闫昭
 * @Date: 2020-07-10 12:08:37
 * @LastEditTime: 2020-07-16 10:40:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \c\game_1_fly.cpp
 */
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#define MAX 5

/**
 * @description: 刷屏
 */
void gotoxy(int x, int y);
void gotoxy(int x, int y)
{
    COORD pos = {x, y};
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE); // 获取标准输出设备句柄
    SetConsoleCursorPosition(hOut, pos);           //两个参数分别是指定哪个窗体，具体位置
}

/**
 * @description: 隐藏光标
 */
void hideCursor();
void hideCursor()
{
    CONSOLE_CURSOR_INFO cursor_info = {1, 0}; //第二个值为0表示隐藏
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);
}

class win
{
private:
    int w_x; //window size
    int w_y;
    int f_x; //fly position
    int f_y;
    int b_x; //bullet position
    int b_y;
    int a_x; //enemy position
    int a_y;
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
    w_x = 20;
    w_y = 20;
    f_x = w_x / 2;
    f_y = 2 * w_y / 3;
    b_x = f_x;
    b_y = -1;
    a_x = rand() % (w_x - 1);
    a_y = 1;
    score = 0;
    gameSpeed = 0; //调整游戏
    hideCursor();
}

//多敌机，子弹，奖励子弹加粗

void win::update_auto()
{
    //bullet move up
    if (b_y > -1)
    {
        b_y--;
    }
    //creat new enemy
    if (((b_x == a_x) && ((b_y == a_y) || (b_y == a_y - 1))) || a_y > w_y)
    {
        if (a_y <= w_y) //hits
            score++;
        a_y = 0;
        a_x = rand() % (w_x - 1);
    }
    if (gameSpeed == 20)
    {
        a_y++;

        gameSpeed = 0;
    }
    else
    {
        gameSpeed++;
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
            if (((x == 0) || (x == w_x)) && y > 0) //border
            {
                std::cout.put('|');
            }
            else if ((y == 0) || (y == w_y))
            {
                std::cout.put('_');
            }
            else if ((x == b_x) && (y == b_y) && y > 0) //bullet
            {
                std::cout.put('|');
            }
            else if ((x == a_x) && (y == a_y))
            {
                std::cout.put('@');
            }
            else if ((x == f_x) && (y == f_y)) //fly
            {
                std::cout.put('*');
            }
            else //others
            {
                std::cout.put(' ');
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