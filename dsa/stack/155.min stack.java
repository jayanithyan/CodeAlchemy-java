"""

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

""";



import java.util.*;

class MinStack {
    private Deque<Node> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            int currentMin = Math.min(val, stack.peek().min);
            stack.push(new Node(val, currentMin));
        }
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek().value;
    }
    public int getMin() {
        return stack.peek().min;
    }
}
class Node {
    int value;
    int min;
    Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}