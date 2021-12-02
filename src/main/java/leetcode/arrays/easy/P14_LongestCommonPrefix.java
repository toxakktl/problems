package leetcode.arrays.easy;

public class P14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String lcp = strs[0];
        for (int j = 1; j < strs.length; j++) {
            int minLen = Math.min(lcp.length(), strs[j].length());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minLen; i++) {
                if (lcp.charAt(i) == strs[j].charAt(i)){
                    sb.append(lcp.charAt(i));
                } else {
                    break;
                }
            }
            lcp = sb.toString();
        }
        return lcp;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }
}
