package leetcode.easy.tree;

import common.TreeNode;

import java.util.Stack;

public class P938_RangeSumBST {

    /**
     * v1
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high);
        }
    }

    /**
     * v2
     * @param root
     * @param low
     * @param high
     * @return
     */
    int res = 0;
    public int rangeSumBST2(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root != null){
            if (low <= root.val && root.val <= high)
                res += root.val;
            if (low < root.val)
                dfs(root.left, low, high);
            if (root.val < high)
                dfs(root.right, low, high);
        }
    }

    public static int rangeSumBSTIt(TreeNode root, int low, int high) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high){
                    res += node.val;
                }
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(5, n1, n2);
        TreeNode n4 = new TreeNode(18);
        TreeNode n5 = new TreeNode(15, null, n4);
        TreeNode n6 = new TreeNode(10, n3, n5);

        System.out.println(rangeSumBSTIt(n6, 7, 15));
    }
}


