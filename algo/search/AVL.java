package search;/*
 * @Author: 闫昭
 * @Date: 2020-12-01- 20:37:00
 * @LastEditors:
 * @Description:
 */

import java.util.ArrayList;

public class AVL extends BST{

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                //last elem -> unbalance
                {5, 3, 6, 2, 4, 1},
//                {7, 8, 2, 5, 1, 3, 6, 4}
                {7, 2, 9, 1, 5, 8, 10, 0, 3, 6, 4}
        };
        AVL[] avl = new AVL[3];
        for (int i = 0; i < 2; i++) {
            avl[i] = new AVL();
            for (int j = 0; j < arr1[i].length - 1; j++) {
                avl[i].insert(new ANode(arr1[i][j]));
                System.out.println(i + " " + j);
            }
            avl[i].inOrder();
            avl[i].layerOrder();
            avl[i].insert(new ANode(arr1[i][arr1[i].length - 1]));  // -> unbalance
            avl[i].inOrder();
            avl[i].layerOrder();
        }
    }

    static class ANode extends Node{
        int height = 0;
        ANode(int val) {
            super(val);
        }
    }

    public int getBF(ANode node){
        if (node.left == null)        // can both l & r null
            return -node.height;
        else if (node.right == null)
            return node.height;
        else
            return ((ANode)node.left).height - ((ANode)node.right).height;
    }

    private void updateHeight(ANode node){
        int lh = 0;
        int rh = 0;
        if (node.left != null)
            lh = ((ANode)node.left).height;
        if (node.right != null)
            rh = ((ANode)node.right).height;
        ((ANode)node).height = Math.max(lh, rh) + 1;
    }

    @Override
    public boolean insert(Node newNode){
        if(!super.insert(newNode)) //insert err
            return false;
        else {      //reBalance
            ArrayList<Node> list = getPath(newNode.val);    //all ancestor
            for (int i = list.size() - 1; i >= 0; i--){ //bottom up -> find min unbalance tree
                //update height of all ancestor
                Node node = list.get(i);
                Node pNode = i == 0 ? null : list.get(i - 1);    //node's root -> no parent
                updateHeight((ANode) node);
                //if unbalance tree
                switch (getBF((ANode) node)){
                    case 2:    //L
                        if (getBF((ANode)(node.left)) < 0){
                            rotateLeft(node, node.left);
                            rotateRight(pNode, node);
                        }else {
                            rotateRight(pNode, node);
                        }
                        break;
                    case -2:     //R
                        if (getBF((ANode)(node.right)) < 0){
                            rotateLeft(pNode, node);
                        }else {
                            rotateRight(node, node.left);
                            rotateLeft(pNode, node);
                        }
                        break;
                }
            }
            return true;
        }
    }


    private void rotateRight(Node pa, Node a){    //this node is unbalance
        Node al = a.left;
        Node alr = al.right;
        if (pa == null) //a's root
            root = al;
        else{
            if (pa.left == a){
                pa.left = al;
            }else {
                pa.right = al;
            }
        }
        //rotate
        a.left = alr;
        al.right = a;
    }

    private void rotateLeft(Node pa, Node a){    //this node is unbalance
        Node ar = a.right;
        Node arl = ar.left;
        if (pa == null) //a's root
            root = ar;
        else{
            if (pa.left == a){
                pa.left = ar;
            }else {
                pa.right = ar;
            }
        }
        //rotate
        a.right = arl;
        ar.left = a;
    }

    @Override
    public boolean remove(int val){
        //TODO
        return false;
    }
}
