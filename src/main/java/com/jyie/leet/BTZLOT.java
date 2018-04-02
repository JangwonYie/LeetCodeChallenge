package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 *
 * Created by Jangwon Yie on 4/2/18.
 */
public class BTZLOT {

    private static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        Stack<TreeNode> init = new Stack<TreeNode> ();
        init.push(root);

        addLevel(list, init,1);

        return list;
    }

    private void addLevel(List<List<Integer>> list, Stack<TreeNode> stack, int depth){
        if(stack.isEmpty())
            return;
        Stack<TreeNode> next = new Stack<TreeNode> ();
        List<Integer> levelList = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(null != node){
                if(null == levelList)
                    levelList = new LinkedList<Integer> ();
                levelList.add(node.val);
                if(depth%2 != 0){
                    if(null != node.left)
                        next.push(node.left);
                    if(null != node.right)
                        next.push(node.right);
                }else{
                    if(null != node.right)
                        next.push(node.right);
                    if(null != node.left)
                        next.push(node.left);
                }

            }
        }
        if(null != levelList)
            list.add(levelList);
        if(!next.isEmpty())
            addLevel(list, next, depth+1);
    }

}
