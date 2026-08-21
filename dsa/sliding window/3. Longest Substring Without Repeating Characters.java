"""

Given a string s, find the length of the longest substring without duplicate characters.

""";

import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen=new HashSet<>();
        int left=0,maxlength=0,n=s.length();
        for(int right=0;right<n;right++){
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}