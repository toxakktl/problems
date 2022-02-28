package leetcode.math.easy;

import java.util.HashMap;
import java.util.Map;

public class P136_SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i: nums){
            res = res ^ i;
        }
        return res;
    }
}
