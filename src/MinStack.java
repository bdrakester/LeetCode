/**
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    private StackNode top;

    /**
     * Definition for stack node list.
     */
    private class StackNode {
        int val;
        int min;
        StackNode next;
        StackNode(int x) { val = x; }
    }


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        StackNode node = new StackNode(x);
        if (top == null) { node.min = x; }
        else if (top.min < x) { node.min = top.min; }
        else { node.min = x; }
        node.next = top;
        top = node;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
