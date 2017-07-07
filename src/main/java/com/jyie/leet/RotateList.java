package com.jyie.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 *
 * Created by Jangwon Yie on 7/6/17.
 */
public class RotateList {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private void fillMap(List<ListNode> list, ListNode head){
        if(null == list)
            list = new LinkedList<ListNode>();

        int k = 0;
        while(true){
            if(null == head)
                break;
            list.add(k, head);
            k++;
            head = head.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(null == head)
            return null;
        List<ListNode> list = new LinkedList<ListNode> ();
        fillMap(list, head);

        int size = list.size();

        k = k % size;
        if(k == 0)
            return head;

        int i = size - k;
        int j = size - k - 1;

        ListNode nHead = list.get(i);
        ListNode nLast = list.get(j);

        nLast.next = null;
        ListNode cLast = list.get(size-1);
        cLast.next = list.get(0);
        return nHead;
    }

}
