package _2_cls_obj;

class Person{
  int age;
  Person(int age_){ age = age_; }
  
  @Override
  public boolean equals(Object obj) { return this.age == ((Person)obj).age; }
  //! para type: Object (to override IF def in Object class
  //  public boolean equals(Person obj) { return this.age == obj.age; }   // Overload

  @Override
  public String toString() { return "i m " + age + " years old.";}

  @Override
  public int hashCode() {return super.hashCode();}
}

public class _0_object {    
  public static void main(String[]args) {

    Person o = new Person(1);
    Person o1 = new Person(1);
    Person o2 = o;
    System.out.println(o == o1); // F
    System.out.println(o == o2); // T
    System.out.println(o.equals(o1)); // T
    System.out.println(o.equals(o2)); // T
    System.out.println(o.hashCode() == o1.hashCode()); // F
    System.out.println(o.hashCode() == o2.hashCode()); // T
    //what diff ?
    //     == :  if ref to same obj (addr
    // equals :  if each data member are same
    // hashcode: value calc from addr
    //           same obj, same hashcode
    //           usage: to make collection of hash structure more efficient

    System.out.println("-------------------------------");
    //what's result ?
    String s1 = "abc";
    String s2 = new String("abc");
    StringBuffer sb  = new StringBuffer("abc");

    System.out.println(""+("abc" == s1) + (s1 == s2));          //t f
    System.out.println(""+"abc".equals(s1) + s1.equals(s2));    //t t
    System.out.println(""+s1.equals(sb) + sb.equals(s1));       //f f

    //why can compare & why the result ?
    //  equals need pass an Object
    //  StringBuffer not override equals, so compare the ref
    //  String's equal() check String type

    System.out.println(o1.toString());  //className@address (modified by hash)
    //override to show other msg
  }
}
