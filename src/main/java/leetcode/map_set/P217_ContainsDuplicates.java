package leetcode.map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P217_ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.get(num) == null)
                map.put(num, 1);
            else
                return true;
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if (!set.add(num))
                return true;
        }
        return false;
    }
}
