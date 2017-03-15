package com.jyie.leet;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * Created by Jangwon Yie on 2017. 3. 14..
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new LinkedList();

        int length = nums.length;
        if(length < 3)
            return result;

        Arrays.sort(nums);

        for(int i=0;i<length-2;i++){
            if(i!=0 && nums[i] == nums[i-1])
                continue;

            int f = nums[i];
            int start = i+1;
            int end = length - 1;
            boolean s_init = true;
            while(start < end){
                if(!s_init && nums[start] == nums[start-1]) {
                    start++;
                    continue;
                }

                int sum = nums[start] + nums[end];
                int current = sum + f;
                if(current == 0){
                    List<Integer> sol = new LinkedList();
                    sol.add(f);
                    sol.add(nums[start]);
                    sol.add(nums[end]);
                    result.add(sol);
                    start++;
                    s_init = false;
                    continue;
                }

                if(current < 0)
                    start++;
                else
                    end--;
            }
        }
        return result;
    }
}


