package _3_tree._0_._3_thread_tree;

import java.util.Scanner;


public class Tree_link {
  
  private class Data{
    int data;
    Data(int data_){data = data_;}

    public String toString() {
      return "" + data;
    }
  }

  private static Tree_link pre;
  // field of a thread tree
  private Tree_link left, right;   //so, Tree can see 
  private boolean ltag, rtag; // isThread
  private Data data;

  Tree_link(int data_){
    this();
    data = new Data(data_);
  }
  Tree_link(){}

  /** return a tree with thread and head node */
  public static Tree_link threadTree(Scanner in) {
    //create tree, head
    Tree_link node = initTree(in);
    Tree_link head = new Tree_link();
    Tree_link last = getLast(node);
    //tree add thread, 1st -> head (must add thread firstly, or infinite loop)
    pre = head;
    addThread(node);
    //head -> tree ( -> means point to
    head.ltag = false;
    head.left = node;
    head.rtag = true;
    head.right = last;
    //tree -> head
    last.rtag = true;
    last.right = head;
    return head;
  }

  /** recursive traverse, only called by threadTree() */
  // add all thread & head's left & 1st visited node's left
  private static void addThread(Tree_link node) {    //return 1st node
    //base
    if(node == null) {
      return;
    }
    //recur: inOrder
    addThread(node.left);
    if(node.left == null) {
      node.left = pre;
      node.ltag = true;
    }
    if(pre.right == null) { //not check pre's null, (pre already init in threadTree())
      pre.right = node;
      pre.rtag = true;
    }
    pre = node;
    addThread(node.right);
  }

  /** init Tree (no-thread) from input (preOrder) */
  private static Tree_link initTree(Scanner in){
    char c = in.next().charAt(0);
    if(c == '#')        //base case (leaf)
      return null;
    //set node
    Tree_link node = new Tree_link(c - '0');
    node.left = initTree(in);
    node.right = initTree(in);
    return node;
  }

  /** get last node visited when traverse */
  private static Tree_link getLast(Tree_link node) {
    //find the most right
    while(node.right != null) {
        node = node.right;
    }
    return node;
  }

  //special case 0,2 node
  public static void inorder_th(Tree_link head) {
    Tree_link node = head.left;   //head's left
    //loop until return to the head
    while(node != head) {
      //visit the most left child
      while(!node.ltag) {
        node = node.left;
      }
      System.out.print(node.data + " ");
      //visit all r-thread
      while(node.rtag && node.right != head) {
        node = node.right;
        System.out.print(node.data + " ");
      }
      //to visit next node in next loop
      node = node.right;
    }
  }

  public static void inorder_th2(Tree_link head) {
    Tree_link node = head.left;   //head's left
    // left most node // err node.pre(), (but node may not the 2nd to visit
    while (!node.ltag) {
      node = node.left;
    }
    // inOrder visit
    while (node != head){
      System.out.print(node.data.data + " ");
      node = node.next();
    }
  }

  public Tree_link next() {
    Tree_link node = right;
    //node is thread
    if(rtag) {
      return node;
    }
    //node is child
    else {
      //node's left most child
      while(!node.ltag) {
        node = node.left;
      }
      return node;
    }
  }
  
  public Tree_link pre() {
    Tree_link node = left;
    if(ltag) {
      return node;
    }
    //node is child
    else {
      //node's most right child 
      while(!node.rtag) {
        node = node.right;
      }
      return node;
    }
  }
  
  public static void main(String[] args) throws Exception {
    Tree_link head,hl, hr; 
    head = threadTree(new Scanner("1\n2\n#\n3\n#\n#\n4\n#\n#\n"));  // pre order
//    head = threadTree(new Scanner("1\n#\n2\n#\n#"));
    inorder_th(head);
    System.out.println();
    inorder_th2(head);
//    System.out.println(head.left.pre().data);
//    System.out.println(head.left.next().data);
  }
}