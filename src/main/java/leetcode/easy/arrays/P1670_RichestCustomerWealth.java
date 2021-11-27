package leetcode.easy.arrays;

public class P1670_RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int wealth = 0;
            for (int sum : account) {
                wealth += sum;
            }
            max = Math.max(max, wealth);
        }
        return max;
    }

}
