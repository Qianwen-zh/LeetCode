package niuke.test;

import niuke.algorithm.Dynamic;
import niuke.list.ListMain;
import niuke.tree.TreeMain;

public class Main {
    public static void main(String[] args) {
        //      int[] pre = {1,2,4,7,3,5,6,8};
        //        int[] in = {4,7,2,1,5,3,8,6};
        //        BinaryTree binaryTree = new BinaryTree();
        //        TreeNode node = binaryTree.reConstructBinaryTree(pre, in);
        //        int[] array = {2, 3, 2, 3, 2, 3, 5};
        //        int[] num1 = new int[1];
        //        //"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
        //        char[] num2 = {'1','e','2','.','1'} ;
        //        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        //        Dispose dispose = new Dispose();
        //        System.out.println(dispose.LeftRotateString("",3));
        //        System.out.println(dispose.isNumeric(num2));
        //      Recursive aa = new Recursive();
        //      System.out.println(aa.RectCover(4));
        /**        ListNode  a = new ListNode(1);
         ListNode  b= new ListNode(2);
         ListNode  c= new ListNode(3);
         a.setNext(b);
         b.setNext(c);
         ListHandle aa = new ListHandle();
         ListNode bb = aa.ReverseList(a);
         while (bb.getNext() != null){
         System.out.println(bb.getVal());
         bb = bb.getNext();
         }
         **/
        /*TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode aa4 = new TreeNode(4);
        TreeNode aa5 = new TreeNode(5);
        TreeNode aa6 = new TreeNode(6);
        TreeNode b4 = new TreeNode(4);
        TreeNode b5 = new TreeNode(5);
        TreeNode b6 = new TreeNode(6);
        TreeNode b9 = new TreeNode(9);
        a1.setLeft(a2);
        a1.setRight(a3);
        a2.setLeft(aa4);
//        a3.setLeft(aa4);
        aa4.setLeft(aa5);
        aa4.setRight(aa6);
        a2.setRight(b9);
//        b4.setLeft(b5);
//        b4.setRight(b6);
//        BinaryTree BT = new BinaryTree();
//        BT.HasSubtree(a1, b4);
//        BT.Mirror(a1);
        TraverseBinaryTree TBT = new TraverseBinaryTree();
//        TBT.PrintFromTopToBottom2(a1);
        int[] sequense = {2,9,5,16,17,15,19,18,12};
        System.out.println(TBT.VerifySquenceOfBST(sequense));
        System.out.println(TBT.FindPath(a1,12));*/

        /*int[][] matrix1 = {{1}, {2}, {3}, {4}};
        int[][] matrix2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayPrint arrayPrint = new ArrayPrint();
        arrayPrint.printMatrix(matrix1);*/

        /*MinTopStack minTopStack = new MinTopStack();
        String[] aa =  {"PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"};
        for(int i=0;i<aa.length;i++){
            if(aa[i].indexOf("PSH") == 0 ){
                int a=Integer.parseInt(aa[i].replace("PSH",""));
                minTopStack.push(a);
            }else if("MIN".equals(aa[i])){
                minTopStack.min();
            }else if ("POP".equals(aa[i])){
                minTopStack.pop();
            }
        }
        StackMain stackMain = new StackMain();
        stackMain.IsPopOrder();
        TreeMain treeMain = new TreeMain();
        treeMain.Convert();
        StringMain stringMain = new StringMain();
        stringMain.Permutation();
        AlgorithmMain algorithmMain = new AlgorithmMain();
        algorithmMain.GetLeastNumbers_Solution();
        algorithmMain.solution();
        */
        /*SumSolution sumSolution = new SumSolution();
        sumSolution.binary2To10("1100100");*/
/*        ArrayArrange arrayArrange = new ArrayArrange();
        int[] a = {3334,3,3333332};
        System.out.println(arrayArrange.PrintMinNumber(a));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for(String it:list){
            if("2".equals(it)){
                list.remove(it);
            }
        }
        System.out.println(list);*/
        Dynamic dynamic = new Dynamic();
        System.out.println(dynamic.GetUglyNumber_Solution(0));

        TreeMain treeMain = new TreeMain();
        treeMain.PrintFromTopToBottom3();

        ListMain listMain = new ListMain();
        listMain.deleteDuplication();
    }
}
