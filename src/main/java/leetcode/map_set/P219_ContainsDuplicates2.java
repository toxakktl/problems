package leetcode.map_set;

import java.util.HashMap;
import java.util.Map;

public class P219_ContainsDuplicates2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                if (Math.abs(map.get(nums[i]) - i) <= k)
                    return true;

            }
            map.put(nums[i], i);
        }
        return false;
    }
}
