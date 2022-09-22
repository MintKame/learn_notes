package _2_stack_queue._4_oj_linear.ac;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class lg_1981_expr_Val {

  public static LinkedList<String> toPostExpr(String str){
    LinkedList<String> postExpr = new LinkedList<String>();
    LinkedList<Character> opStack = new LinkedList<>();
    int index = 0;
    StringBuffer sb = new StringBuffer();// to store the num
    //traverse the sb
    while (index < str.length()){
      // num -> postExpr
      while (index < str.length() && Character.isDigit(str.charAt(index))){
        sb.append(str.charAt(index++));
      }
      if (sb.length() != 0){
        postExpr.add(sb.toString());
        sb.delete(0, sb.length());
      }
      // op -> stack -> postExpr
      // need: op with high priority first
      if(index < str.length()) {
        char op = str.charAt(index);
        // use current op to decide
        // stack(prior) -> expr
        while (!opStack.isEmpty()){
          char prior = opStack.pop();
          // cmp priority
          if (prior == '*' || prior == '/' || op == '+' || op == '-'){
            postExpr.add("" + prior);
          } else {
            opStack.push(prior);
            break;
          }
        }
        // current -> stack
        opStack.push(op);
      }
      index++;
    }
    // remain op -> expr
    while (!opStack.isEmpty()){
      postExpr.add(opStack.pop() + "");
    }
    // todo consider ()
    return postExpr;
  }

  public static int calPostExpr(LinkedList<String> postExpr){
    LinkedList<Integer> numStack = new LinkedList<>();
    // traverse the postExpr
    for (String str : postExpr) {
      if (Character.isDigit(str.charAt(0))){
        // num -> stack
        int num = new BigInteger(str).mod(BigInteger.valueOf(10000)).intValue();
        numStack.push(num);
      } else {
        // op -> pop 2 -> cal -> push 1
        int num_1 = numStack.pop();
        int num_0 = numStack.pop();
        switch (str){
          case "+":
            num_0 += num_1;
            break;
          case "-":
            num_0 -= num_1;
            break;
          case "*":
            num_0 *= num_1;
            break;
          case "/":
            num_0 /= num_1;
            break;
        }
        numStack.push(num_0 % 10000);
      }
    }
    return numStack.pop();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();
    LinkedList<String> post = toPostExpr(str);
    int res = calPostExpr(post);
//    System.out.println(post);
    System.out.println(res);
  }
}
/*
当答案长度多于 4 位时，请只输出最后 4 位，前导0 不输出。
1+1*3+4
8
1+1234567890*1
7891
1+1000000003*1
4
*/