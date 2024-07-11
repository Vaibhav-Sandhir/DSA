class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        int row = 0;
        map.put(row, new HashSet<>());

        for(int i = 0; i < nums.length; i++){
            int j = 0;
            for(j = 0; j <= row; j++){
                HashSet<Integer> set = map.get(j);
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    list.get(j).add(nums[i]);
                    break;
                }
            }
            if(j > row){
                row++;
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(nums[i]);
                map.put(row, set);
                list.add(new ArrayList<>());
                list.get(j).add(nums[i]);
            }
        }

        return list;
    }
}
