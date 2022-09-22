package _2_stack_queue._3_queue;

abstract class Data {   //use abs_cls
  Data(int a_){}
  @Override // need to override functions
  abstract public String toString();
  @Override
  abstract public boolean equals(Object obj);
}

class QueueLink {
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

  private Node tail;

  private int length; // head - de; tail - en.

  QueueLink() {
    length = 0;
    tail = head = new Node();
  }

  public int length() {
    return length;
  }

  public void enQueue(Data data) {
    Node newNode = new Node(data);
    tail.next = newNode;
    tail = newNode; // when 0 length, same
    length++;
  }

  // mustn't be empty
  public Data deQueue() {
    Data data = head.next.data;
    head.next = head.next.next;
    length--;
    if (length == 0) {
      tail = head;
    }
    return data;
  }

  public void print() {
    Node ptr = head.next;
    System.out.print("length: " + length + "\thead [");
    for (int i = 0; i < length; i++) {
      System.out.print(" " + ptr.data);
      if (i != length - 1) {
        System.out.print(",");
      }
      ptr = ptr.next;
    }
    System.out.println(" ]");
  }
}

//class Data {
////need to override functions
//  int a;
//
//  Data(int a_) {
//    a = a_;
//  }
//
//  @Override
//  public String toString() {
//    return "" + a;
//  }
//
//  @Override
//  public boolean equals(Object obj) {
//    return a == ((Data) obj).a;
//  }
//}
//
//public class _1_link {
//
//  public static void main(String[] args) {
//    var q = new QueueLink();
//    q.enQueue(new Data(1));
//    q.enQueue(new Data(2));
//    q.enQueue(new Data(3));
//    q.print();
//    q.deQueue();
//    q.print();
//  }
//}