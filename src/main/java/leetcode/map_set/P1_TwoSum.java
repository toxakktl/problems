package leetcode.map_set;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            if (map.get(val) != null){
                res[0] = i;
                res[1] = map.get(val);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
