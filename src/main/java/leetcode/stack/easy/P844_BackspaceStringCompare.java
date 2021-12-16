package leetcode.stack.easy;

import java.util.Stack;

public class P844_BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c != '#')
                stack.push(c);
            else if (!stack.isEmpty())
                stack.pop();
        }
        return String.valueOf(stack);
    }

    public static boolean backspaceCompare2(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '#' && !stack1.isEmpty()) {
                stack1.pop();
            } else if (c != '#'){
                stack1.push(c);
            }
        }
        for (char c: t.toCharArray()) {
            if (c == '#' && !stack2.isEmpty()) {
                stack2.pop();
            }else if (c != '#') {
                stack2.push(c);
            }
        }
        if (stack1.size() != stack2.size())
            return false;
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            char first = stack1.pop();
            char second = stack2.pop();
            if (first != second)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        backspaceCompare2("abcd", "bbcd");
    }
}
