package niuke.stack;

import java.util.Stack;

/**定义栈的数据结构
        请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。*/
public class MinTopStack {
    Stack<Integer> normalStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        normalStack.push(node);
        if(minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);
        }
    }

    public void pop() {
        if(!normalStack.isEmpty()) {
            int current = normalStack.peek();
            normalStack.pop();
            if (current == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!normalStack.isEmpty()) {
            return normalStack.peek();
        }
        return 0;
    }

    public int min() {
        if(!minStack.isEmpty()){
            //System.out.println(minStack.peek());
            return minStack.peek();
        }
        return 0;
    }
}
