package com.jyie.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UBST {

    Map<Integer,Integer> cache = new HashMap<Integer,Integer>();

    public int numTrees(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        if(null != cache.get(n))
            return cache.get(n);

        int sum = 0;
        sum = sum + 2 * numTrees(n-1);

        for(int i=2;i<n;i++)
            sum = sum + (numTrees(i-1) * numTrees(n-i));

        cache.put(n,sum);
        return sum;
    }
}
