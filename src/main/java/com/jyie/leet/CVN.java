package com.jyie.leet;

/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 *
 * Created by Jangwon Yie on 2017. 3. 2..
 */
public class CVN {

    public int compareVersion(String version1, String version2) {

        String[] version1_ = version1.split("\\.");
        String[] version2_ = version2.split("\\.");

        return compareVersion(version1_,version2_);
    }


    private int compareVersion(String[] version1, String[] version2){

        if(version1.length == 0 || version2.length == 0){
            if(version1.length != 0 ){
                version2 = new String[1];
                version2[0] = "0";
            }
            else if(version2.length != 0){
                version1 = new String[1];
                version1[0] = "0";
            }
            else
                return 0;
        }

        int first1 = Integer.parseInt(version1[0]);
        int first2 = Integer.parseInt(version2[0]);

        if(first1 > first2)
            return 1;
        else if(first1 < first2)
            return -1;

        String[] version1_ = new String[version1.length - 1];
        String[] version2_ = new String[version2.length - 1];

        System.arraycopy(version1, 1, version1_,0, version1.length-1);
        System.arraycopy(version2, 1, version2_,0, version2.length-1);

        return compareVersion(version1_,version2_);
    }
}
