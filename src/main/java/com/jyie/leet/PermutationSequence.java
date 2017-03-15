package com.jyie.leet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This problem is offered by CodeFight(https://codefights.com).
 *
 * The set [1, 2, 3, ... , n] contains a total of n! unique permutations. List all the permutations for an integer n in lexicographical order and return the kth permutation in the sequence.

 Example

 For n = 3 and k = 3, the output should be
 permutationSequence(n, k) = "213".

 The ordered list of possible permutations for 3! is:

 1) "123"
 2) "132"
 3) "213"
 4) "231"
 5) "312"
 6) "321"
 The 3rd permutation in the lexicographically ordered sequence is "213".

 Input/Output

 [time limit] 3000ms (java)
 [input] integer n

 Constraints:
 1 ≤ n ≤ 9.

 [input] integer k

 Constraints:
 1 ≤ k ≤ 40000.

 [output] string

 A string representing the kth item in the lexicographically ordered permutation sequence for n!.
 * Created by Jangwon Yie on 3/9/17.
 */
public class PermutationSequence {
    String permutationSequence(int n, int k) {

        StringBuffer sb = new StringBuffer();
        permutationSequence_(sb, new NumberW(n),k-1);

        return sb.toString();
    }

    private static class NumberW{

        List<Integer> list;

        NumberW(int n){
            list = new ArrayList<Integer>();
            for(int i=1;i<=n;i++){
                list.add(i);
            }
        }

        private void remove(int i){
            list.remove(i);
        }

        private int getSize(){
            return list.size();
        }

        private int get(int i){
            return list.get(i);
        }
    }

    private void permutationSequence_(StringBuffer sb, NumberW numW, int k){
        int n = numW.getSize();
        if(n==0)
            return;

        int module = factorial(n-1);

        int index = k/module;
        int k_ = k%module;

        int n_ = numW.get(index);

        sb.append(n_);
        numW.remove(index);

        permutationSequence_(sb,numW,k_ );
    }

    private int factorial(int n){

        if(n==1 || n==0)
            return 1;

        return n*factorial(n-1);
    }
}
