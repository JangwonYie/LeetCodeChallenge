package com.jyie.leet;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


 Example:

 Given the sorted linked list: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5

 *
 * Created by Jangwon Yie on 4/4/18.
 */
public class CSLBST {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {

        if(null == head)
            return null;

        List<ListNode> list = new ArrayList<ListNode>();
        toList(list, head);

        int size = list.size();

        return sortedSubListToBST(list, 0, size);
    }

    private TreeNode sortedSubListToBST(List<ListNode> list, int start, int end){
        if(end == start)
            return null;
        int centerIndex = (start + end)/2;
        int leftIndex = start;
        int rightIndex = centerIndex + 1;

        ListNode center = list.get(centerIndex);
        TreeNode root = new TreeNode(center.val);
        if(end-start > 1){
            TreeNode left = sortedSubListToBST(list, leftIndex, centerIndex);
            root.left = left;
        }

        if(end-start > 2){
            TreeNode right = sortedSubListToBST(list, rightIndex, end);
            root.right = right;
        }

        return root;
    }

    private void toList(List<ListNode> list, ListNode node){
        while(node != null){
            list.add(node);
            node = node.next;
        }
    }
}
