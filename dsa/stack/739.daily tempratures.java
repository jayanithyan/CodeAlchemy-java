"""

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

""";


import java.util.Stack;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stck=new Stack<>();
        int[] answer=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stck.isEmpty() && temperatures[i]>temperatures[stck.peek()]){
                int index=stck.pop();
                answer[index]=i-index;
            }
            stck.push(i);
        }
        return answer;
    }
}