package leetcode.arrays.easy;

public class P1470_ShuffleAnArray {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int temp = nums[0];
        int j = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = temp;
                temp = nums[++j];
            } else {
                res[i] = nums[n++];
            }
        }
        return res;
    }

    public int[] shuffle2(int[] nums, int n) {
        int[] res = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++){
            res[j++] = nums[i];
            res[j++] = nums[n+i];
        }
        return res;
    }
}
