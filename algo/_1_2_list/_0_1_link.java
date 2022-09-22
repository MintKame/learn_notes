package _1_2_list;

//also: double - circular link list

abstract class Data {   //use abs_cls
  Data(){}
  @Override // need to override functions
  abstract public String toString();
  @Override
  abstract public boolean equals(Object obj);
}

class List{

  protected class Node {
    Data data; //reuse by extends Data 
    Node next;

    Node() {
      this(null);
    }

    Node(Data data_) {
      data = data_;
      next = null;
    }
  }

  protected final Node head;
  protected int length;

  List() {
    length = 0;
    head = new Node();
  }

  // because often use the prior of what we want
  // pass 0 to get head, length to get last node
  private Node v_findPriorByIndex(final int index) {
    if (index > length || index < 0){
      return null;
    }
    Node ptr = head;
    // (return head if index == 0)
    for (int i = 0; i < index; i++) {
      ptr = ptr.next;
    }
    return ptr;
  }

  // can't find -> return null
  public Node v_findPriorByData(final Data data) {
    Node ptr;
    // obj need to override equals()
    for (ptr = head; ptr.next != null && !ptr.next.data.equals(data); ptr = ptr.next)
      ;
    if (ptr.next == null)
      ptr = null;
    return ptr;
  }

  public int length() {
    return length;
  }

  // index must in [0, length - 1]
  public final Data find(final int index) {
    Node ptr = v_findPriorByIndex(index);
    return ptr.next.data;
  }

  // index must in [0, length]
  public void insert(int index, Data data) {
    if (index < 0 || index > length)
      return;
    Node ptr = v_findPriorByIndex(index);
    Node newNode = new Node(data);
    newNode.next = ptr.next;
    ptr.next = newNode;
    length++;
  }

  // index must in [0, length - 1] && length >= 1
  public void removeAt(int index) {
    if (index < 0 || index > length - 1)
      return;
    Node ptr = v_findPriorByIndex(index);
    ptr.next = ptr.next.next;
    length--;
  }

  // para data must can be found
  public void removeData(Data data) {
    Node ptr = v_findPriorByData(data);
    if (ptr != null) {
      ptr.next = ptr.next.next;
      length--;
    }
  }

  // return -1 (not find)
  public int indexOf(Data data) {
    Node ptr = head.next;
    int ret;
    for (ret = 0; ret < length && data.equals(ptr.data); ret++) {
      ptr = ptr.next; // forget to update
    }
    if (ret >= length)
      ret = -1;
    return ret;
  }

  public void clear() {
    length = 0;
    head.next = null;
  }

  public void print() {
    Node ptr = head.next;
    System.out.print("length: " + length + "\t[");
    for (int i = 0; i < length; i++) {
      System.out.print(" " + ptr.data);
      if (i != length - 1) {
        System.out.print(",");
      }
      ptr = ptr.next; // forget to update
    }
    System.out.println(" ]");
  }
}
