class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int i = target - 1;

        while(i >= 0){
            if(target - i <= nums[i]){
                target = i;
                i = target - 1;
            }

            else{
                i--;
            }
        }

        return target == 0;
    }
}
