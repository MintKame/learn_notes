package connect;

import java.util.Scanner;
public class Main {
  public static void main(String []args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("enter the size: ");
    int size = input.nextInt();
    UF_v2 myUf = new UF_v2(size);
    int p = 0, q = 0;
    for(int i = 0; true ; i++)
    {
      p = input.nextInt();
      q = input.nextInt();
      if((p == -1)||(q == -1))
        break;
      myUf.union(p, q);
    }
    //test
    for(int i = 0; i < size; i++)
    {
      for(int j = i + 1; j < size; j++)
      {
        System.out.printf("%d and %d are connected? %b\n", i, j, myUf.isConnected(i, j));
      }
      System.out.println();
    }
  }
}
