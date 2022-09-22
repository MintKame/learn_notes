/*
 * @Author: 闫昭
 * @Date: 2020-07-22 09:20:14
 * @LastEditTime: 2020-07-23 00:33:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\ege\0ege.cpp
 */
#include <iostream>
#include <graphics.h>
#include <graphics.h>

void mainloop()
{
    // is_run: closeMsg
    // delay_fps: screen refresh rate:60
    for (; is_run(); delay_fps(60))
    {
        cleardevice();
        // todo: ????
        // todo: ????
    }
}

int main(void)
{
    // initialize
    // INIT_NOFORCEEXIT click X,don't force exit
    // INIT_RENDERMANUAL == setrendermode(RENDER_MANUAL)/
    //refresh manual(delay_fps/delay_ms),to avoid flash
    setinitmode(INIT_DEFAULT | INIT_NOFORCEEXIT);
    initgraph(640, 480);
    //todo:randomize();
    setrendermode(RENDER_MANUAL);
    mainloop();
    closegraph();
    return 0;
}