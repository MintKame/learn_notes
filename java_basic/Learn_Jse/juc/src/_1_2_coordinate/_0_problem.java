/**
 * @Author: 闫昭
 * @Date: 2020-11-08- 19:55:00
 * @LastEditors:
 * @Description:
 */
package _1_2_coordinate;
//call what in OS concept ?
//  monitor: mutex access using lock
//        && tmp release when condition not satisfied ( to avoid ddl
//  sync / lock can achieve monitor by anObj / condition

/** three. limit reSrc (2-cases)
 *         need coordinate between threads
 *
 *    1,2 lock sync
 *      access have condition
 *    3 sem
 *      only n thread can access critical section
 *          (here, the critical section is reSrc)
 *

 eg: producer - consumer (can 1 time change n)
    full / empty -> print & wait
    change buffer & print
 */

/** steps of multitask:
 * 1. define resource class (attr, op)    [ eg. 0
 * 2. op: a. lock                         [ eg. 123
 *        b. judge & wait (while)
 *        c. work
 *        d. notify
 *        e. unlock
 * 3. multitasks call op                  [ eg. 123
* */


public class _0_problem {
    public static void main(String[] args) {
        /** 3. multitasks call op */
        _1_lock buffer = new _1_lock();    // cls can be change: 1, 2, 3
        //10 consumer, 10 producer
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                buffer.consume();
            }).start();
            new Thread(() -> {
                buffer.produce();
            }).start();
        }
    }
}