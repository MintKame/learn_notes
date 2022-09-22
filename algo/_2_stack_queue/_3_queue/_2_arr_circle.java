package _2_stack_queue._3_queue;

class QueueArr {

  private Data[] arr;    //use 1 place to represent full
  private int head;
  private int tail; // the 1st available
  private int size;
  // head - de; tail - en.

  QueueArr() {
    size = 2;
    arr = new Data[size];
    tail = head = 0;
  }

  private void v_larger() {
    int newSize = 2 * size;
    Data[] newArr = new Data[newSize];
    // 换到新的arr中
    int index = head;
    int len = length();
    for (int i = 0; i < len; i++) {
      if (index < size)
        newArr[index] = arr[index];
      else
        newArr[(index + size) % newSize] = arr[index % size];
      index++;
    }
    arr = newArr;
    size = newSize;
//    System.out.println("after lar: head-" + head + " tail-" + tail);
//    print();
  }

  public int length() {
    return (tail - head + size) % size;
  }

  // to be same, resize the queue
  public void enQueue(Data data) {
    if (length() + 1 == size) {
      v_larger();
    }
    arr[tail] = data;
    tail = (tail + 1) % size;
//    System.out.println("after enq: head-" + head + " tail-" + tail);
//    print();
  }

  //mustn't be empty
  public Data deQueue() {
    Data data = arr[head];
    arr[head] = null;   //for primative, no need
    head = (head + 1) % size;
    return data;
  }

  public void print() {
    System.out.print("length: " + length() + "\thead [");
    int index = head;
    for (int i = 0; i < length(); i++) {
      System.out.print(" " + arr[index % size]);
      index++;
      if (i != length() - 1) {
        System.out.print(",");
      }
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

//public class _2_arr_circle {
//
//  public static void main(String[] args) {
//    var q = new QueueArr();
//    q.enQueue(new Data(1));
//    q.enQueue(new Data(2));
//    q.enQueue(new Data(3));
//    q.print();
//    q.deQueue();
//    q.print();
//  }
//}