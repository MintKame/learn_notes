/*
 * @Author: 闫昭
 * @Date: 2020-10-12 09:04:44
 * @LastEditTime: 2020-11-01 14:08:07
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \os\2_t\hs_2.cpp
 */
#include <iostream>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>
#include <cstdlib>
using namespace std;
sem_t mutex_well; //access well mutually
sem_t mutex_tank; //access tank mutually
sem_t cnt_empty;  //number of tank's vacancy
sem_t cnt_full;   //number of tank's water
sem_t cnt_barrel; //number of vacant barrel

int well = 1;   //access well mutually
int tank = 1;   //access tank mutually
int empty = 10; //number of tank's vacancy
int full = 0;   //number of tank's water
int barrel = 3; //number of vacant barrel
void get_water();
void drink_water();
void *hs_do(void *);
int main()
{
    sem_init(&mutex_well, 0, 1);
    sem_init(&mutex_tank, 0, 1);
    sem_init(&cnt_empty, 0, 10);
    sem_init(&cnt_full, 0, 0);
    sem_init(&cnt_barrel, 0, 3);

    pthread_t hs[5];

    for (int i = 0; i < 5; i++)
    {
        pthread_create(&hs[i], nullptr, hs_do, nullptr);
    }
    for (int i = 0; i < 10; i++)
    {
        pthread_join(hs[i], nullptr); //wait for appointed thread terminate
    }
}

void *hs_do(void *)
{
    while (1)
    {
        if (rand() % 2) //喝水
        {
            int tmp; //记录信号量剩余个数
            sem_getvalue(&cnt_full, &tmp);
            //若无水先去打水再喝水
            if (tmp == 0)
                get_water();
            drink_water();
        }
        else //打水
        {
            int tmp; //记录信号量剩余个数
            sem_getvalue(&cnt_empty, &tmp);
            //若水不满,打水
            if (tmp != 0)
                get_water();
        }
    }
}

void drink_water()
{
    //wait for having water
    sem_wait(&cnt_full);
    //get a barrel
    sem_wait(&cnt_barrel);
    //no one use the tank
    sem_wait(&mutex_tank);
    //leave tank
    sem_post(&mutex_tank);
    //drink water
    sem_post(&cnt_empty);
    //put back barrel
    sem_post(&cnt_barrel);
    cout << "喝水" << endl;
}
void get_water()
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
    //leave tank
    sem_post(&mutex_tank);
    //put back barrel
    sem_post(&cnt_barrel);
    //add water
    sem_post(&cnt_full);
    cout << "打水" << endl;
}