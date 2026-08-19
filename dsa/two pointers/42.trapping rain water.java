"""

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

""";



class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxWater=0;
        int leftMax=0;
        int rightMax=0;
        while(left<=right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                maxWater+=leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }
                else{
                    maxWater+=rightMax-height[right];
                }
                right--;
            }
        }
        return maxWater;
    }
}