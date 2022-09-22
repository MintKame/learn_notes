package _0_cls_base;
public class _1_val {
    //3-type var: cls member(not-static/static), local in func
    //when these 3 init ?     create obj | load cls | use '='
    //cls member have default val

    static int []arr_0;           
    
    //why ?
    static _1_val s1 = new _1_val();//success    
//    _1_val s2 = new _1_val();       //err
    //s1: static, only 1*init -> not recur new
    //s2: non-static, can only declare(like a ptr)
    //                  if new -> recur new (stack-over)
    
    static public void main(String []args){
        int []arr_1;
        int []arr_2 = new int[10];
        int []arr_3 = {1};

        System.out.println(arr_0);
//    System.out.println(arr_1);  not init -> err
        System.out.println(arr_2);
        System.out.println(arr_3);
        System.out.println(arr_2[0]);// 0
        System.out.println(arr_3[0]);// 1
    }
}