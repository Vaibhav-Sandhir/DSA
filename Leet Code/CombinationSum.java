class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        func(0, 0, target, nums, new ArrayList<>(), result);
        return result;
    }

    private void func(int i, int sum, int target, int nums[], List<Integer> list, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(i >= nums.length || sum > target){
            return;
        }

        list.add(nums[i]);
        func(i, sum + nums[i], target, nums, list, result);
        list.remove(list.size() - 1);
        func(i + 1, sum, target, nums, list, result);
    }
}
