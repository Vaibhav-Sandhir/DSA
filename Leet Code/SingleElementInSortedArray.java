class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left <= right){
            int middle = (left + right) / 2;

            if(middle - 1 >= 0 && nums[middle] == nums[middle - 1]){
                int count = right - middle;
                if(count % 2 == 0){
                    right = middle - 2;
                }
                else{
                    left = middle + 1;
                }
            }

            else if (middle + 1 < n && nums[middle] == nums[middle + 1]){
                int count = middle - left;
                if(count % 2 == 0){
                    left = middle + 2;
                }
                else{
                    right = middle - 1;
                }
            }

            else{
                return nums[middle];
            }
        }
        return -1;
    }
}
