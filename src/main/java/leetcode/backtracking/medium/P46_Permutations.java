package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class P46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int [] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(res, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
