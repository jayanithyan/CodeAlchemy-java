"""

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

""";


class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> visited=new HashMap<>();
        int left=0;
        int maxFrequency=0;
        int maxLength=0;
        for(int right=0;right<s.length();right++){
            char rch=s.charAt(right);
            visited.put(rch,visited.getOrDefault(rch,0)+1);
            maxFrequency=Math.max(maxFrequency,visited.get(rch));
            while((right-left+1)-maxFrequency>k){
                char lch=s.charAt(left);
                visited.put(lch,visited.get(lch)-1);
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}