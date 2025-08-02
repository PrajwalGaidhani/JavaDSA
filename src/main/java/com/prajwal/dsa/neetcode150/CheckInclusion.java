package com.prajwal.dsa.neetcode150;

import java.util.HashMap;

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
     
                if (s1.length() > s2.length()) return false;

        HashMap<Character,Integer> cs1=new HashMap<>();
        HashMap<Character,Integer> cs2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            cs1.put(s1.charAt(i),cs1.getOrDefault(s1.charAt(i),0)+1);
            cs2.put(s2.charAt(i),cs2.getOrDefault(s2.charAt(i),0)+1);
            
        }
                if (cs1.equals(cs2)) return true;

        for(int l=s1.length();l<s2.length();l++){
           char newC=s2.charAt(l);
           char oldC=s2.charAt(l-s1.length());
           //Add new char
           cs2.put(newC,cs2.getOrDefault(newC,0)+1);
           //Remove old char
           cs2.put(oldC,cs2.get(oldC)-1);
           if(cs2.get(oldC)==0){
            cs2.remove(oldC);
           }
           if(cs1.equals(cs2)){
            return true;
           }
        }
        return false;
    }
}
