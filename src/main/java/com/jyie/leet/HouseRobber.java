package com.jyie.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem is offered by CodeFight(https://codefights.com).
 *
 * You are planning to rob houses on a specific street, and you know that every house on the street has a certain amount of money hidden. The only thing stopping you from robbing all of them in one night is that adjacent houses on the street have a connected security system. The system will automatically trigger an alarm if two adjacent houses are broken into on the same night.

 Given a list of non-negative integers nums representing the amount of money hidden in each house, determine the maximum amount of money you can rob in one night without triggering an alarm.

 Example

 For nums = [1, 1, 1], the output should be
 houseRobber(nums) = 2.

 The optimal way to get the most money in one night is to rob the first and the third houses for a total of 2.

 Input/Output

 [time limit] 3000ms (java)
 [input] array.integer nums

 An array representing the amount of money that each house on the street has.

 Constraints:
 0 ≤ nums.length ≤ 100,
 0 ≤ nums[i] ≤ 500.

 [output] integer

 *
 * Created by Jangwon Yie on 3/9/17.
 */
public class HouseRobber {
    Map<Integer,Integer> cache = new HashMap();

    int houseRobber(int[] nums) {

        return houseRobber(nums, 0);
    }

    int houseRobber(int[] nums, int i){
        if(nums.length - i == 0)
            return 0;

        if(nums.length - i == 1)
            return nums[i];

        if(nums.length - i == 2)
            return (nums[i] > nums[i+1])?nums[i]:nums[i+1];

        Integer next2 = cache.get(i+2);
        int sum1;
        if(next2 == null){
            int next2_ = houseRobber(nums, i+2);
            sum1 = nums[i] + next2_;
            cache.put(i+2, new Integer(next2_));
        }else
            sum1 = nums[i] + next2.intValue();

        Integer next1 = cache.get(i+1);
        int sum2;
        if(next1 == null){
            int next1_ = houseRobber(nums, i + 1);
            sum2 = next1_;
            cache.put(i+1, new Integer(next1_));
        }else
            sum2 = next1.intValue();


        return (sum1>sum2)?sum1:sum2;
    }


}
