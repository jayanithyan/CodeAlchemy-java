"""

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

""";


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] character=new int[26];
        for(int i=0;i<s1.length();i++){
            character[s1.charAt(i)-'a']--;
            character[s2.charAt(i)-'a']++;
        }
        if(isZero(character)) return true;
        for(int right=s1.length();right<s2.length();right++){
            character[s2.charAt(right)-'a']++;
            character[s2.charAt(right-s1.length())-'a']--;
            if(isZero(character)) return true;
        }
        return false;
    }
    private boolean isZero(int[] character){
        for(int num:character){
            if(num!=0) return false;
        }
        return true;
    }
}