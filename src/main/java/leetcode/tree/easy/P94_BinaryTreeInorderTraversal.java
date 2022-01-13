package leetcode.tree.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P94_BinaryTreeInorderTraversal {
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
}
