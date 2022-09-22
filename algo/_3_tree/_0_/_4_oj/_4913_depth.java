package _3_tree._0_._4_oj;
import java.util.Scanner;
/*
* 给出每个节点的两个儿子节点(序号)，建立一棵二叉树（根节点为 1），
* 如果是叶子节点，则输入0。输出深度。
pre order create
* * */
public class _4913_depth {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int cnt = in.nextInt();
        Tree head = new Tree(1);
        head.create();
//        Tree.pre(head);
        System.out.print(Tree.depth(head));
    }
    static class Tree{
        Tree left = null;
        Tree right = null;
        int data;
        Tree(int data_){
            data = data_;
        }
        public void create(){
            int ldata = in.nextInt();   //l, r 的值
            int rdata = in.nextInt();
            if(ldata != 0){ //存在则创建l， 并递归创建l的孩子
                left = new Tree(ldata);
                left.create();
            }
            if(rdata != 0){
                right = new Tree(rdata);
                right.create();
            }
        }

        public static void pre(Tree node){
            System.out.print(node.data);
            if(node.left != null){
                pre(node.left);
            }
            if(node.right != null){
                pre(node.right);
            }
        }
        public static int depth(Tree node){
            if(node == null){
                return 0;
            }
            int ldepth = depth(node.left);
            int rdepth = depth(node.right);
            return Math.max(ldepth, rdepth) + 1;
        }
    }
}

/* out: 4
7
2 7
3 6
4 5
0 0
0 0
0 0
0 0
* */