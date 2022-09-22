package _2_stack_queue._4_oj_linear;
import java.util.Scanner;

public class lg_3613_2dlinklist {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Manager m = new Manager();
    int n = input.nextInt();
    int q = input.nextInt();
    
    for(int i = 0; i < q; i++) {
      input.nextLine();
      int flag = input.nextInt();
      
      if(flag == 1) {
        int g_id = input.nextInt();
        int c_id = input.nextInt();
        int d = input.nextInt();
        
        Group group = m.find_prior_of(g_id).next;
        
        if(d != 0 && group == null) {
          group = new Group(g_id);
          m.insert(group);
        }
        
        if(d == 0) {
          group.delete(c_id);
        }
        else {
          Case newCase = new Case(c_id, d);
          group.insert(newCase);     
        }
      }
      else {
        int g_id = input.nextInt();
        int c_id = input.nextInt();
        Group group = m.find_prior_of(g_id);
        group = group.next;
        Case findedCase = group.find_prior_of(c_id);
        findedCase = findedCase.next;
        System.out.println(findedCase.data);
      }
    }
  }
  
}

class Case{
  public int index;
  public int data;
  public Case next;  
  public Case(int i, int d) { index = i; data = d; }
  public boolean indexIs(int i) { return (index == i);}
  public boolean indexBigThan(int i) { return (index > i);}
  public boolean indexSmallThan(int i) { return (index < i);}
  public String toString() {
    return "" + index + " " + data;
  }
}
/////////////////////////////////////////
class Manager{
  public Group head_group;
  
  public Manager() { 
    head_group = new Group(0);//head is zero
    head_group.next = null;
  }
  public Group find_prior_of(int i) {
    Group ptr_group = head_group;
    while(ptr_group.next != null) {
      if(ptr_group.next.indexIs(i)) {        break;      }
      ptr_group = ptr_group.next;
    }
    return ptr_group;
  }

  public void insert(Group g){
    Group ptr_group = head_group; 
    while(ptr_group.next != null && ptr_group.next.indexSmallThan(g.index)) {
      ptr_group = ptr_group.next; 
    }
    g.next = ptr_group.next;
    ptr_group.next = g;
  }

  public void delete(int i) {
    Group ptr_group = head_group; 
    Group prior = this.find_prior_of(i);
    prior.next = prior.next.next;
  }
  
  public void show() {
    Group ptr_group = head_group.next; 
    while(ptr_group != null)
    {
      System.out.println("group " + ptr_group.index);
      ptr_group.show();
      ptr_group = ptr_group.next;
    }
  }
} 

///////////////////////////////////////

class Group{
  public int index;
  public Case head_case;
  public Group next;
  
  public Group(int i) { 
    index = i; 
    head_case = new Case(0, 0);//head is zero
    head_case.next = null;
  }
  public boolean indexIs(int i) { return (index == i);}
  public boolean indexBigThan(int i) { return (index > i);}
  public boolean indexSmallThan(int i) { return (index < i);}
  public Case find_prior_of(int i) {
    Case ptr_case = head_case;
    while(ptr_case.next != null) {
      if(ptr_case.next.indexIs(i)) {        break;      }
      ptr_case = ptr_case.next;
    }
    return ptr_case;
  }
  public void insert(Case c){
    Case ptr_case = head_case;
    
    while(ptr_case.next != null && ptr_case.next.indexSmallThan(c.index)) {
      ptr_case = ptr_case.next; 
    }
    c.next = ptr_case.next;
    ptr_case.next = c;
  }

  public void delete(int i) {
    Case ptr_case = head_case;
    Case prior = this.find_prior_of(i);
    prior.next = prior.next.next;
  }
  
  public void show() {
    Case ptr_case = head_case.next;
    while(ptr_case != null)
    {
      System.out.println(ptr_case.toString());
      ptr_case = ptr_case.next;
    }
  }
}
