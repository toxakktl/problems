package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class P78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

}
