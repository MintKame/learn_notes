package _3_ex;
import java.util.InputMismatchException;
import java.util.Scanner;

//what is steps of exception handling ?
//how to execute must-exe statements ?
//  declare - may throw - try - catch - finally

//demo: need input: 1. not negative int, 2. 1 / num
public class _1_model {

    //what's diff: throws & throw ?

    //1. why func declare ex ?
    public static void fun() throws InputOutRange{
        //    to force caller handle checked ex:
        //how to handle (2 ways)?
        //    catch() / also declare ex (ask super level handle)

        Scanner input = new Scanner(System.in);

        //2. throw (2 unchecked, 1 checked)
        int para = input.nextInt();               //InputMismatchException (unchecked
        input.nextLine();

        if(para < 0) throw(new InputOutRange("input is negative"));  //InputOutRange

        System.out.println(1 / para);             //ArithmeticException (unchecked
    }

    public static void main(String[] args) {
        try { fun(); }
        //3. catch & show some msg
        catch(InputMismatchException ex)  { System.out.println(ex.getStackTrace()); } //1.0, 0, -1
        //    getStackTrace: FILO
        catch(ArithmeticException ex)     { System.out.println(ex.getMessage()); }
        catch(InputOutRange ex)           { System.out.println(ex); } //call toString()

        //how to catch multi in 1 catch block ?
        // eg: catch(ClassNotFoundException | IOException ex) { System.out.println(ex); }

        finally{ System.out.println(""); }
        //what if return before ?
        //  also exe
    }
}
