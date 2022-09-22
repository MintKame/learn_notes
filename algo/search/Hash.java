package search;/*
 * @Author: 闫昭
 * @Date: 2020-12-01- 20:15:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;

public class Hash {
    int[] table;
    int size;
    Hash(int size){ //max size
        this.size = size;
        table = new int[size];
        Arrays.fill(table, Integer.MAX_VALUE);  //max -> no elem
    }

    private int hash(int key){ // how to map
        return key % size;
    }

    // return whether success to insert
    public boolean insert(int key){
        int index = hash(key);
        boolean tag = true;    // is the 1st pos probe
        while (true){
            if(table[index] == Integer.MAX_VALUE){  //empty -> success
                table[index] = key;
                return true;
            }else if(table[index] == key){  //already exist -> fail
                return false;
            }else if(!tag && index == hash(key)){    //full  -> fail
                return false;
            }else {                             //collision -> continue
                // linear try
                index = (index + 1) % size;
                tag = false;
            }
        }
    }

    //return search length
    public int search(int key){
        int index = hash(key);
        int cnt = 1;    // can be used to show whether 1st pos probe
        while (true) {
            if (table[index] == key) {                      //found -> success
                return cnt;
            } else if (table[index] == Integer.MAX_VALUE ||
                    cnt != 1 && index == hash(key)) {       //not exist (empty / all checked)
                return -1;
            } else {                                        //collision -> continue
                index = (index + 1) % size; // linear try
                cnt++;
            }
        }
    }


    public void print(){
        System.out.println("index\tkey");
        for (int i = 0; i < size; i++) {
            System.out.print("\t" + i + "\t" );
            if (table[i] != Integer.MAX_VALUE){
                System.out.println(table[i] + "\t" );
            } else{
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        Hash h = new Hash(12);
        h.print();
        int[] arr = {12, 67, 56, 16, 25, 37, 22, 29, 15, 47, 48, 34};
        for (int i = 0; i < arr.length; i++) {
            h.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(h.search(arr[i]));   //0
        }
        h.print();
        System.out.println(h.search(100));  //-1
    }
}
