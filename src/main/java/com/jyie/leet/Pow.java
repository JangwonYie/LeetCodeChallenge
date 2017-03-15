package com.jyie.leet;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 * Implement pow(x, n).

 https://leetcode.com/problems/powx-n/
 */
public class Pow {

    public double myPow(double x, int n) {
        if(n < 0){
            n = (-1) * n;
            return (1.0) / positivePow(x, n);
        }else
            return positivePow(x,n);
    }

    private double positivePow(double x, int n){
        if(0 == n)
            return 1.0;
        if(1 == n)
            return x;

        return positivePow(x, n/2) * positivePow(x,n/2) * positivePow(x,n%2);
    }
}
