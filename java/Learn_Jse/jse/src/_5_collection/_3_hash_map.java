package _5_collection;

import java.util.HashMap;
  
  //how use ?
  //    2-way: a. default Def, b. self Def relations(pass val)
  
class DefaultDef{  
  //1. static HashMap member
  private final static HashMap<Integer, String> coinName = new HashMap<>();

  //2. how to set relationship for static_map ?
  static {
    //(set when load cls)
    coinName.put(1, "penny");
    coinName.put(10, "dime");
    coinName.put(25, "quater");    
  }
  //3. use map to get value by key
  public static String getName(int i) {
    return coinName.get(i);
  }

  public static void printMap() {
    System.out.println(coinName.size() + "\t" + coinName);
  }
}

class SelfDef{
  //1. not-static HashMap member
  private HashMap<Integer, String> coinName = new HashMap<>();

  //2. how to set relationship for non-static_map ?
  public void addMatch(int i, String s) {
    //  (set when for each obj)
    coinName.put(i, s);
  }
  SelfDef(){}
  //3. use map to get value by key
  public String getName(int i) {
    return coinName.get(i);
  }
}



public class _3_hash_map {
  public static void main(String[] args) {
    
    System.out.println(DefaultDef.getName(1));
    DefaultDef.printMap();
    
    SelfDef s = new SelfDef();
    s.addMatch(1, "1 mao");
    s.addMatch(1, "1 jiao");
    System.out.println(s.getName(1));   
    //what's result ?
    //  new match override old    
  }
}
