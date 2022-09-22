package connect;

//union too slow


public class UF_v1 {
  private int []arr;
  private int size;
  UF_v1(int size)                      //O(n)
  {
    this.size = size;
    arr = new int[size];
    for(int i = 0; i < size; i++)
    {
      arr[i] = i;
    }
  }
  public void union(int p, int q)   //O(n)
  {
    int obj = arr[q], des = arr[p];
    for(int i = 0; i < size; i++)
    {
      if(arr[i] == obj)
      {
        arr[i] = des;
      }
    }
  }  
  
  public boolean isConnected(int p, int q)  //O(1)
  {
    return (boolean)(arr[p] == arr[q]);
  }
//  int find(int p){}
//  int count(){}
}
