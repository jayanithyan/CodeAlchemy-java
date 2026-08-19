"""

Given a string s, return true if the s can be palindrome
 after deleting at most one character from it.

""";


class Solution {
    public boolean validPalindrome(String s) {
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return ispalindrome(s,start+1,end) || ispalindrome(s,start,end-1);
            start++;
            end--;
        }
        return true;
    }
    private boolean ispalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--; 
        }
        return true;
    }
}