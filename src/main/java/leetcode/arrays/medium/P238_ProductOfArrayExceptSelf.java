package leetcode.arrays.medium;

public class P238_ProductOfArrayExceptSelf {

    /**
     * Inefficient
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            res[i] = product;
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0)
            return res;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];

        }
        return res;
    }

    public int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (nums == null || n == 0)
            return res;
        //count lefts, product of all numbers to the left
        int[] lefts = new int[n];
        lefts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = lefts[i-1] * nums[i-1];
        }

        //count right, product of all numbers to the right
        int[] rights = new int[n];
        rights[n-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rights[i] = rights[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = lefts[i] * rights[i];
        }
        return res;
    }
}
