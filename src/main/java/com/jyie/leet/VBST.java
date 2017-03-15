package com.jyie.leet;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 https://leetcode.com/problems/validate-binary-search-tree/
 */
public class VBST {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root).flag;
    }

    private static class TreeWithBound{
        boolean flag;
        int max;
        int min;
    }

    private TreeWithBound isValidBST_(TreeNode root){
        TreeWithBound result = new TreeWithBound();
        result.flag =true;
        if(null == root){
            return result;
        }


        if(root.right != null){
            TreeWithBound right = isValidBST_(root.right);
            if(right.flag == false || right.min <= root.val){
                result.flag = false;
                return result;
            }else
                result.max = right.max;

        }else
            result.max = root.val;

        if(root.left != null){
            TreeWithBound left = isValidBST_(root.left);
            if(left.flag == false || left.max >= root.val){
                result.flag = false;
                return result;
            }else
                result.min = left.min;
        }else
            result.min = root.val;

        return result;
    }
}
