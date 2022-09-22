package _2_stack_queue._2_stack;

abstract class Data {   //use abs_cls
  Data(int a_){}
  @Override // need to override functions
  abstract public String toString();
  @Override
  abstract public boolean equals(Object obj);
}

class StackLink {
  private class Node {
    Data data; // change when needed
    Node next;

    Node() {
      this(null);
    }

    Node(Data data_) {
      data = data_;
      next = null;
    }
  }

  private final Node head;
  private int length;

  StackLink() {
    length = 0;
    head = new Node();
  }

  public int length() {
    return length;
  }
  
  //mustn't be empty
  public Data top() {
    return head.next.data;
  }
    
  //mustn't be empty
  public Data pop() {
    Data data = head.next.data;
    head.next = head.next.next;
    length--;
    return data;
  }

  public void push(Data data) {
    Node newNode = new Node(data);
    newNode.next = head.next;
    head.next = newNode;
    length++;
  }

  //top - left
  public void print() {
    Node ptr = head.next;
    System.out.print("length: " + length + "\ttop[");
    for (int i = length - 1; i >= 0; i--) {
      System.out.print(" " + ptr.data);
      if (i != 0) {
        System.out.print(",");
      }
      ptr = ptr.next;
    }
    System.out.println(" ]");
  }
}

//class Data{
//  //need to override functions
//  int a;
//  Data(int a_){ a = a_; }
//  @Override 
//  public String toString() {
//    return "" + a;
//  }
//  @Override
//  public boolean equals(Object obj) {
//    return a == ((Data)obj).a;
//  }
//}
//public class _1_link {
//  public static void main(String[] args) {
//    StackLink s = new StackLink();
//    s.push(new Data(1));
//    s.push(new Data(2));
//    s.push(new Data(3));
//    s.print();
//    s.pop();
//    s.print();
//  }
//}