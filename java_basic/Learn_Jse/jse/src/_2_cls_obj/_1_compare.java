package _2_cls_obj;

//where does compareTo() from ?

/*public interface Comparable <E> {
 *  public int compareTo(E o)
 * }
 * */

//how to compare 2 double ?
//   need special consider
//   -> use  Double.compare()

class Vec2D implements Comparable <Vec2D> { // so can pass subCls to compareTo()
  private int a, b;
  public Vec2D(int a_, int b_) { a = a_; b = b_; }
  public int getSize() { return a * a + b * b; }

  @Override
  public int compareTo(Vec2D o) {   // can't pass superObj
    //! result should be consistent with equals (override from Object
    return this.getSize() - o.getSize();
  }
  //java.util.Arrays.sort( Object[] ) use compareTo -> decrease
}
public class _1_compare {
  public static void main(String[]args) {
    Integer i = 1;
    Object o = 1;
    // aType are Integer
    
    //    i.compareTo(o);
    //    o.compareTo(i);
    //what are the problems ?
    //
    //1: only can pass Integer Obj
    //2: Object not implement Comparable
    
    //correct ?
    i.compareTo((Integer)o);
    ((Integer)o).compareTo(i);
  }
}