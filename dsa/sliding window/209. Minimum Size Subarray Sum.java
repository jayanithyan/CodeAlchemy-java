"""

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

""";


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int minLength=Integer.MAX_VALUE;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                minLength=Math.min(minLength,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}