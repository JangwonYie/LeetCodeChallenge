package com.jyie.leet;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SNiP {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(null == head)
            return head;
        ListNode next = head.next;
        if(null == next)
            return head;

        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }
}
