class FreqStack {
    Map<Integer, Integer> counts;
    Map<Integer, Stack<Integer>> groups;
    int maxCount;

    public FreqStack() {
        counts = new HashMap<>();
        groups = new HashMap<>();
        maxCount = 0;
    }
    
    public void push(int val) {
        int count = 1;
        if(counts.containsKey(val)){
            count = 1 + counts.get(val);
        }
        counts.put(val, count);

        if(count > maxCount){
            maxCount = count;
            groups.put(maxCount, new Stack<>());
        }

        groups.get(count).push(val);
    }
    
    public int pop() {
        int result = groups.get(maxCount).pop();
        int freq = counts.get(result) - 1;
        counts.put(result, freq);

        if(groups.get(maxCount).isEmpty()){
            maxCount--;
        }

        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
