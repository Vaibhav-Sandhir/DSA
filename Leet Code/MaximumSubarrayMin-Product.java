class Solution {
    public int maxSumMinProduct(int[] nums) {
        long ans = 0;
        long minProduct = 0;
        Stack<Data> stack = new Stack<>();
        int n = nums.length;
        long prefix[] = new long[n + 1];
        stack.push(new Data(nums[0], 0));

        for(int i = 0; i < n; i++){
            prefix[i + 1] = nums[i] + prefix[i];
        }

        for(int i = 1; i < n; i++){
            int ind = i;
            while(!stack.isEmpty() && nums[i] < stack.peek().value){
                Data data = stack.pop();
                ind = data.index;
                int start = data.index;
                int end = i;
                minProduct = data.value * (prefix[end] - prefix[start]);
                ans = Math.max(ans, minProduct);
            }
            stack.push(new Data(nums[i], ind));
        }

        while(!stack.isEmpty()){
            Data data = stack.pop();
            int start = data.index;
            int end = n;
            minProduct = data.value * (prefix[end] - prefix[start]);
            ans = Math.max(ans, minProduct);
        }

        return (int)(ans % 1_000_000_007);
    }
}

class Data{
    int value = 0;
    int index = 0;

    public Data(int value, int index){
        this.value = value;
        this.index = index;
    }
}
