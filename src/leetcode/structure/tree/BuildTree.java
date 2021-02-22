package leetcode.structure.tree;

import vo.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//105. 从前序与中序遍历序列构造二叉树
public class BuildTree {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int leftPre, int rightPre, int leftIn, int rightIn) {
        if (leftPre > rightPre) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[leftPre]);
        int rootIn = indexMap.get(preorder[leftPre]);
        int size_left_subtree = rootIn - leftIn;
        node.left = myBuildTree(preorder, inorder, leftPre + 1, leftPre + size_left_subtree, leftIn, rootIn - 1);
        node.right = myBuildTree(preorder, inorder, leftPre + size_left_subtree + 1, rightPre, rootIn + 1, rightIn);
        return node;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int[] leftPre = new int[len];
        int[] rightPre = new int[len];
        int[] leftIn = new int[len];
        int[] rightIn = new int[len];
        for (int i = 0; i < len; i++) {
            if (inorder[i] == preorder[0]) {
                leftIn = Arrays.copyOfRange(inorder, 0, i + 1);
                rightIn = Arrays.copyOfRange(inorder, i + 1, len);
                leftPre = Arrays.copyOfRange(preorder, 1, i + 1);
                rightPre = Arrays.copyOfRange(preorder, i + 1, len);
                break;
            }
        }
        node.left = buildTree(leftPre, leftIn);
        node.right = buildTree(rightPre, rightIn);
        return node;
    }

}
