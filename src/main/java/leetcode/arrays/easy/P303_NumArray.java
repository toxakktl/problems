package leetcode.arrays.easy;

public class P303_NumArray {
    int[] nums = null;

    public P303_NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return nums[right];
        return nums[right] - nums[left-1];
    }
}
