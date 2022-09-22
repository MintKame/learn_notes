/*
 * @Author: 闫昭
 * @Date: 2020-10-12 09:04:44
 * @LastEditTime: 2020-10-19 09:30:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/os/2_t/tmp.cpp
 */
#include <iostream>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>
using namespace std;
sem_t mutex_well; //access well mutually
sem_t mutex_tank; //access tank mutually
sem_t cnt_empty;  //number of tank's vacancy
sem_t cnt_full;   //number of tank's water
sem_t cnt_barrel; //number of vacant barrel
void *get_water(void *);
void *drink_water(void *);
int main()
{
    sem_init(&mutex_well, 0, 1);
    sem_init(&mutex_tank, 0, 1);
    sem_init(&cnt_empty, 0, 10);
    sem_init(&cnt_full, 0, 0);
    sem_init(&cnt_barrel, 0, 3);

    pthread_t younger[5], older[5];
    for (int i = 0; i < 5; i++)
    {
        pthread_create(&younger[i], nullptr, get_water, nullptr);
        pthread_create(&older[i], nullptr, drink_water, nullptr);
    }
}

void *drink_water(void *)
{
    while (1)
    {
        //wait for having water
        sem_wait(&cnt_full);
        //get a barrel
        sem_wait(&cnt_barrel);
        //no one use the tank
        sem_wait(&mutex_tank);
        //drink water
        sem_post(&cnt_empty);
        //leave tank
        sem_post(&mutex_tank);
        //put back barrel
        sem_post(&cnt_barrel);
        cout << "喝水" << endl;
    }
}
void *get_water(void *)
{
    while (1)
    {
        //wait for having vacancy
        sem_wait(&cnt_empty);
        //get a barrel
        sem_wait(&cnt_barrel);
        //no one use the well
        sem_wait(&mutex_well);
        //leave well
        sem_post(&mutex_well);
        //no one use the tank
        sem_wait(&mutex_tank);
        //add water
        sem_post(&cnt_full);
        //leave tank
        sem_post(&mutex_tank);
        //put back barrel
        sem_post(&cnt_barrel);
        cout << "打水" << endl;
    }
}