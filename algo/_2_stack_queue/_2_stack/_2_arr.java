package _2_stack_queue._2_stack;

class StackArr {
  private Data[] arr;
  private int tos;      // index of the (top of stack)
  private int mem = 1;  // total space (include head)

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
    // primitive: 1 step
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

//class Data{
////need to override functions
//int a;
//Data(int a_){ a = a_; }
//@Override 
//public String toString() {
//return "" + a;
//}
//@Override
//public boolean equals(Object obj) {
//return a == ((Data)obj).a;
//}
//}
//
//public class _2_arr {
//  public static void main(String[] args) {
//    StackArr s = new StackArr();
//    s.push(new Data(1));
//    s.push(new Data(2));
//    s.push(new Data(3));
//    s.print();
//    s.pop();
//    s.print();
//    s.pop();
//    s.pop();
//    s.print();
//  }
//}