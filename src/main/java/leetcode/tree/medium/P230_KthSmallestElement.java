package leetcode.tree.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P230_KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = inorder(root);
        return inorderList.get(k-1);
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.addAll(inorder(root.left));
        res.add(root.val);
        res.addAll(inorder(root.right));
        return res;
    }

    public int kthSmallestIt(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }

}
