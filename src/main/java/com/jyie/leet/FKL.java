package com.jyie.leet;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 *
 * Created by Jangwon Yie on 2018. 4. 8..
 */
public class FKL {
    public int findKthLargest(int[] nums, int k) {

        int size = nums.length;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)
            queue.offer(nums[i]);

        int current_kth = queue.peek();
        for(int i=k;i<size;i++){
            if(current_kth < nums[i]){
                queue.poll();
                queue.offer(nums[i]);
                current_kth = queue.peek();
            }
        }
        return queue.peek();
    }

}
