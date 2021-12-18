package leetcode.dp.medium;

public class P55_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int lastGoodIndex = nums.length - 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex)
                lastGoodIndex = i;
        }
        return lastGoodIndex == 0;
    }
}
