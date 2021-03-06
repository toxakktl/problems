package leetcode.strings.easy;

public class P125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))){
                return false;
            }
        }

        return true;
    }
}
