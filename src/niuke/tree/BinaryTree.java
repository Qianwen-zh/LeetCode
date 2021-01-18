package niuke.tree;


public class BinaryTree {

    /**
     * 题目：树的子结构
     * 输入两棵二叉树A，B，判断B是不是A的子结构。
     * （ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean hasFlag = false;
        if (root1.val == root2.val) {
            hasFlag = equalTree(root1, root2);
        }
        //没找到再接着往下走
        if (!hasFlag) {
            hasFlag = hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
        }
        return hasFlag;
    }

    private boolean equalTree(TreeNode root1, TreeNode root2) {
        //root2走到底了可以确定是子树
        if (root2 == null) {
            return true;
        }
        // root2没到底但root1下已经没了，说明不是子树
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        //左右两边必须完全一样
        return equalTree(root1.left, root2.left) && equalTree(root1.right, root2.right);
    }

    /**  题目：二叉树的镜像
     操作给定的二叉树，将其变换为源二叉树的镜像。
     输入描述:
     二叉树的镜像定义：源二叉树
     8
     /  \
     6   10
     / \  / \
     5  7 9 11
     镜像二叉树
     8
     /  \
     10   6
     / \  / \
     11 9 7  5*/
    /**
     * public void mirror(TreeNode root) {
     * if(root == null){
     * return;
     * }
     * mirror(root.left);
     * mirror(root.right);
     * TreeNode left = root.left;
     * root.left = root.right;
     * root.right = left;
     * }
     **/
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirror(root.left);
        mirror(root.right);
    }

}


