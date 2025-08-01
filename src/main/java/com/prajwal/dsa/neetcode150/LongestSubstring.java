package com.prajwal.dsa.neetcode150;

import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans=0,l=0,r=0;
        HashSet<Character> set=new HashSet<>();
        while(l<s.length() && r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}


