package _0_arr;

public class _2_multi_arr {
  static public void main(String[] args)
  {
    //x[i][j]: i rows, j cols  
    //ragged array - 1
    int [][]arr1 = { 
        {1,2},      //without new
        {3,4,5}
    };  

    //ragged array - 2
    int [][]arr2 = new int[2][];    //1st index must specified
    arr2[0] = new int[]{1,2};
    arr2[1] = new int[3];

    //traverse: row - col
    for(int row = 0; row < arr1.length; row++)
    {
      for(int column = 0; column < arr1[row].length; column++)
      ;
    }

    //traverse: col - row ( must not ragged
    for(int col = 0; col < arr1[0].length; col++)
    {
      for(int row = 0; row < arr1.length; row++)
        ;
    }
  }
}