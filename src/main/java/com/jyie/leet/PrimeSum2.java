package com.jyie.leet;

import java.util.*;

/**
 * Created by kami on 3/9/17.
 */
public class PrimeSum2 {

    List<Integer> primes = new LinkedList();
    Set<Integer> excluded = new HashSet();
    int primesSum2(int n) {
        int sum = 0;
        int modular = 1000000000+7;

        for(int i=2;i<=n; i++){
            if(excluded.contains(i))
                continue;
            if(isPrime(i)) {
                sum = sum + i;
                sum = sum % modular;
                exclude(n,i);
            }

        }

        return sum;
    }

    private void exclude(int n, int prime){
        int i=1;
        while(true){
            if(prime *i > n)
                return;
            excluded.add(prime * i);
            i++;
        }
    }

    private boolean isPrime(int k){
        if(k == 1)
            return false;

        double k_ = (double)k;
        double bound = Math.sqrt(k_);

        int size = primes.size();
        for(int i=0;i<size;i++){
            int prime = primes.get(i);
            if(prime > bound){
                primes.add(k);
                return true;
            }
            if(k%prime == 0)
                return false;
        }

        primes.add(k);
        return true;
    }



    public static void main(String[] args){
        PrimeSum2 ps2 = new PrimeSum2();
        System.out.println(ps2.primesSum2(6));
    }
}
