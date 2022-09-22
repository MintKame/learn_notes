package tmp;/*
 * @Author: 闫昭
 * @Date: 2020-11-25- 13:11:00
 * @LastEditors:
 * @Description:
 */

import java.io.IOException;
import java.util.Scanner;

public class Tree_link {

    private static class Data{
        int data;
        Data(int data_){data = data_;}
        public String toString() {
            return "" + data;
        }
    }

    private Tree_link left, right;   //so, Tree can see
    private Tree_link.Data data;
    Tree_link(int data_){
        this();
        data = new Tree_link.Data(data_);
    }
    Tree_link(){
        left = null;
        right = null;
    }


    //why static ?
    //  so that can pass a null tree

    /** init Tree from ins (preorder) */
    public static Tree_link initTree(Scanner in) throws IOException {
        Tree_link ret = new Tree_link();
        char data = in.next().trim().charAt(0);
        if (data == '#'){
            return null;
        }
        ret.data = new Data(data - '0');
        ret.left = initTree(in);
        ret.right = initTree(in);
        return ret;
    }


    public static void main(String[] args) throws Exception {
        Tree_link t = initTree(new Scanner("1 2 # 3 # # 4 # # "));
        inorder(t);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void inorder(Tree_link t) {
        if (t == null)
            return;
        inorder(t.left);
        System.out.print(t.data + " ");
        inorder(t.right);
    }
}