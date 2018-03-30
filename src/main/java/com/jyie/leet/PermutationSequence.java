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
 * update by Jangwon Yie on 3/29/18.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {

        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = i+1;
        }

        StringBuffer result = getPermutation(array,k);
        return result.toString();
    }

    private StringBuffer getPermutation(int[] array, int k){
        int length = array.length;

        if(length == 1){
            StringBuffer sb = new StringBuffer();
            sb.append(array[0]);
            return sb;
        }

        int first = getFirstIndex(length, k);
        int[] remains = new int[length - 1];

        System.arraycopy(array, 0, remains, 0, first);
        System.arraycopy(array, first+1, remains, first, length - first-1);

        int firstNumber = array[first];
        StringBuffer firstBuffer = new StringBuffer();
        firstBuffer.append(firstNumber);
        StringBuffer sb = getPermutation(remains, getNextIndex(length,k));
        firstBuffer.append(sb);

        return firstBuffer;
    }

    private int getFirstIndex(int n, int k){
        int module = factorial(n-1);
        return (k-1)/module;
    }

    private int getNextIndex(int n, int k){
        int module = factorial(n-1);
        int temp = k%module;
        if(0 != temp)
            return temp;
        else
            return temp + module;
    }

    private int factorial(int k){
        if(k<=1)
            return 1;
        return k*factorial(k-1);
    }
}
