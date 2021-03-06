package leetcode.arrays.easy;

public class P28_strStr {

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        if (m < n)
            return -1;
        for (int i = 0; i <= m-n;++i) {
            int j;
            for (j = 0; j < n; ++j) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if (j == n)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
