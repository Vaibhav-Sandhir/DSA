class Solution {
    public int rob(int[] nums) {
        int maxOfSub1 = nums[0];
        int maxOfSub2 = 0;
        int current = 0;
        int n = nums.length;

        for(int i = 1; i < n; i++){
            int temp = maxOfSub1;
            maxOfSub1 = Math.max(maxOfSub1, nums[i] + maxOfSub2);
            maxOfSub2 = temp;
        }

        return maxOfSub1;
    }
}
