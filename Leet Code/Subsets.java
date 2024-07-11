class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        generate(list, 0, nums);
        return res;
    }

    public void generate(List<Integer> list, int i, int[] nums){
        if(i >= nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        generate(list, i + 1, nums);
        list.remove(list.size() - 1);
        generate(list, i + 1, nums);
    }
}
