package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class P414_ThirdMaximumNumber {

    /**
     * Inefficeint solutions
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length > 2) {
            List<Integer> distinct = new ArrayList<>();
            for (int i: nums) {
                if (!distinct.contains(i))
                    distinct.add(i);
            }
            if (distinct.size() > 2) {
                return distinct.get(distinct.size()-3);
            } else {
                return distinct.get(distinct.size()-1);
            }
        } else {
            return nums[nums.length-1];
        }
    }

    public int thirdMax2(int[] nums) {
        Integer first = null, second = null, third = null;
        for (int i : nums) {
            if (i == first || i == second || i == third)
                continue;
            if (first == null || i > first){
                third = second;
                second = first;
                first = i;
            }else if (second == null || i > second) {
                third = second;
                second = i;
            } else if (third == null || i > third) {
                third = i;
            }
        }
        if (third != null) {
            return third;
        }
        return first;

    }

    public int thirdMa3x(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size() < 3)
            return set.last();

        set.remove(set.last());
        set.remove(set.last());
        return set.last(); //return highest
    }
}
