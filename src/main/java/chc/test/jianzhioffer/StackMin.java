package chc.test.jianzhioffer;

import java.util.Stack;

public class StackMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        Integer min = node;
        if (!stack.isEmpty() && min >= stackMin.peek()) {
            min = stackMin.peek();
        }
        stackMin.push(min);
        stack.push(node);
    }

    public void pop() {
        stackMin.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
