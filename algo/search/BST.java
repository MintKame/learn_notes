package search;/*
 * @Author: 闫昭
 * @Date: 2020-12-02- 20:09:00
 * @LastEditors:
 * @Description:
 */

import java.util.ArrayList;

public class BST {
    public static void main(String[] args) {
//        arr = new int[]{9, 6, 2, 7};
        BST bst = new BST();
        int[] arr = new int[]{9, 6, 2, 7, 3, 1, 5, 4};
        for (int i = 0; i < arr.length; i++) {
            bst.insert(new Node(arr[i]));
        }
        bst.inOrder();
        bst.remove(6);
        bst.inOrder();
        System.out.println(bst.depth(9));
        System.out.println(bst.depth(100));
        System.out.println(bst.depth(5));
        bst.layerOrder();
    }
    Node root;

    //when target not exist, ret last visited node
    Node getParent(int target) {
        Node parent = null, node = root;
        while (node != null && node.val != target){ //can get parent
            parent = node;
            // set node to its child (same direction as target)
            if (node.val > target){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return parent;
    }

    //[root -> parent]
    public ArrayList<Node> getPath(int val){
        ArrayList<Node> list = new ArrayList<Node>();
        Node node = root;
        while (node != null && node.val != val){
            list.add(node);
            if (node.val > val)
                node = node.left;
            else if (node.val < val)
                node = node.right;
        }
        return list;
    }

    public Node getNode(int val){
        Node node = root;
        while (node != null && node.val != val){
            if (node.val > val)
                node = node.left;
            else if (node.val < val)
                node = node.right;
        }
        return node;
    }

// return true if success
    public boolean insert(Node newNode){
        if (root == null){
            root = newNode;
            return true;
        }
        Node node = getParent(newNode.val);
        int val = newNode.val;
        if (node == null) { // can't find parent
            return false;
        }else { // node is parent (2 case: already exit | can insert)
            if (node.val > val && node.left == null){ // can insert to left
                node.left = newNode;
            } else if (node.val < val && node.right == null){
                node.right = newNode;
            } else {
                return false;   //already exist
            }
        }
        return true;
    }

    // return true if success
    public boolean remove(int target){   //replace with inOrder's pre
        Node parent = getParent(target); // get parent
        if (parent == null){
            return false;
        }
        //3-case: child 0, 1, 2
        //get node to delete && record which direction
        Node toDelete;
        boolean isLeft;
        if (parent.left != null && parent.left.val == target){
            toDelete = parent.left;
            isLeft = true;
        }else if (parent.right != null && parent.right.val == target){
            toDelete = parent.right;
            isLeft = false;
        }else { //not exist
            return false;
        }
        //case 0, 1
        if (toDelete.left == null){
            if (isLeft)
                parent.left = toDelete.right;
            else
                parent.right = toDelete.right;
        }else if(toDelete.right == null){
            if (isLeft)
                parent.left = toDelete.left;
            else
                parent.right = toDelete.left;
        }else { //case 2
            //get toDel's inOrder-prior & prior's parent
            Node p = toDelete.left;
            Node pp = toDelete;
            while (p.right != null){
                pp = p;
                p = p.right;
            }
            if (pp == toDelete) {
                //special case: toDel's left is toDel's prior
                // (while() not exe)
                if (isLeft)
                    parent.left = p;
                else
                    parent.right = p;
                p.right = toDelete.right;
            } else {
                //prior's left -> pp's child
                pp.right = p.left;
                //toDel -> prior
                toDelete.val = p.val;
            }
        }
        return true;
    }

    public void layerOrder(){
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(root);
        Node node;
        while (!list.isEmpty()){
            node = list.remove(0);
            // if node is null
            if (node == null)
                System.out.print("# ");
            else{
                System.out.print(node.val + " ");
                list.add(node.left);
                list.add(node.right);
            }
        }
        System.out.println();
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public int depth(int target){
        int depth = 1;
        Node node = root;
        while (node != null && node.val != target){
            depth ++;
            if (node.val > target)
                node = node.left;
            else
                node = node.right;
        }
        if (node == null) { //not found
            return -1;
        }
        else
            return depth;
    }
}

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
    }
}