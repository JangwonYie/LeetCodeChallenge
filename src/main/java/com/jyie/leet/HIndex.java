package com.jyie.leet;

import java.util.Arrays;

/**
 * Created by Jangwon Yie on 2017. 3. 24..
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int length = citations.length;
        int i=0;
        int index = 0;
        while(i<length){
            int j = length - 1 - i;

            if(citations[j] >= i+1) {
                index = i + 1;
            }else
                break;
            i++;
        }
        return index;
    }
}
