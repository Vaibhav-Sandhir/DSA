class MyStack {
    Queue<Integer> queue = new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
      queue.add(x);  
    }
    
    public int pop() {
        int n = queue.size();
        for(int i = 0; i < n - 1; i++){
            queue.add(queue.remove());
        }
        return queue.remove();
    }
    
    public int top() {
        int n = queue.size();
        for(int i = 0; i < n - 1; i++){
            queue.add(queue.remove());
        }
        int ans = queue.peek();
        queue.add(queue.remove());
        return ans;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
