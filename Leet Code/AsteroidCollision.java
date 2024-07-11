class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = asteroids.length;
        ans.add(asteroids[0]);

        for(int i = 1; i < n; i++){
            int sign_arr = asteroids[i] / Math.abs(asteroids[i]);
            int sign_stack = (ans.size() != 0) ? ans.get(ans.size() - 1) / Math.abs(ans.get(ans.size() - 1)) : sign_arr;
            boolean flag = true;

            while(sign_stack == 1 && sign_arr == -1){
                int num1 = Math.abs(ans.get(ans.size() - 1));
                int num2 = Math.abs(asteroids[i]);
                if(num1 < num2){
                    ans.remove(ans.size() - 1);
                }
                else if(num1 == num2){
                    ans.remove(ans.size() - 1);
                    flag = false;
                    break;
                }
                else{
                    flag = false;
                    break;
                }
                sign_stack = (ans.size() != 0) ? ans.get(ans.size() - 1) / Math.abs(ans.get(ans.size() - 1)) : sign_arr;
            }

            if(flag){
                ans.add(asteroids[i]);
            }
        }

        n = ans.size();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }
}
