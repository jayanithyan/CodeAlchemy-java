"""

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

""";


import java.util.HashMap;
class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        HashMap<Character,Integer> need=new HashMap<>();
        for(char ch:t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int needed=need.size();
        int formed=0;

        int start=0;
        int left=0;
        int minLength=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(need.containsKey(ch)){
                need.put(ch,need.get(ch)-1);
                if(need.get(ch)==0){
                    formed++;
                }
            }
            while(formed==needed){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    start=left;
                }
                char leftChar=s.charAt(left);
                if(need.containsKey(leftChar)){
                    if(need.get(leftChar)==0){
                        formed--;
                    }
                    need.put(leftChar,need.get(leftChar)+1);
                }
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(start,start+minLength);
    }
}