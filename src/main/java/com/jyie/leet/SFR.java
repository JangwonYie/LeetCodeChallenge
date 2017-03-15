package com.jyie.leet;

/**
 *
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * Created by Jangwon Yie on 3/14/17.
 */
public class SFR {

    public int[] searchRange(int[] nums, int target) {
        SE se = searchRange(nums, 0, nums.length, target);
        if(null == se){
            int[] zero = {-1,-1};
            return zero;
        }


        int[] result = new int[2];
        result[0] = se.start;
        result[1] = se.end-1;

        return result;
    }

    private SE searchRange(int[] nums, int start, int end, int target){

        if(start >= end)
            return null;

        int middle = (start + end)/2;

        if(nums[middle] > target){
            return searchRange(nums, start, middle, target);
        }else if(nums[middle] < target){
            return searchRange(nums, middle+1, end, target);
        }else{
            SE firstHalf = searchRange(nums, start, middle, target);
            SE secondHalf = searchRange(nums, middle+1, end, target);
            SE se = new SE();
            if(null != firstHalf)
                se.start = firstHalf.start;
            else
                se.start = middle;

            if(null != secondHalf)
                se.end = secondHalf.end;
            else
                se.end = middle + 1;

            return se;
        }
    }

    private static class SE{
        int start;
        int end;
    }
}
