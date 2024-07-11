class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        int m = nums1.length;
        int ans[] = new int[m];
        stack.push(nums2[0]);

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                int num = stack.pop();
                map.put(num, nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            int num = stack.pop();
            map.put(num, -1);
        }

        for(int i = 0; i < m; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
