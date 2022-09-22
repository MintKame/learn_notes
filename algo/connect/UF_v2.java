package connect;
//operate on the root 
//find root too slow (if the tree is too tall
//->improve: link short root blow the tall root (* tagged)
public class UF_v2 {
  private int []arr;
  private int size;
  private int []cnt;  //*store the node's child's size
  public UF_v2(int size)                      //O(n)
  {
    this.size = size;
    arr = new int[size];
    cnt = new int [size]; //*
    for(int i = 0; i < size; i++)
    {
      arr[i] = i;
    }
  }

  // return the p's root's index
  private int root(int p) //! 
  {
    while(p != arr[p])
    {
      arr[p] = arr[arr[p]]; //* make the height shorter
      p = arr[p];
    }
    return p;
  }
  
  public void union(int p, int q)   
  {
//old:  arr[root(p)] = root(q);
    //problem: make the tree shorter
    int root_p = root(p);
    int root_q = root(q);
    if(root_p == root_q)
    {
      return;
    }// take node which has smaller descend-size
    else if(cnt[root_p] > cnt[root_q])
    {
      arr[root_q] = root_p;
      //* update cnt
      cnt[root_p] += cnt[root_q];
    }
    else
    {
      arr[root_p] = root_q;      
      cnt[root_q] += cnt[root_p];
    }
  }  
  
  public boolean isConnected(int p, int q)  //!
  {
    return (boolean)(root(p) == root(q));
  }
}
