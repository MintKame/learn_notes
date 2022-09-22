package _3_tree._0_._2_huffman;

class Data implements Comparable{
  char c = 0;
  private int cnt;
  
  Data(char c_, int cnt_){
    c = c_;
    cnt = cnt_;
  }
  
  Data(int cnt_){
    cnt = cnt_;
  }
  
  public int getCnt() {
    return cnt;
  }
  
  public String toString() {
    return "" + c + ": " + cnt + " times";
  }
  
  @Override
  public int compareTo(Object o) {
    return cnt - ((Data)o).cnt;
  }
}
