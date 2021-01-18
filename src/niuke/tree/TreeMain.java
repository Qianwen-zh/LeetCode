package niuke.tree;

public class TreeMain {
    public TreeNode Convert(){
        TraverseBinaryTree traverseBinaryTree = new TraverseBinaryTree();
        TreeNode r10 = initTreeNode();
        traverseBinaryTree.LDR(r10);
        return traverseBinaryTree.Convert(r10);
    }

    public void PrintFromTopToBottom3(){
        TraverseBinaryTree traverseBinaryTree = new TraverseBinaryTree();
        TreeNode r10 = initTreeNode();
        traverseBinaryTree.PrintFromTopToBottom3(r10);
    }

    private TreeNode initTreeNode() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);
        TreeNode r10 = new TreeNode(10);
        TreeNode r11 = new TreeNode(11);
        TreeNode r12 = new TreeNode(12);
        TreeNode r13 = new TreeNode(13);
        TreeNode r14 = new TreeNode(14);
        r10.setLeft(r8);
        r10.setRight(r14);
        r8.setLeft(r6);
        r8.setRight(r9);
        r6.setLeft(r5);
        r6.setRight(r7);
        r14.setLeft(r12);
        r12.setLeft(r11);
        r12.setRight(r13);
        return r10;
    }
}
