class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double dest = target;
        int n = speed.length;
        Stack<Data> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        for(int i = 0; i < n; i++){
            speed[i] = map.get(position[i]);
        }
        stack.push(new Data(position[0], speed[0]));
        int count = 0;

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty()){
                Data data = stack.peek();
                if(data.speed > speed[i]){
                    double relative_speed = data.speed - speed[i];
                    double time = (position[i] - data.position) / relative_speed;
                    double distance = (data.speed * time) + data.position;
                    if(distance <= dest){
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
            stack.push(new Data(position[i], speed[i]));
        }

        while(!stack.isEmpty()){
            count++;
            stack.pop();
        }

        return count;
    }
}

class Data{
    int position = 0;
    int speed = 0;

    public Data(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}
