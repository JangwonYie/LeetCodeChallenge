package com.jyie.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jangwon Yie on 2017. 2. 14..
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 https://leetcode.com/problems/gray-code/
 */
public class GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(0 == n){
            result.add(0);
            return result;
        }

        if(1 == n){
            result.add(0);
            result.add(1);
            return result;
        }

        List<Integer> current = grayCode(n-1);
        int size = current.size();

        for(int i=0;i<size;i++)
            result.add(current.get(i));

        for(int i=size-1;i >=0;i--){
            int value = current.get(i) + (int)Math.pow(2,n-1);
            result.add(value);
        }

        return result;
    }
}
