package com.jyie.leet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 *
 *
 * Created by Jangwon Yie on 2018. 3. 30..
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new LinkedList<List<Integer>> ();

        if(nums.length == 1){
            List<Integer> perm = new LinkedList<Integer>();
            perm.add(nums[0]);
            result.add(perm);
            return result;
        }

        int[] nums_ = new int[nums.length - 1];
        Set<Integer> duplicateChecker = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(duplicateChecker.contains(num))
                continue;
            else
                duplicateChecker.add(num);
            System.arraycopy(nums,0, nums_,0, i);
            if(nums.length-1-i>0)
                System.arraycopy(nums,i+1,nums_,i,nums.length-1-i);

            List<List<Integer>> recurse = permuteUnique(nums_);

            for(List<Integer> each:recurse){
                each.add(0,num);
                result.add(each);
            }
        }
        return result;
    }
}
