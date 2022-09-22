/*
 * @Author: 闫昭
 * @Date: 2020-10-12 12:36:56
 * @LastEditTime: 2020-10-15 13:20:25
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/os/1_p_manage/2_exec.cpp
 */
#include <stdio.h>
#include <syscall.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

int main()
{
    pid_t ret = fork();
    if (ret < 0)
    {
        exit(1);
    }
    else if (ret == 0)
    {
        wait(NULL);
    }
    else
    {
        //!
        /*  
            int execl(const char *path, const char *arg, ...);
            int execlp(const char *file, const char *arg, ...);
            int execle(const char *path, const char *arg, ..., char * const envp[]);
            int execv(const char *path, char *const argv[]);
            int execvp(const char *file, char *const argv[]);          
            int execve(const char *path, char *const argv[],char *const envp[]);
        */
        //all call execve()
        //p - find in path, not need complete path
        //e - envp[] 2 program pass env-var : last must NULL
        //l - list   | v - vector argv[]    : last must NULL
        //ret: fail - 1; success - 0

        //      !first para is func's name
        // execl("/bin/echo","echo","hello", NULL);
        // execlp("echo", "echo", "hello", NULL);

        char *const s[] = {(char *)"echo", (char *)"hello", NULL};
        // execv("/bin/echo", s);
        // execvp("echo", s);

        char *const env[] = {(char *)"hello=1", NULL};
        execve("testEnv", s, env);
        // execle("echo", "echo", "hello", NULL);

        printf("fail"); //if success, not exe
    }
}
