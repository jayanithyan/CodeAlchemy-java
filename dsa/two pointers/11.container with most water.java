"""
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
""";


class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max_area=0;
        while(left<right){
            int width=right-left;
            int min_height=Math.min(height[left],height[right]);
            int area=width*min_height;
            max_area=Math.max(area,max_area);
            if(height[right]>height[left]) left++;
            else right--;
        }
        return max_area;
        
    }
}