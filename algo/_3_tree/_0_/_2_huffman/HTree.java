package _3_tree._0_._2_huffman;

import java.util.ArrayList;

class HTree implements Comparable{
  
   Data data;
   HTree left, right;
  
  HTree(Data d){
    data = d;
  }
  
  HTree(){}
  
  HTree(int cnt){
    data = new Data(cnt);
  }
  
  public static HTree createTree(String str) {
    //get data (element & cnt)
    ArrayList<Data> datas = cnter(str);
    //get nodes from data
    ArrayList<HTree> nodes = new ArrayList<>();
    for(Data d : datas) {
      nodes.add(new HTree(d));
    }
    //init tree
    HTree root = null;
    // special case: only 1 node
    if(nodes.size() == 1) {
      root = new HTree();
      root.left = nodes.get(0);
    }
    // common case: huffman
    while(nodes.size() >= 2) {
      //get min * 2      
      nodes.sort(null);
      HTree min1 = nodes.get(0);
      HTree min2 = nodes.get(1);
      //merge
      root = new HTree(min1.data.getCnt() + min2.data.getCnt());
      root.left = min1;
      root.right = min2;
      //change the arr
      nodes.remove(min1);
      nodes.remove(min2);
      nodes.add(root);
    }
    return root;
  }
  
  public String encode(String str) {
    StringBuffer sb = new StringBuffer("");
    for(int i = 0; i < str.length(); i++)
      sb.append(getcode("", str.charAt(i)));
    return sb.toString();
  }

  //s store the ans
  private String getcode(String s, char c) {
    // base: reach leaf, compare data
    if(data.c != 0) {
      if(data.c == c) {
        return s;
      }else {
        return null;
      }
    }
    // recur
    String ls = null, rs = null;
    if(left != null) {
      ls = left.getcode(s + "0", c);
    }
    if(right != null) {
      rs = right.getcode(s + "1", c);
    }
    //pass the ans bottom up
    if(ls != null) {      
      return ls; 
    }else {
      return rs;
    }
  }
  
  public String decode(String code) {
    StringBuffer sb = new StringBuffer("");
    HTree node = this;
    for(int i = 0; i < code.length(); i++) {
      if(code.charAt(i) == '0') {
        node = node.left;
      }else {
        node = node.right;
      }
      //reach leaf -> get char && reset node
      if(node.data.c != 0) { 
        sb.append(node.data.c);
        node = this;
      }
    }
    return sb.toString();
  }
  
  
  
  // cnt each char's times & return an array of Data (char + cnt)
  // delete the char after cnt it
  private static ArrayList<Data> cnter(String str) {
    ArrayList<Data> datas = new ArrayList<Data>();
    StringBuffer sb = new StringBuffer(str);
    while(sb.length() != 0) {
      //find a char not cnted
      char c = sb.charAt(0);
      int cnt = 1;
      sb.deleteCharAt(0);
      //find same char -> delete, cnt
      while(true) {
        int pos = sb.indexOf(c + "");
        if(pos == -1) { //this char's cnt is finish
          break;
        }
        sb.deleteCharAt(pos);
        cnt++;
      }
      datas.add(new Data(c, cnt));
    }
    // another way: use arr to cnt
    return datas;
  }
  
  @Override
  public int compareTo(Object o) {
    return data.compareTo(((HTree)o).data);
  }
}
