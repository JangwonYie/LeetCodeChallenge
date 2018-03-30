package com.jyie.leet;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by Jangwon Yie on 2018. 3. 30..
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int length = s.length();

        Stack<Character> stack = new Stack<Character> ();
        for(int i=0;i<length;i++){
            char c = s.charAt(i);

            if(c == '(' || c== '{' || c== '['){
                stack.push(c);
            }else if(c == ')' || c== '}' || c== ']'){
                if(stack.empty())
                    return false;
                char current_open = stack.pop();
                if(c != getMirror(current_open))
                    return false;
            }
        }

        if(stack.empty())
            return true;
        else
            return false;
    }

    private char getMirror(char c){
        if(c == '(')
            return ')';
        if(c == '{')
            return '}';
        if(c == '[')
            return ']';
        return ' ';
    }
}
