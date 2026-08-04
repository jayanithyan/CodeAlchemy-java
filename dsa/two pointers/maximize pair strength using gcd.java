"""
You are given an integer array nums.

Choose exactly one pair of distinct indices i and j.
 The strength of the pair is defined as (nums[i] * nums[j]) / gcd(nums[i], nums[j])2.

Return the maximum strength over all possible pairs.
""";


class Solution {
    public long maxPairStrength(int[] nums) {
        long max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long g=gcd(nums[i],nums[j]);
                long strength=(1L*nums[i]*nums[j]/(g*g));
                max=Math.max(max,strength);
            }
        }
        return max;
    }
    private long gcd(long a,long b){
         while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}