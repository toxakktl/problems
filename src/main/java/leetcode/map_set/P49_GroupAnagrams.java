package leetcode.map_set;

import java.util.*;

public class P49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sortedStr = String.valueOf(sorted);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            map.get(sortedStr).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}
