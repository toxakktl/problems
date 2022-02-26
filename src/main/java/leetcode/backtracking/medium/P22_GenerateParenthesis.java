package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class P22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n);
        return res;
    }

    private void backtrack(List<String> res, int n) {
    }


}
