package _2_stack_queue._4_oj_linear;

import java.util.Scanner;

/*验证栈序列
2
5
1 2 3 4 5
5 4 3 2 1
4
1 2 3 4
2 4 1 3
 * */
/*
1
4
1 2 3 4
2 4 1 3
 * */

class StackArr {
  private Data[] arr;
  private int tos; // index of the (top of stack)
  private int mem = 1;

  StackArr() {
    tos = -1; // depend on the order of op (pop, push)
    arr = new Data[mem];
  }

  // size -> 2 size
  // need smaller?
  private void v_larger() {
    mem *= 2;
    Data[] newArr = new Data[mem];
    for (int i = 0; i <= tos; i++) { // arr[tos] has data
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public int length() {
    return tos + 1;
  }

  // mustn't be empty
  public Data top() {
    return arr[tos];
  }

  // mustn't be empty
  public Data pop() {
    // dec - remove
    // primative: 1 step
    // non- : need set null
    Data data = arr[tos];
    arr[tos] = null;
    tos--;
    return data;
  }

  public void push(Data data) {
    // push on full? first check.(after add, contains tos + 2 data)
    if (mem < tos + 2) {
      v_larger();
    }
    // inc - add
    tos++;
    arr[tos] = data;
  }

  // top - left
  public void print() {
    System.out.print("length: " + length() + "\ttop[");
    for (int i = tos; i >= 0; i--) {
      System.out.print(" " + arr[i]);
      if (i != 0) {
        System.out.print(",");
      }
    }
    System.out.println(" ]");
  }
}

class Data{
int a;
Data(int a_){ a = a_; }
@Override 
public String toString() {
return "" + a;
}
@Override
public boolean equals(Object obj) {
return a == ((Data)obj).a;
}
}

public class ac_lg_4387_stack_testify {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //输入数据组数
    int n = in.nextInt();
    for(int i = 0; i < n; i++) {      
      //对于每一组，输入元素数，及各元素存在2个数组
      int size = in.nextInt();
      int[] source = new int[size];
      int[] target = new int[size];
      for(int k = 0; k < size; k++) {
        source[k] = in.nextInt();
      }
      for(int k = 0; k < size; k++) {
        target[k] = in.nextInt();
      }
      //创建一个栈用来存原数组
      StackArr stack = new StackArr(); //0 - 栈顶
      int index_target = 0;  //标记目标数组的位置
      //遍历原数组
      for(int j = 0; j < size; j++) {        
        //入栈当前元素
        stack.push(new Data(source[j]));
        //循环：当 栈顶 == 目标标记元素 && 不到栈底
//        System.out.println(stack.toString() + target[index_target]);
        while(stack.length() != 0 && target[index_target] == stack.top().a) {          
          //出栈，同时index + 1
          stack.pop();
          index_target++;
        }
      }
      //若标记 == 总长度，可行
      System.out.println((index_target == size)? "Yes" : "No");
    }
  }
}



