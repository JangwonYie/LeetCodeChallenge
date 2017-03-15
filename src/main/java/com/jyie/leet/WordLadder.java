package com.jyie.leet;

import java.util.*;

/**
 * This problem is offered by CodeFight(https://codefights.com).
 *
 * Given two words, beginWord and endWord, and a wordList of approved words, find the length of the shortest transformation sequence from beginWord to endWord such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the wordList.
 Return the length of the shortest transformation sequence, or 0 if no such transformation sequence exists.

 Note: beginWord does not count as a transformed word. You can assume that beginWord and endWord are not empty and are not the same.

 Example

 For beginWord = "hit", endWord = "cog", and wordList = ["hot", "dot", "dog", "lot", "log", "cog"], the output should be
 wordLadder(beginWord, endWord, wordList) = 5.

 The shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with a length of 5.

 Input/Output

 [time limit] 3000ms (java)
 [input] string beginWord

 Constraints:
 1 ≤ beginWord.length ≤ 5.

 [input] string endWord

 Constraints:
 endWord.length = beginWord.length.

 [input] array.string wordList

 An array containing all of the approved words. All words in the array are the same length and contain only lowercase English letters. You can assume that there are no duplicates in wordList.

 Constraints:
 2 ≤ wordList.length ≤ 600,
 wordList[i].length = beginWord.length.

 [output] integer

 An integer representing the length of the shortest transformation sequence from beginWord to endWord using only words from wordList as described above.
 *
 * Created by Jangwon Yie on 3/9/17.
 */
public class WordLadder {

    int wordLadder(String beginWord, String endWord, String[] wordList) {

        if(beginWord.compareTo(endWord) == 0)
            return 0;

        Set<String> init = new HashSet ();
        init.add(beginWord);

        Map<Integer, Set<String>> info = buildReacharble(init, wordList);

        int size = info.keySet().size();
        for(int i=1;i<=size;i++){
            Set<String> neighbors = info.get(i);
            if(neighbors.contains(endWord))
                return i+1;
        }
        return 0;
    }


    private Set<String> buildNeighbors(String word, String[] wordList){
        Set<String> neighbors = new HashSet<String>();

        for(String str:wordList){
            if(word.length() != str.length())
                continue;

            char[] word_ = word.toCharArray();
            char[] str_ = str.toCharArray();

            int count = 0;
            for(int i=0;i<word_.length;i++){
                if(word_[i] != str_[i])
                    count++;
            }

            if(count == 1)
                neighbors.add(str);
        }

        return neighbors;
    }

    private Map<Integer,Set<String>> buildReacharble(Set<String> current, String[] wordList){
        Map<Integer, Set<String>> result = new HashMap();

        int distance = 1;
        boolean flag = true;
        Set<String> total = new HashSet();
        while(flag){
            total.addAll(current);
            Set<String> extended = new HashSet();
            for(String word:current){
                Set<String> neighbors = buildNeighbors(word, wordList);
                extended.addAll(neighbors);
            }
            if(total.containsAll(extended)){
                flag = false;
            }else {
                result.put(distance, extended);
                distance++;
                current = extended;
            }

        }
        return result;
    }


}
