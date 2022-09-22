package _3_tree._0_._1_tree;

import java.util.Scanner;

public class Tree_arr {

  public static int[] initTree(Scanner in) {
    int depth = in.nextInt();
    int cnt = (int) (Math.pow(2, depth) - 1);
    int[] tree_ = new int[cnt];
    for(int i = 0; i < cnt; i++) {
      tree_[i] = in.nextInt();
    }
    return tree_;
  }
  
  public static void main(String[] args) {
    int[] t = initTree(new Scanner("1\n2"));
    System.out.println(t[0]);
  }

}
