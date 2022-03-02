package leetcode.math.easy;

public class P338_CountBits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int bitCounter = 0;
            int temp = i;
            while (temp > 0) {
                bitCounter += temp & 1;
                temp >>= 1;
            }
            ans[i] = bitCounter;
        }
        return ans;
    }
}
