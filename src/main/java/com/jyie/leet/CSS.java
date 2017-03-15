package com.jyie.leet;

/**
 * 523. Continuous Subarray Sum
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 */
public class CSS {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1)
            return false;

        int first = nums[0];
        int[] next = new int[nums.length - 1];
        System.arraycopy(nums,1,next,0,nums.length-1);
        int subSum = 0;
        for(int i=0;i < next.length;i++){
            subSum = subSum + next[i];
            if(k != 0 && (subSum + first) % k == 0)
                return true;
            if(k==0 && first + subSum == 0)
                return true;
        }
        return checkSubarraySum(next, k);
    }

}
