package com.jyie.leet;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 https://leetcode.com/problems/add-two-numbers/
 */
public class ATNs {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarry(l1,l2,0);
    }

    public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry){
        int sum = l1.val + l2.val + carry;
        int currentVal = sum%10;
        int moved = sum/10;
        ListNode currentNext = null;

        if(l1.next != null || l2.next != null){
            l1.next = (l1.next == null) ? new ListNode(0):l1.next;
            l2.next = (l2.next == null) ? new ListNode(0):l2.next;
            currentNext = addTwoNumbersWithCarry(l1.next, l2.next, moved);
        }
        else if(moved > 0)
            currentNext = new ListNode(1);

        ListNode current = new ListNode(currentVal);
        current.next = currentNext;
        return current;
    }
}
