package Tmp;/*
 * @Author: 闫昭
 * @Date: 2020-12-23- 21:23:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrent {
    static Food food = new Food();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                food.get();
            }).start();
            new Thread(new Producer(food, i)).start();
        }
    }
}

class Food{
    int remain = 0, size = 5;
    String[] list = new String[size];
    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    String get(){
        String food = null;
        try {
            lock.lock();
            while (remain == 0){
                System.out.println("no food");
                notEmpty.await();
            }
            food = list[remain - 1];
            list[remain - 1] = null;
            remain--;
            System.out.println("get " + food);
            System.out.println(remain + "\t" + Arrays.toString(list));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            notFull.signalAll();
            lock.unlock();
            return food;
        }
    }

    void store(String newFood){
        try {
            lock.lock();
            while (remain == size){
                System.out.println("no place");
                notFull.await();
            }
            list[remain] = newFood;
            remain++;
            System.out.println("store " + newFood);
            System.out.println(remain + "\t" + Arrays.toString(list));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notEmpty.signalAll();
            lock.unlock();
        }
    }
}

class Producer implements Runnable{
    Food food;
    int newFood;
    Producer(Food food, int newFood){
        this.food = food;
        this.newFood = newFood;
    }

    @Override
    public void run() {
        food.store(newFood + "");
    }
}