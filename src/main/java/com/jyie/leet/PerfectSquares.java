package com.jyie.leet;

/**
 *
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * Created by Jangwon Yie on 2018. 4. 13..
 */
public class PerfectSquares {

    public int numSquares(int n) {
        if(n <= 0)
            return 0;

        int[] nums = new int[n];
        return numSquares(n, nums);
    }

    public int numSquares(int n, int[] nums){
        if(nums[n-1] != 0)
            return nums[n-1];

        int maxLoop = new Double(Math.sqrt(n)).intValue();
        if(maxLoop*maxLoop == n){
            nums[n - 1] = 1;
            return nums[n-1];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=maxLoop; i >=1 ; i--){
            int recur = numSquares(n - i*i,nums);
            if(recur == 1){
                answer = 1;
                break;
            }
            if(recur < answer){
                answer = recur;
            }
        }

        nums[n-1] = answer + 1;
        return nums[n-1];
    }
}
