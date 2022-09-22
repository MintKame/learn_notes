/*
 * @Author: 闫昭
 * @Date: 2020-07-22 09:20:14
 * @LastEditTime: 2020-07-22 16:23:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\5interAct.cpp
 */
#include <stdio.h>
#include <graphics.h>

int main()
{
    initgraph(640, 480);
    setfont(18, 0, "??");

    //kbd
#if 0
    outtextxy(0, 0, "press any key");
    for (key_msg kbd{0}; kbd.key != key_esc;)
    {
        char str1[32];
        kbd = getkey();
        sprintf(str, "key=%c msg=%d flag=%d", kbd.key, kbd.msg, kbd.flags);

        cleardevice(); //clear screen
        outtextxy(0, 0, str1);
    }
#endif

    //input
#if 0
    char str2[12];
    inputbox_getline("input", "in 10 words", str2, 10);
    outtextxy(0, 0, str2);
#endif

    //mouse
#if 1
    mouse_msg msg{0};
    for (; is_run(); delay_fps(60))
    {
        while (mousemsg())
        {
            msg = getmouse();
        }
        cleardevice();
        xyprintf(0, 0, "x %d  y %d wheel %d", msg.x, msg.y, msg.wheel);
        xyprintf(0, 20, "up %d down %d", msg.is_up(), msg.is_down());
        xyprintf(0, 40, "left %d right %d", msg.is_left(), msg.is_right());
        xyprintf(0, 40, "move %d wheel %d", msg.is_move(), msg.is_wheel());
    }
#endif

    getch();
    closegraph();
    return 0;
}
