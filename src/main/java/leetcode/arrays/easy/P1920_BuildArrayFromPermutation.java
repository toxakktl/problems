package leetcode.arrays.easy;

public class P1920_BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

}