package com.jyie.leet;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 * Created by Jangwon Yie on 6/4/17.
 */
public class SRSA {

    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if(nums[0] == target)
            return 0;

        int previous = nums[0];
        int index = 1;
        boolean reset = false;
        while(index < nums.length){
            if(nums[index] == target)
                return index;

            if(reset && target < nums[index])
                return -1;

            if(!reset && previous > nums[index])
                reset = true;

            previous = nums[index];
            index++;
        }
        return -1;
    }
}
