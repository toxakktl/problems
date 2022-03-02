package leetcode.dp.easy;

public class P303_RangeSumQuery {

    private int[] sums;

    public P303_RangeSumQuery(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        sums = nums;
    }
    public int sumRange(int left, int right) {
        if (left == 0)
            return sums[right];
        return sums[right] - sums[left-1];
    }

}
