package leetcode.arrays.easy;

public class P643_MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0.0;
        int n = nums.length;
        double maxSum = 0;
        for (int i = 0; i < k; i++){
            maxSum += nums[i];
        }
        double window_sum = maxSum;
        for (int i = k; i < n; i++) {
            window_sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, window_sum);
        }
        return maxSum/k;
    }

}
