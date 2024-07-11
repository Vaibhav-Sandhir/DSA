class Solution {
    public int searchInsert(int[] nums, int target) {
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
                index = middle + 1;
                left = middle + 1;
            }
            else{
                index = middle;
                right = middle - 1;
            }
        }

        return index;
    }
}
