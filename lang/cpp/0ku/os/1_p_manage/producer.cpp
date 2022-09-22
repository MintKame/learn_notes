/*
 * @Author: 闫昭
 * @Date: 2020-10-19 08:02:16
 * @LastEditTime: 2020-10-19 08:02:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editde
 * @FilePath: /os/2_p_ipc/producer.cpp
 */
#include <pthread.h>
#include <unistd.h>
#include <iostream>
using namespace std;
pthread_t ntid;
int main()
{
    pid_t pid;
    pthread_t tid;
    pid = getpid();
    tid = pthread_self();
    cout << pid << tid << endl;
}