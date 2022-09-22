/*
 * @Author: 闫昭
 * @Date: 2020-07-07 21:03:18
 * @LastEditTime: 2020-07-22 09:32:11
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\game\0game.cpp
 */

/**
 * @description: refresh screen
 */
#include <windows.h>
void gotoxy(int x, int y)
{
    COORD pos = {x, y};
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE); //get standard output device handle
    SetConsoleCursorPosition(hOut, pos);           //1st which window;2nd position
}

/**
 * @description: hide cursor
 */
void hideCursor()
{
    CONSOLE_CURSOR_INFO cursor_info = {1, 0}; //2nd parameter=0 == hide
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);
}

if (kbhit())
{
    getch() == " ";
}
Sleep();