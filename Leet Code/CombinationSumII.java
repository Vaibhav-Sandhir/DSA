class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        func(0, nums, target, new ArrayList<>());
        return result;    
    }

    private void func(int i, int nums[], int sum, List<Integer> list){
        if(sum == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(i >= nums.length || sum < 0){
            return;
        }
        
        list.add(nums[i]);
        func(i + 1, nums, sum - nums[i], list);
        list.remove(list.size() - 1);
        while(i < nums.length - 1 && nums[i] == nums[i + 1]){
            i++;
        }
        func(i + 1, nums, sum, list);
    } 
}
