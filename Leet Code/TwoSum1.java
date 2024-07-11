import java.util.*;

public class TwoSum {
    public static int[] towSum(int[] array,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(array[i], i);
        }
        return null;
    }
}
