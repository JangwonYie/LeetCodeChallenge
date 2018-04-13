package com.jyie.leet;

/**
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?


 * Created by Jangwon Yie on 2018. 4. 13..
 */
public class HIndex2 {

    public int hIndex(int[] citations) {
        int length = citations.length;
        int hIndex = 0;
        while(length - 1 -hIndex >= 0){
            if(citations[length - 1 - hIndex] <= hIndex)
                break;
            hIndex++;
        }
        return hIndex;
    }
}
