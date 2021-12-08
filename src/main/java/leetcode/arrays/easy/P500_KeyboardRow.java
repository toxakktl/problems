package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P500_KeyboardRow {

    public String[] findWords(String[] words) {
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res = new ArrayList<>();
        for (String word: words) {
            String refString;
            String lower = word.toLowerCase();
            if (keyboard[0].indexOf(lower.charAt(0)) != -1) {
                refString = keyboard[0];
            } else if (keyboard[1].indexOf(lower.charAt(0)) != -1) {
                refString = keyboard[1];
            } else {
                refString = keyboard[2];
            }
            boolean isValid = true;
            for (int i = 1; i < lower.length(); i++) {
                if (refString.indexOf(lower.charAt(i)) == -1){
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                res.add(word);
        }
        return res.toArray(String[]::new);
    }

    public String[] findWords2(String[] words) {
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (char c: keyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> res = new ArrayList<>();
        for (String w: words) {
            if (w.equals(""))
                continue;
            int index = map.get(w.toLowerCase().charAt(0));
            for (char c: w.toLowerCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }
}
