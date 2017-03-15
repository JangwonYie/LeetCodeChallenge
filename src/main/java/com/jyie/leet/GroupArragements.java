package com.jyie.leet;

import java.util.*;

/**
 * Created by Jangwon Yie on 2017. 2. 12..
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.

 https://leetcode.com/problems/anagrams/
 */
public class GroupArragements {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> dict = new HashMap<String,Integer>();
        List<List<String>> result = new LinkedList<List<String>>();
        int length = strs.length;
        int currentP = 0;
        for(int i=0;i<length;i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);

            Integer position = dict.get(String.copyValueOf(str));

            if(null == position || position < 0){
                dict.put(String.copyValueOf(str), currentP);
                List<String> sub = new LinkedList();
                sub.add(strs[i]);
                result.add(sub);
                currentP++;
            }else{
                List<String> sub = result.get(position);
                sub.add(strs[i]);
                result.set(position, sub);
            }
        }
        return result;
    }
}
