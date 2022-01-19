package leetcode.tree.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return res;
    }
}
