/*
 * @Author: 闫昭
 * @Date: 2020-10-05 11:02:35
 * @LastEditTime: 2020-10-05 11:02:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/os/1_p_manage/tmp.cpp
 */
#include <stdio.h>

extern char **environ;
int main()
{
    printf("A new program\n");
    for(int i = 0; environ[i] != NULL; i++)
    {
        printf("%s\n", environ[i]);
    }
    return 0;
}