package leetcode.easy.strings;

public class P709_ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z'){
                int ascii = c;
                ascii = ascii + 32;
                c = (char) ascii;
            }
            res.append(c);
        }
        return res.toString();
    }
}
