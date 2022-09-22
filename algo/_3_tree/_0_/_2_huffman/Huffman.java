package _3_tree._0_._2_huffman;


import java.util.Scanner;

public class Huffman {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("input the string: ");
    String str = sc.nextLine();
    HTree tree = HTree.createTree(str);
    System.out.println("code: " + tree.encode(str) + "\n");
    
    System.out.println("input the code: ");
    String code = sc.nextLine();
    System.out.println("string: " + tree.decode(code));
  }
}

