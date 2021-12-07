package leetcode.arrays.easy;

import java.util.Arrays;

public class P268_MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0)
            return -1;
        int[] res = new int[n+1];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            res[nums[i]] = 1;
        }
        for (int j = 0; j < n+1; j++){
            if (res[j] == -1)
                return j;
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int total = n * (n+1)/2;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return total - sum;
    }
}
