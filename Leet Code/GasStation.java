class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum_gas = 0;
        int sum_cost = 0;
        int total = 0;
        int starting_index = 0;
        int n = gas.length;

        for(int i = 0; i < n; i++){
            sum_gas += gas[i];
            sum_cost += cost[i];
        }

        if(sum_cost > sum_gas)
            return -1;

        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];

            if(total < 0){
                total = 0;
                starting_index = i + 1;
            }

        }
        return starting_index;    
    }
}
