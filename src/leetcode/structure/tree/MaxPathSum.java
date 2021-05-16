package leetcode.structure.tree;

import vo.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 124������ ���·����
public class MaxPathSum {
    int max = -1000;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return max;
    }
    private int oneSideMax(TreeNode root) {
        if(root == null) return 0;
        int leftMax = Math.max(0, oneSideMax(root.left));
        int rightMax = Math.max(0, oneSideMax(root.right));
        max = Math.max(max, leftMax + rightMax + root.val);
        // ��Ϊ��ǰ�ڵ�ֻ����һ�飬����ȡһ�����ֵ
        return Math.max(leftMax, rightMax) + root.val;
    }
}