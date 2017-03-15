package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UBST2 {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        return genereateTrees(n,0);
    }

    private List<TreeNode> genereateTrees(int n, int offset){
        List<TreeNode> result = new LinkedList<TreeNode>();

        if(0 == n)
            return result;

        if(1 == n){
            TreeNode root = new TreeNode(n + offset);
            result.add(root);
            return result;
        }

        List<TreeNode> r0 = genereateTrees(n-1,1 +offset);
        for(int i=0;i<r0.size();i++){
            TreeNode root = new TreeNode(1 + offset);
            root.left = null;
            root.right = r0.get(i);
            result.add(root);
        }

        List<TreeNode> l0 = genereateTrees(n-1,0 + offset);
        for(int i=0;i<l0.size();i++){
            TreeNode root = new TreeNode(n + offset);
            root.left = l0.get(i);
            root.right = null;
            result.add(root);
        }

        for(int i=2;i<n;i++){
            List<TreeNode> left = genereateTrees(i-1, 0 + offset);
            List<TreeNode> right = genereateTrees(n-i, i + offset);

            int lSize = left.size();
            int rSize = right.size();

            for(int j=0;j<lSize;j++){
                for(int k=0;k<rSize;k++){
                    TreeNode root = new TreeNode(i + offset);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    result.add(root);
                }
            }
        }

        return result;
    }

}
