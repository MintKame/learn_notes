package _3_tree._0_._4_oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-11- 19:37:00
 * @LastEditors:
 * @Description:
 */

import java.util.Scanner;

/*
* 第一行为二叉树的节点数 n。(1≤n≤26)
后面 n 行，每一个字母为节点，后两个字母分别为其左右儿子。
空节点用 * 表示
6
abc
bdi
cj*
d**
i**
j**
abdicj
*
* */
//not preOrder input, cant recur, find node each input, then create node's child
public class _1305_pre {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int cnt = in.nextInt();
        for (int i = 0; i < cnt; i++){
        }
    }
}
class Tree{
    Tree left = null, right = null;
    char data;
    Tree(char data_){
        data = data_;
    }
    //inorder se

}