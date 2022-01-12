package leetcode.tree.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    List<Integer> res2 = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return res2;
        res2.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res2;
    }
}
