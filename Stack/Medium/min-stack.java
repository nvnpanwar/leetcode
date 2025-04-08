// https://leetcode.com/problems/min-stack

class MinStack {
    Stack<Integer[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        Integer[] top = new Integer[2];
        
        if(stack.isEmpty()){
            top[0] = val;
            top[1] = val;
        }
        else{
            Integer[] topVal = stack.peek();
            top[0] = val;
            top[1] = Math.min(val, topVal[1]);
        }
        stack.push(top);
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        Integer[] val = stack.peek();
        return val[0];
    }
    
    public int getMin() {
        if(stack.isEmpty()){
            return -1;
        }
        Integer[] val = stack.peek();
        return val[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */