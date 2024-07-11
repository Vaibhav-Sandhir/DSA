class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        return new int[]{binarySearch(left,right,nums,target,true), binarySearch(left,right,nums,target,false)};       
    }

    public int binarySearch(int left, int right, int[] nums, int target, boolean leftBias){
        int i = -1;

        while(left <= right){
            int middle = (left + right) / 2;

            if(nums[middle] == target){
                i = middle;
                if(leftBias)
                    right = middle - 1;
                else
                    left = middle + 1;        
            }

            else if(nums[middle] > target)
                right = middle - 1;

            else
                left = middle + 1;    
        }
        return i;
    }
}
