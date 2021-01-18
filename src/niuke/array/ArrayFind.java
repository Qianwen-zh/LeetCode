package niuke.array;

import java.util.HashSet;
import java.util.Set;

// 查找
public class ArrayFind {
    /**
在一个二维数组中，
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
TEST ：16, {{}}
5,{{1,2,8,9},
   {2,4,9,12},
   {4,7,10,13},
   {6,8,11,15}}
Solution:
矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
因此从左下角开始查找，当要查找数字比左下角数字大时。右移
要查找数字比左下角数字小时，上移
*/
    public boolean Find(int target, int [][] array) {
        int len1 = array.length;
        int len2 = array[len1-1].length;
        boolean flag = false;
        if( len1 == 0 || (len1 == 1 && len2==0) || target < array[0][0] ||  target > array[len1-1][len2-1] ){
            return flag;
        }
        for(int i=len1-1,j=0;i>=0;){
            if(target < array[i][j]){
                i--;
            } else if(target > array[i][j]){
                j++;
            }else {
                flag = true;
                break;
            }
            if (j>len2){
                break;
            }
        }
        System.out.println(flag);
        return flag;
    }
    /**
    在一个长度为n的数组里的所有数字都在0到n-1的范围内。
    数组中某些数字是重复的，但不知道有几个数字是重复的。
    也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
    */
    /** Parameters:
        numbers:     an array of integers
        length:      the length of array numbers
        duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
                      Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        这里要特别注意~返回任意重复的一个，赋值duplication[0]
     Return value:       true if the input is valid, and there are some duplications in the array number
     otherwise false */
    /**
     [2,1,3,1,4] true , 1
    */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Set numberSet = new HashSet();
        if(length < 0){
            return false;
        }
        for(int i=0;i<length;i++){
            if(!numberSet.add(numbers[i])){  //numberSet.contains(numbers[i])
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
