/*
 * @Author: 闫昭
 * @Date: 2020-10-05 10:21:44
 * @LastEditTime: 2020-10-05 11:17:10
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/os/1_p_manage/1_fork_pid.cpp
 */
#include <stdio.h>
#include <syscall.h> //some head file
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h> //use exit()
int main(void)
{
    pid_t fork_1 = fork(); //fork: child return 0; parent return pid of child
    if (fork_1)            //!p_1
    {
        printf("process_1: pid = %d\n", getpid());
        wait(NULL);
    }
    if(!fork_1)
    {
        pid_t fork_2 = fork();
        if (fork_2) //!p_2
        {
            printf("process_2: pid = %d\t parent is %d\n", getpid(), getppid());
            //wait(); p_2 not wait, p_3 become orphan
        }
        if(!fork_2)//!p_3
        {
            int a = sleep(2);   //wsl can not exe
            for(int i = 0; i < 100 * 100 * 100; i++){
                int b = i * i * i;
            }
            printf("process_3: pid = %d\t parent is %d\n", getpid(), getppid());
        }
    }
}