package leetcode.tree.easy;

import common.TreeNode;

public class P563_BinaryTreeTilt {

    private class Result {
        int totalTilt = 0;
    }

    private int helper(TreeNode root, Result res) {
        if (root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        res.totalTilt += Math.abs(left - right);

        return root.val + left + right;

    }

    public int findTilt(TreeNode root) {
        Result res = new Result();
        helper(root, res);
        return res.totalTilt;
    }
}
