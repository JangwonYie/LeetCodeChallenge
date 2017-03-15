package com.jyie.leet;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Created by Jangwon Yie on 2017. 3. 14..
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;

        Arrays.sort(nums);

        int value = nums[0] + nums[1] + nums[2];
        int closest = abs(target - value);
        for(int i=0;i<length-2;i++){
            int f = nums[i];
            int start = i+1;
            int end = length - 1;
            while(start < end){
                int sum = nums[start] + nums[end];
                int current = sum + f;
                if(current == target)
                    return target;
                if(current < target)
                    start++;
                else
                    end--;

                int dist = abs(current - target);
                if(dist < closest){
                    closest = dist;
                    value = current;
                }
            }
        }
        return value;
    }

    private int abs(int i){
        return (i>0)?i:(-1)*i;
    }
}
