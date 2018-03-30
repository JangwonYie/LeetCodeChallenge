package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 *
 *
 * Created by Jangwon Yie on 7/12/17.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(n-k < 0)
            return result;

        if(k == 1){
            for(int i=1;i<=n;i++){
                List<Integer> list = new LinkedList<Integer> ();
                list.add(i);
                result.add(list);
            }
            return result;
        }

        List<List<Integer>> subs = combine(n-1,k-1);
        for(List<Integer> sub: subs){
            List<Integer> sub_ = new LinkedList<Integer> ();
            sub_.addAll(sub);
            sub_.add(n);
            result.add(sub_);
        }

        result.addAll(combine(n-1,k));

        return result;
    }
}
