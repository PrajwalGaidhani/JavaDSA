package com.prajwal.dsa.mocktest;

//
//✅ Problem Summary:
//We are given a string of parentheses s containing only '(' and ')'.
//We want it to be balanced, where:
//
//Each '(' must be closed by two consecutive ')' characters ("))").
//
//        '(' must appear before its corresponding "))".

public class BalanceParanthese {
    public int isBalanced(String s) {
        int insertion = 0;
        int need = 0;
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='('){
                // If we already needed an odd number of ')',
                // it means we had one unpaired ')' earlier (like in "())")
                // To balance it, we insert one ')'
                if(need%2==1){
                    need--;
                    insertion++;
                }

//                if (neededRight % 2 != 0) {
//                    insertions++;   // Insert one ')'
//                    neededRight--;  // Now it's even
//                }

                need+=2;
            }else{
                need--;
                if(need<0){
                    insertion++;
                    need=1;
                }
            }
        }
        return insertion+need;
    }
}
