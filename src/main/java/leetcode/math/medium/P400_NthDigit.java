package leetcode.math.medium;

public class P400_NthDigit {

    public static int findNthDigit1(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringBuilder inner = new StringBuilder();
            int j = i;
            while (j != 0) {
                inner.append(j % 10);
                j /= 10;
            }
            sb.append(inner.reverse());
        }
        return Integer.parseInt(String.valueOf(sb.toString().charAt(n - 1)));
    }

    public static int findNthDigit(int n) {
        int len = 1, i = 1;
        long range = 9;
        while (n > len * range) {
            n -= len * range;
            len++;
            range *= 10;
            i *= 10;
        }
        i += (n-1)/len;
        String s = Integer.toString(i);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }



    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
    }
}
