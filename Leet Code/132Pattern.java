class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Data> stack = new Stack<>();
        int currMin = nums[0];
        stack.push(new Data(nums[0], currMin));

        for(int i = 1; i < n; i++){
            currMin = Math.min(currMin, nums[i]);
            while(!stack.isEmpty() && nums[i] >= stack.peek().value){
                stack.pop();
            }
            if(!stack.isEmpty() && nums[i] < stack.peek().value && nums[i] > stack.peek().min){
                return true;
            }
            stack.push(new Data(nums[i], currMin));
        }
        
        return false;
    }
}

class Data{
    int value;
    int min;

    public Data(int value, int min){
        this.value = value;
        this.min = min;
    }
}
