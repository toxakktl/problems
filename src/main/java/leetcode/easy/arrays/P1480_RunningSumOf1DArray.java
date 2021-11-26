package leetcode.easy.arrays;

public class P1480_RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length;i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
