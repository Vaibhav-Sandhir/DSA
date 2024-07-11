class MyCircularQueue {
    int arr[];
    int front = -1;
    int rear = -1;
    int n = 0;

    public MyCircularQueue(int k) {
        this.n = k;
        this.arr = new int[n];    
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        if(isEmpty()){
            front = 0;
            rear = 0;
        }
        else{
            rear = (rear + 1) % n;
        }

        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        if(front == rear){
            front = -1;
            rear = -1;
        }
        else{
            front = (front + 1) % n;
        }

        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % n == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
