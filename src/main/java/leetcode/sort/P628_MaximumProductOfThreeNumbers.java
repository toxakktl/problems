package leetcode.sort;

import java.util.Arrays;

public class P628_MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3)
            throw new IllegalArgumentException("Invalid input");
        Arrays.sort(nums);
        int N = nums.length;
        return Math.max(nums[0] * nums[1] * nums[N-1], nums[N-1] * nums[N-2] * nums[N-3]);
    }
}
