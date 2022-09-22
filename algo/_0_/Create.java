package _0_;

import java.util.LinkedList;

public class Create {
    // [1,2,2,3,4,4,3]
    LinkedList<Integer> vals = new LinkedList<>(); // 按前序存放(存null)
    Integer[] arr = new Integer[]{1, 2, 4, null, null, 5, null, null, 3, 6, null, null, null};
    TreeNode root = null;

    {
        for (Integer i : arr) {
            vals.add(i);
        }
        root = createTree();
    }

    private TreeNode createTree(){
        if (vals.isEmpty())
            return null;
        Integer val = vals.removeFirst();
        if(val == null)        // base case (child of leaf)
            return null;
        // set node
        TreeNode node = new TreeNode(val);
        // init node's left
        node.left = createTree();
        // init node's right
        node.right = createTree();
        return node;
    }

}
