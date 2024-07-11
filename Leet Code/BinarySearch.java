class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int index = 0;

        while(left <= right){
            int middle = (left + right) / 2;

            if(nums[middle] == target){
                return middle;
            }
            else if(nums[middle] < target){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }

        return -1;
    }
}
