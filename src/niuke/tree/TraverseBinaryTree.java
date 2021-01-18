package niuke.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 遍历二叉树
 * 前序： root 左 右
 * 中序：左 root 右
 * 后序：左 右 root
 */
public class TraverseBinaryTree {
    //前序
    public void DLR(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val + "");
        DLR(treeNode.left);
        DLR(treeNode.right);
    }

    //中序
    public void LDR(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LDR(treeNode.left);
        System.out.println(treeNode.val + "");
        LDR(treeNode.right);
    }

    //后序
    public void LRD(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LRD(treeNode.left);
        LRD(treeNode.right);
        System.out.println(treeNode.val + "");
    }

    /**
     * 题目 ：重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * 1
     * /     \
     * 2        3
     * /         / \
     * 4         5   6
     * \           /
     * 7         8
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, in);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int[] in) {
        if (in.length < 1) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[preStart]) {
                node.left = reConstructBinaryTree(pre, preStart + 1, Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(pre, preStart + i + 1, Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    /**
     * 二叉树层序遍历
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rootList = new ArrayList<>();
        ArrayList<TreeNode> treeList = new ArrayList<>();
        if (root != null) {
            treeList.add(root);
            while (!treeList.isEmpty()) {
                ArrayList<TreeNode> childList = new ArrayList<>();
                for (TreeNode node : treeList) {
                    if (node != null) {
                        rootList.add(node.val);
                        childList.add(node.left);
                        childList.add(node.right);
                    }
                }
                treeList = childList;
            }
        }
        return rootList;
    }

    //队列方式实现
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> rootList = new ArrayList<>();
        //Queue是用LinkedList实现的
        Queue<TreeNode> treeQueue = new LinkedList<>();
        if (root != null) {
            //插入
            treeQueue.offer(root);
            while (!treeQueue.isEmpty()) {
                //取出
                TreeNode node = treeQueue.poll();
                if (node != null) {
                    rootList.add(node.val);
                    treeQueue.offer(node.left);
                    treeQueue.offer(node.right);
                }
            }
        }
        return rootList;
    }

    /**
        从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottom3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> outter = new ArrayList<>();
        if (pRoot == null) {
            return outter;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(pRoot.val);
        outter.add(inner);
        nodeList.add(pRoot);
        while (!nodeList.isEmpty()) {
            inner = new ArrayList<>();
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : nodeList) {
                if (treeNode.left != null) {
                    inner.add(treeNode.left.val);
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    inner.add(treeNode.right.val);
                    temp.add(treeNode.right);
                }
            }
            if (!inner.isEmpty()){
                outter.add(inner);
            }
            nodeList = temp;
        }
        return outter;
    }

    /**
     * 二叉搜索树的后序遍历 左 右 root
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * <p>
     * 二叉搜索树：
     * 空树；
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     * {2,9,5,16,17,15,19,18,12} true
     * {7,4,6,5}  false
     * {} false
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        boolean flag = true;
        int len = sequence.length;
        if (len == 0) {
            return false;
        }
        int rightStart = -1;
        for (int i = 0; i < len; i++) {
            //sequence[len - 1]是根节点 右子树所有节点都比根节点大，如果出现小的就不是二叉搜索树
            if (rightStart != -1 && sequence[i] < sequence[len - 1]) {
                flag = false;
                break;
            }
            if (sequence[i] > sequence[len - 1]) {
                rightStart = i;
                //用sequence[len - 1]分成左右子树
                flag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i)) && VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, len - 1));
            }
        }
        return flag;
    }

    /**
     * 二叉树先序遍历
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前) 这个注意好像没用
     * {10,5,12,4,7},15
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        int sum = 0;
        if (root != null && root.val <= target) {
            pathList = sumTreeNode(root, target, sum, new ArrayList<>());
        }
        return pathList;
    }

    private ArrayList<ArrayList<Integer>> sumTreeNode(TreeNode root, int target, int sum, ArrayList<Integer> parentList) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        //把上级的list深拷贝出来，否则每次进来都会对parentList有影响
        ArrayList<Integer> currentList = new ArrayList<>(parentList);
        if (root != null) {
            sum += root.val;
            if (target > sum) {
                currentList.add(root.val);
                pathList.addAll(sumTreeNode(root.left, target, sum, currentList));
                pathList.addAll(sumTreeNode(root.right, target, sum, currentList));
            }
            else if (target == sum && root.left == null && root.right == null) {
                currentList.add(root.val);
                pathList.add(currentList);
            }
        }
        return pathList;
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * 解法：中序遍历
     * 先将中序遍历的结果保存在数组里，再修改指针指向
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        ConvertLDR(pRootOfTree, treeNodeList);
        for (int i = 0; i < treeNodeList.size(); i++) {
            if (i + 1 != treeNodeList.size()) {
                treeNodeList.get(i).right = treeNodeList.get(i + 1);
            }
            if (i != 0) {
                treeNodeList.get(i).left = treeNodeList.get(i - 1);
            }
        }
        return treeNodeList.get(0);
    }

    private void ConvertLDR(TreeNode treeNode, List<TreeNode> treeNodeList) {
        if (treeNode == null) {
            return;
        }
        ConvertLDR(treeNode.left, treeNodeList);
        treeNodeList.add(treeNode);
        ConvertLDR(treeNode.right, treeNodeList);
    }
}
