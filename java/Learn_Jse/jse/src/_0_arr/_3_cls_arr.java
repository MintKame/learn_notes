package _0_arr;

public class _3_cls_arr {

  static class CLS{
    public int data;
  }

  public static void main(String[] args) {
    //obj's arr
    CLS[] objs = new CLS[5]; 
    //what is initialed ?
    //  an arr of refs  |  "objs" ref entire array

    //1. each element need init
    //for - each can't new a ref
    for(int i = 0; i < objs.length; i++) {
      objs[i] = new CLS();  
    }

    //2.change data 
    //for - each can
    for(CLS j : objs) {
      j.data = -1;
    }

    //why 1,2 diff ?
    // ans: 1-change ref to what; 2-change obj's data by ref
  }
}