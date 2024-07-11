class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty())
            min_stack.push(val);
        else if(val <= min_stack.peek())
            min_stack.push(val);    
    }
    
    public void pop() {
        int num = stack.pop();
        if(num == min_stack.peek())
            min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
