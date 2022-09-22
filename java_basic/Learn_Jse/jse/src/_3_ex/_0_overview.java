package _3_ex;
//when use ex ?
//  handle difficult problem & un-expect problem

//what's super of ex ?
//  Throwable (java.lang.)

/*types:
 * 1. unchecked ex
 *      a. how to solve ?
 *          throw by JVM (dump process), then correct the program / env
 *      b. 2 types ?
 *          Error    :  JVM error
 *                      LinkageError 
 *                      VirtualMachineError
 *          Runtime  :
 *              what's causes ?
 *                      ArithmeticException | /0
 *                      NullPointer ~       | access obj through "null"
 *                      IndexOutOfBound ~   | 
 *                      IllegalArgument ~   |
 * 
 * 2. checked ex 
 *          how to solve ?   
 *              using try-catch / declare in func
 *          Exception:  IOException         | sub: InterruptedIO ~ EOF ~ FileNotFound ~
 *                      ClassNotFound ~
*/

public class _0_overview {
    public static void main(String[] args) {
//what's the result ?
        System.out.println(1 / 0.0);
        System.out.println(1.0 / 0);
        System.out.println(1 / 0);
        long l = Long.MAX_VALUE + 1;
// Infinity  Infinity  ex  not-ex (overflow)
    }
}
