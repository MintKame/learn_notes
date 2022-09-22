package _3_ex;
public class _2_define {
}
class InputOutRange extends Exception{
  // why recommend self-def ex extends checked exception ?
  //    compiler force user to handle ex(catch / also declare)
  private String msg;
  
  //always provide 2 types ctor
  public InputOutRange() { this("invalid input"); }
  public InputOutRange(String msg) { this.msg = msg; }
  
  //always use toString
  @Override   
  public String toString() { return getClass() + ": " +msg; }
  @Override
  public String getMessage() { return msg; }
}