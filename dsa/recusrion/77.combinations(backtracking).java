"""

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
""";



import java.util.ArrayList;
class Solution {
    private void backtrack(int i,int[] nums,ArrayList<Integer> arr1,List<List<Integer>> result,int k){
            if(arr1.size()==k){
                result.add(new ArrayList<>(arr1));
                return;
            }
        for(int l=i;l<nums.length;l++){
            arr1.add(nums[l]);
            backtrack(l+1,nums,arr1,result,k);
            arr1.remove(arr1.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arr1=new ArrayList<>();
        backtrack(0,arr,arr1,result,k);
        return result;

    }
}