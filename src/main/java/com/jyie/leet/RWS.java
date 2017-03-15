package com.jyie.leet;

/**
 * 153. Reverse Words in a String
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 * Created by Jangwon Yie on 2017. 3. 3..
 */
public class RWS {
    
    public String reverseWords(String s) {
        if(null == s)
            return null;

        String[] split = s.split("\\s");
        StringBuffer sb = new StringBuffer();

        int length = split.length;
        for(int i=length-1;i>=0;i--){
            if(split[i].length() == 0)
                continue;
            if(i != length -1)
                sb.append(" ");

            sb.append(split[i]);
        }
        return sb.toString();
    }
}
