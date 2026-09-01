"""

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

""";



import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if(token.equals("+") || token.equals("-")||token.equals("*")||token.equals("/")){
                int right=stack.pop();
                int left=stack.pop();
                int result=0;
                if(token.equals("+")){
                    result=left+right;
                }
                else if(token.equals("-")){
                    result=left-right;
                }
                else if(token.equals("*")){
                result=left*right;
                }
                else{
                    result=left/right;
                }
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}