package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 *
 * Created by kami on 2018. 3. 18..
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(nums.length == 0)
            return result;

        if(nums.length == 1){
            List<Integer> permutation = new LinkedList<Integer> ();
            permutation.add(nums[0]);
            result.add(permutation);
            return result;
        }

        for(int i=0;i<nums.length;i++){
            int head = nums[i];
            int[] nums_ = new int[nums.length - 1];
            System.arraycopy(nums,0,nums_,0,i );
            System.arraycopy(nums,i+1,nums_,i,nums.length-i - 1 );

            List<List<Integer>> recursion = permute(nums_);
            int length = recursion.size();
            for(int j=0;j<length;j++){
                List<Integer> sub_list = recursion.get(j);
                sub_list.add(0, head);
            }
            result.addAll(recursion);
        }

        return result;
    }

    public static void main(String[] args){

        Permutations pm = new Permutations();
        int[] nums = {1,2,3,4};

        System.out.println(pm.permute(nums));
    }
}
