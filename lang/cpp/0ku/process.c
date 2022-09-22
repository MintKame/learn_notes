/*
 * @Author: 闫昭
 * @Date: 2020-09-29 16:04:45
 * @LastEditTime: 2020-09-29 16:08:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\process.c
 */
#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int value = 5;
int main()
{
    pid_t pid;
    pid = fork();
    if (pid == 0)
    {
        value += 15;
        printf("in child: %d \n", value);
        return 0;
    }
    else
    {
        wait(NULL);
        value += 10;
        printf("in parent: %d \n", value);
        return 0;
    }
}