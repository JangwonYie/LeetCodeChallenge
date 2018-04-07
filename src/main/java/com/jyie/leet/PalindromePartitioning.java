package com.jyie.leet;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 * Created by Jangwon Yie on 4/7/18.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        if(null == s || s.length() == 0)
            return null;

        List<List<String>> list = new LinkedList<List<String>>();
        char[] chars = s.toCharArray();

        if(chars.length == 1){
            List<String> subList = new LinkedList<String> ();
            subList.add(s);
            list.add(subList);
            return list;
        }

        char first = chars[0];

        int next = 0;
        while(next >= 0){
            next = s.indexOf(first,next);
            if(next < 0)
                return list;
            String subStr = s.substring(0,next + 1);

            if(isPalindrome(subStr)){
                String s__ = s.substring(next+1);
                List<List<String>> list_;
                if(null == s__ || s__.length() == 0){
                    list_ = new LinkedList<List<String>> ();
                    List<String> subList = new LinkedList<String> ();
                    subList.add(0,subStr);
                    list_.add(subList);
                }else{
                    list_ = partition(s__);
                    if(null != list_){
                        for(List<String> sub : list_){
                            sub.add(0,subStr);
                        }
                    }
                }
                if(null != list_)
                    list.addAll(list_);
            }
            next++;
        }
        return list;
    }

    private boolean isPalindrome(String s){
        char[] chars = s.toCharArray();

        int length = chars.length;
        if(length == 1)
            return true;
        for(int i=0;i<length/2;i++){
            if(chars[i] != chars[length-i-1])
                return false;
        }
        return true;
    }
}
