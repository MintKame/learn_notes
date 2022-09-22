package _3_tree._0_._1_tree;

import java.io.IOException;
import java.util.Scanner;

public class Tree_link {
  
  private class Data{
    int data;
    Data(int data_){data = data_;}
    public String toString() {
      return "" + data;
    }
  }
  
  private Tree_link left, right;   //so, Tree can see 
  private Data data;
  Tree_link(int data_){
    this();
    data = new Data(data_);
  }
  Tree_link(){
    left = null;
    right = null;
  }

  //why static ?
  //  so that can pass a null tree

  /** init Tree from ins (preOrder) */
  public static Tree_link initTree(Scanner in) throws IOException{
    char c = in.next().charAt(0);
    if(c == '#')        // base case (child of leaf)
      return null;
    // set node
    Tree_link node = new Tree_link(c - '0');
    // init node's left
    node.left = initTree(in);
    // init node's right
    node.right = initTree(in);
    return node;
  }
  
  /** recursive traverse */
  public static void inorder(Tree_link node) {
    if(node == null)
      return;
    inorder(node.left);
    System.out.print(node.data);
    inorder(node.right);
  }

  public static void preorder(Tree_link node) {
    if(node == null)
      return;
    System.out.print(node.data);
    preorder(node.left);
    preorder(node.right);
  } 
  public static void postorder(Tree_link node) {
    if(node == null)
      return;
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data);
  } 

  /** assume the lowest is 1 */
  public static int depth(Tree_link node) {
    //base: node is null
    if(node == null)
      return 0;
    return 1 + Math.max(depth(node.left), depth(node.right));
  }

  /** cnt leaves */
  public static int cntLeaf(Tree_link t) {
    if (t == null) {
      return 0;
    }
    return Math.max(1, cntLeaf(t.right) + cntLeaf(t.left));
  }

  /** swap each node's left child & right child */
  public static void swapLR(Tree_link node) {
    //base: null
    if(node == null)
      return;
    Tree_link tmp = node.left;
    node.left = node.right;
    node.right = tmp;
    swapLR(node.left);
    swapLR(node.right);
  }
  
  public static void main(String[] args) throws Exception {
    Tree_link t = initTree(new Scanner("1\n2\n#\n3\n#\n#\n4\n#\n#\n"));
    swapLR(t);
    preorder(t);
    System.out.println();
    inorder(t);
    System.out.println();
    postorder(t);
    System.out.println();
    System.out.println("leaf:\t" + cntLeaf(t));
    System.out.println("depth:\t" + depth(t));
  }
}