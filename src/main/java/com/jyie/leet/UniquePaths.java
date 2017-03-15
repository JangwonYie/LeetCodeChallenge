package com.jyie.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 *  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    Map<Integer,Integer> cache = new HashMap<Integer,Integer>();

    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(m <= 1 || n <= 1)
            return 1;

        int key1 = m*1000 + n;
        if(null != cache.get(key1))
            return cache.get(key1);

        int key2 = m + n*1000;
        if(null != cache.get(key2))
            return cache.get(key2);

        int result = uniquePaths(m-1,n) + uniquePaths(m,n-1);
        cache.put(key1, result);

        return result;
    }
}
