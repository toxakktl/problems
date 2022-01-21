package leetcode.strings.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        return sorted(s).equals(sorted(t));
    }

    private String sorted(String str) {
        char[] sortedStr = str.toCharArray();
        Arrays.sort(sortedStr);
        return new String(sortedStr);
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length();i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
