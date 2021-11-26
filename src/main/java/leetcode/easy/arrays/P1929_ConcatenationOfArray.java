package leetcode.easy.arrays;

public class P1929_ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {
        int[] res = new int[2*nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = res[i+nums.length] = nums[i];
        }
        return res;
    }
}
