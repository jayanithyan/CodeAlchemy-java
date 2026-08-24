"""

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.


""";



import java.util.ArrayList;
class Solution {
    private void mergesort(int low,int high,int []nums){
        if(low>=high) return;
        int mid=low+(high-low)/2;
        mergesort(low,mid,nums);
        mergesort(mid+1,high,nums);
        merge(low,mid,high,nums);
    }
    public int[] sortArray(int[] nums) {
        mergesort(0,nums.length-1,nums);
        return nums;
    }
    private void merge(int low,int mid,int high,int[] nums){
        int left=low;
        int right=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
}