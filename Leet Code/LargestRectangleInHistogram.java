class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Data> stack = new Stack<>();
        stack.push(new Data(0, heights[0]));

        for(int i = 1; i < n; i++){
            int ind = i;
            while(!stack.isEmpty() && heights[i] < stack.peek().height){
                Data data = stack.pop();
                max = Math.max(max, data.height * (i - data.index));
                ind = data.index;
            }
            stack.push(new Data(ind, heights[i]));    
        }

        while(!stack.isEmpty()){
            Data data = stack.pop();
            max = Math.max(max, data.height * (n - data.index));
        }

        return max;
    }
}

class Data{
    int height;
    int index;
    public Data(int index, int height){
        this.height = height;
        this.index = index;
     }  
}
