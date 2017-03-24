package com.jyie.leet;

/**
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Created by Jangwon Yie on 2017. 3. 24..
 */
public class KthSmallest {

    private static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        int lSize = getChildrenSize(root.left);
        if(k == lSize + 1)
            return root.val;
        if(k <= lSize)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - lSize - 1);

    }

    private int getChildrenSize(TreeNode root){
        if(null == root)
            return 0;
        return 1 + getChildrenSize(root.left) + getChildrenSize(root.right);
    }
}
