class Solution {
    public int search(int[] nums, int target) {
        int partition = 0;
        int n = nums.length;
        int i = 0;
        for(i = 0; i < n && i + 1 < n; i++){
            if(nums[i] > nums[i + 1])
                break;
        }
        if(i == n -1)
            return binary_search(target, nums, 0, n - 1);
        int res1 = binary_search(target, nums, 0, i);
        int res2 = binary_search(target, nums, i + 1, n - 1);

        if(res1 == -1 && res2 == -1)
            return -1;
        else if(res1 == -1)
            return res2;
        else
            return res1;        
    }

    public int binary_search(int target, int[] nums, int start, int end){
        while(start <= end){
            int middle = (start + end) / 2;
            
            if(nums[middle] == target)
                return middle;

            else if(nums[middle] > target)
                end = middle - 1;

            else
                start = middle + 1;        
        }
        return -1;
    }
}
