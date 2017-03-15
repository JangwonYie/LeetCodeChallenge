package com.jyie.leet;

import java.util.Arrays;

/**
 * This problem is offered by CodeFight(https://codefights.com).
 *
 * Note: Write a solution with O(n2) time complexity, since this is what you would be asked to do during a real interview.

 You have an array a composed of exactly n elements. Given a number x, determine whether or not a contains three elements for which the sum is exactly x.

 Example

 For x = 15 and a = [14, 1, 2, 3, 8, 15, 3], the output should be
 tripletSum(x, a) = false;

 For x = 8 and a = [1, 1, 2, 5, 3], the output should be
 tripletSum(x, a) = true.

 The given array contains the elements 1,2, and 5, which add up to 8.

 Input/Output

 [time limit] 3000ms (java)
 [input] integer x

 Constraints:
 1 ≤ x ≤ 3000.

 [input] array.integer a

 Constraints:
 3 ≤ a.length ≤ 1000,

 1 ≤ a[i] ≤ 1000.

 [output] boolean

 Return true if the array contains three elements that add up to x and false otherwise.


 * Created by Jangwon Yie on 3/9/17.
 */
public class TripletSum {
    boolean tripletSum(int x, int[] a) {

        if(a.length < 3)
            return false;

        Arrays.sort(a);

        int length = a.length;
        for(int i=0;i<length - 2;i++){
            int start = i+1;
            int end = length - 1;
            while(start < end){
                int flag = x - (a[i] +a[start] + a[end]);
                if(flag == 0)
                    return true;
                else if(flag > 0)
                    start++;
                else
                    end--;
            }
        }
        return false;
    }

}
