package _2_cls_obj;

class T{
  public static int cnt; 
  //how to release resource/ctrl static size ? (ctor, dtor in cpp)
  T(){cnt++;}

  @Override //Object
  protected void finalize() { //not use(not garntee invoke)
    cnt--;
    System.out.println("finalized! cnt: " + cnt);
  }
}


public class _3_gc {
  _3_gc link;
  static public void main(String []args)
  {
    //when gc release mem ?
    //  not specific

    //1.when become garbage ?
    //obj can't reach:  4 types
    //a. ref to null
    T t1 = new T();
    t1 = null;
    //b. reallocate
    T t2 = new T();
    t2 = new T();
    //c. local obj (create in func)
    //d. island of isolation:
    _3_gc g1 = new _3_gc();
    _3_gc g2 = new _3_gc();
    g1.link = g2;
    g2.link = g1;
    g1 = null; g2 = null; //g1 g2 become garbage
  
    //2.advantages of gc ?
    //not expensive
    //avoid problem: if we use free():
    //  not free -> mem leak
    //  if 2 ref to same obj
    //      free 1 -> dangling ref
    //      free 2 -> error

    //3. how to run gc ?  (not use in practice)
    System.out.println("0:                we have " + T.cnt);
    
    System.gc();                // maybe gc
    System.out.println("after call gc:    we have " + T.cnt);
    
    System.runFinalization();   // must gc
    System.out.println("after call runFi: we have " + T.cnt);
  }  
}