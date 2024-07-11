class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Data> stack = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        stack.push(new Data(temperatures[0], 0));

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek().temp){
                Data d = stack.pop();
                ans[d.index] = i - d.index;
            }
            stack.push(new Data(temperatures[i], i));
        }

        while(!stack.isEmpty()){
            Data d = stack.pop();
            ans[d.index] = 0;
        }

        return ans;
    }
}

class Data{
    int temp = 0;
    int index = 0;

    public Data(int temp, int index){
        this.temp = temp;
        this.index = index;
    }
}
