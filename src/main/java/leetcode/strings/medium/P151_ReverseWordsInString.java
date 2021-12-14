package leetcode.strings.medium;

import java.util.Arrays;

public class P151_ReverseWordsInString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >=0 ; i-- ) {
            if (words[i].length() == 0)
                continue;
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String testStr = "a good   example";
        String[] words = testStr.split(" ");
        Arrays.asList(words).forEach(System.out::println);
        System.out.println(words.length);
    }
}
