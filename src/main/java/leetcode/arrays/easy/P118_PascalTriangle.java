package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class P118_PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = List.of(1);
        res.add(first);
        if (numRows == 1)
            return res;
        List<Integer> second = List.of(1, 1);
        res.add(second);
        for (int i = 2; i < numRows; i++) {
            List<Integer> prev = res.get(i-1);
            List<Integer> inner = new ArrayList<>();
            inner.add(1);
            for (int j = 0 ; j < prev.size()-1; j++){
                inner.add(prev.get(j) + prev.get(j+1));
            }
            inner.add(1);
            res.add(inner);
        }
        return res;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i +1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int first = res.get(i-1).get(j-1);
                    int second = res.get(i-1).get(j);
                    row.add(first + second);
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate2(5).size());
    }
}
