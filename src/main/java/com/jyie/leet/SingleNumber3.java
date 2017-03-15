package com.jyie.leet;

import java.util.Arrays;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 Comment:
 Since my solution requires sorting, it does not satisfy linear runtime complexity condition.
 *
 * Created by Jangwon Yie on 2017. 3. 15..
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);

        int[] result = new int[2];
        int i=0;
        int k=0;
        while(i<nums.length){
            if(i == nums.length-1) {
                result[k] = nums[i];
                i++;
            }else if(nums[i] == nums[i+1])
                i = i+2;
            else{
                result[k] = nums[i];
                k++;
                i++;
            }
        }
        return result;
    }
}
