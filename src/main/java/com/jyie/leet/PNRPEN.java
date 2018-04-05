package com.jyie.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jangwon Yie on 4/4/18.
 */
public class PNRPEN {

    private static class TreeLinkNode{
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {

        if(null == root)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);

        while(null != queue){
            queue = connect(queue);
        }
    }

    private Queue<TreeLinkNode> connect(Queue<TreeLinkNode> queue){
        if(null == queue)
            return null;

        Queue<TreeLinkNode> populated = null;

        TreeLinkNode node = queue.poll();
        while(null != node){
            if(null == populated)
                populated = new LinkedList<TreeLinkNode> ();

            populated.offer(node.left);
            populated.offer(node.right);

            TreeLinkNode next = queue.poll();
            node.next = next;
            node = next;
        }
        return populated;
    }
}
