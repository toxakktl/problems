package leetcode.strings.medium;

public class P647_PalindromicSubstrings {

    public static int countSubstrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += isPalindrome(str, i, i);
            count += isPalindrome(str, i, i+1);
        }
        return count;
    }

    private static int isPalindrome(String str, int start, int end) {
        int count = 0;
        while (start >= 0 && end <= str.length()-1 && str.charAt(start--) == str.charAt(end++))
            count++;
        return count;
    }

    public static int countSubstringsDp(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res++;
        }
        for (int i = 0; i < len-1; i++) {
            dp[i][i+1] = str.charAt(i) == str.charAt(i+1);
            if (dp[i][i+1])
                res++;
        }

        for (int n = 3; n <= len; n++) {
            for (int i = 0, j = i + len -1; j < n; i++, j++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i+1][j-1];
                if (dp[i][j])
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aabaa"));
    }
}
