"""

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

""";


import java.util.ArrayList;
class Solution {
    private void subset(int i,int[] nums,ArrayList<Integer> arr,List<List<Integer>> result){
        if(i>=nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        subset(i+1,nums,arr,result);
        arr.remove(arr.size()-1);
        subset(i+1,nums,arr,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        subset(0,nums,arr,result);
        return result;
    }
}