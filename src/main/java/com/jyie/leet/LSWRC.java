package com.jyie.leet;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by Jangwon Yie on 2017. 3. 14..
 */
public class LSWRC {
    public int lengthOfLongestSubstring(String s) {
        if(null == s)
            return 0;
        if(s.length() <= 1)
            return s.length();

        String longest = "";
        String current = "";

        char[] chars = s.toCharArray();
        int length = chars.length;
        int i=0;
        int cIndex=0;
        while(i<length){
            char c = chars[i];
            int index = current.indexOf(c);
            if(index < 0){
                current = current + c;
                i++;
            }
            else{
                if(current.length() > longest.length())
                    longest = new String(current);
                current = "";
                i = cIndex + index + 1;
                cIndex = i;
            }
        }

        if(current.length() > longest.length())
            return current.length();

        return longest.length();
    }
}
