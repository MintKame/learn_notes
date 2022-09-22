package _1_2_coordinate;

// require:
//      in order print A, B, C

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum Alpa{
    A, B, C
}

class Printer{

    Alpa flag = Alpa.A; // 接下来 print 哪个字母

    Lock lock = new ReentrantLock();

    Condition finishA = lock.newCondition();
    Condition finishB = lock.newCondition();
    Condition finishC = lock.newCondition();

    public void printA(){
        try {
            lock.lock();

            while (flag != Alpa.A) // 接下来 print 非A
                finishC.await(); // 等待打印完C

            System.out.println("A");
            flag = Alpa.B; // 下一个打印B

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finishA.signalAll();
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();

            while (flag != Alpa.B)
                finishC.await();

            System.out.println("B");
            flag = Alpa.C;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finishA.signalAll();

            lock.unlock();
        }
    }

    public void printC(){
        try {
            lock.lock();

            while (flag != Alpa.C)
                finishC.await();

            System.out.println("C");
            flag = Alpa.A;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finishA.signalAll();

            lock.unlock();
        }
    }
}

public class _4_eg {
    public static void main(String[] args) {
        Printer printer = new Printer();

        for (int i = 0; i < 5; i++) {
            new Thread(()-> printer.printA()).start();
            new Thread(()-> printer.printB()).start();
            new Thread(()-> printer.printC()).start();
        }
    }
}
