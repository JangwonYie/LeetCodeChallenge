package com.jyie.leet;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 * Created by Jangwon Yie on 2017. 3. 2..
 */
public class FMRSA {

    public int findMin(int[] nums) {
        if(nums.length <= 1)
            return nums[0];

        for(int i=0;i<nums.length - 1;i++){
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }

        return nums[0];
    }
}
