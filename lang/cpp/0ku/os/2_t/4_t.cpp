/*
 * @Author: 闫昭
 * @Date: 2020-10-12 08:37:41
 * @LastEditTime: 2020-10-19 08:44:08
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/os/2_t/4_t.cpp
 */
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <pthread.h>
#include <unistd.h>
using namespace std;

void *thread_do(void *arg);
void print_ids(string name);

//g++ -pthread
int main()
{
    pthread_t tid;

    pthread_attr_t attr;      //attribute
    pthread_attr_init(&attr); //init attr to default

    pthread_create(&tid, &attr, thread_do, "para when create"); //
    pthread_join(tid, nullptr);                                 //wait for appointed thread terminate
    print_ids("main thread");
    return 0;
}

//print pid & tid
void print_ids(string name)
{
    //how to print tid?
    cout << name << ": pid " << getpid() << " tid:" << pthread_self() << endl;
}

void *thread_do(const void *arg)
{
    cout << "para passed: " << (char *)arg;
    print_ids("new thread");
    return ((void *)0);
}