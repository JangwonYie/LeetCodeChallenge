package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 *
 *
 * Created by Jangwon Yie on 2018. 4. 2..
 */
public class BTLOT {

    private static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new LinkedList<List<Integer>>();

        Queue<TreeNode> init = new LinkedList<TreeNode> ();
        init.offer(root);

        addLevel(list, init);

        return list;
    }

    private void addLevel(List<List<Integer>> list, Queue<TreeNode> queue){
        if(queue.isEmpty())
            return;
        Queue<TreeNode> next = new LinkedList<TreeNode> ();
        List<Integer> levelList = null;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(null != node){
                if(null == levelList)
                    levelList = new LinkedList<Integer> ();
                levelList.add(node.val);
                if(null != node.left)
                    next.offer(node.left);
                if(null != node.right)
                    next.offer(node.right);
            }
        }
        if(null != levelList)
            list.add(levelList);
        if(!next.isEmpty())
            addLevel(list, next);
    }

}
