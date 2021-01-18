package niuke.array;

import java.util.ArrayList;

public class ArrayPrint {
    /**
     * 题目 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 例如，如果输入如下矩阵：
     * {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}} 结果 [1,2,3,4,5,10,15,14,13,12,11,6,7,8,9]
     * {{1}, {2}, {3}, {4}} 结果：{1,2,3,4}
     *
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> matrixArr = new ArrayList<>();
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int start = 0;
        int i = -1, j = -1;
        double layer = Math.ceil((Math.min(len1, len2) - 1) / 2) + 1;
        while (layer > 0) {
            //尾-首只剩一行或者一列 直接打印
            if (len1 - start == 1 || len2 - start == 1) {
                for (i++; i < len1; i++) {
                    for (int k = j + 1; k < len2; k++) {
                        matrixArr.add(matrix[i][k]);
                    }
                }
                break;
            }
            //第一行
            for (i++, j++; j < len2; j++) {
                matrixArr.add(matrix[i][j]);
            }
            //最后一列
            for (i++, j--; i < len1; i++) {
                matrixArr.add(matrix[i][j]);
            }
            //最后一行
            for (i--, j--; j >= start; j--) {
                matrixArr.add(matrix[i][j]);
            }
            //第一列
            for (i--, j++; i > start; i--) {
                matrixArr.add(matrix[i][j]);
            }
            len1--;
            len2--;
            start++;
            layer--;
        }
        return matrixArr;
    }
}