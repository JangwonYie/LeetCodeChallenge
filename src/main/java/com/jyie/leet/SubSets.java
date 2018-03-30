package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 *
 *
 * Created by Jangwon Yie on 2018. 3. 29..
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;

        List<List<Integer>> baseList = new LinkedList<List<Integer>>();
        if(length == 0)
            return baseList;

        if(length == 1){
            List<Integer> base1 = new LinkedList<Integer> ();
            List<Integer> base2 = new LinkedList<Integer> ();

            base1.add(nums[0]);

            baseList.add(base1);
            baseList.add(base2);
            return baseList;
        }

        int first = nums[0];
        int[] numsFromSecond = new int[length - 1];
        System.arraycopy(nums,1,numsFromSecond,0,length-1);

        List<List<Integer>> recursiveList = subsets(numsFromSecond);
        List<List<Integer>> result = new LinkedList<List<Integer>> ();

        for(List<Integer> list:recursiveList){
            List<Integer> copyList = copy(list);
            list.add(first);
            result.add(list);
            result.add(copyList);
        }

        return result;
    }

    private List<Integer> copy(List<Integer> list){
        if(null == list)
            return null;
        List<Integer> clone = new LinkedList<Integer> ();
        for(Integer num:list){
            int copy = num.intValue();
            clone.add(copy);
        }
        return clone;
    }
}
