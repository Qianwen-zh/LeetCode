package niuke.BitOperation;

import java.util.HashMap;
import java.util.Map;

//异或的两个值'相同为假，不同为真'
public class FindNumsAppearOnce {
    //一个整型数组里除了一个数字之外，其他的数字都出现了偶数次。请写程序找出这个只出现一次的数字。
    public int oneNumsAppearOnce(int[] array) {
        int num = 0;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                num ^= array[i];
            }
        }
        return num;
    }

    //一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
    //num1,num2分别为长度为1的数组 将num1[0],num2[0]设置为返回结果
    //先进行一遍异或 找到第一个为1的位 按这个进行分为两组
    public void twoNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int num = 0;
        if (array.length > 0) {
            int index = 0;
            num1[0] = 0;
            num2[0] = 0;
            for (int i = 0; i < array.length; i++) {
                num ^= array[i];
            }
            for (int i = 0; i < 32; i++) {         // 64 位 JVM 中，int 的长度是32位 [-2147483648,2147483647]
                if (((num >> i) & 1) == 1) { //右移 找到第一个为1的位；
                    index = i;
                    break;
                }
            }
            for (int j = 0; j < array.length; j++) {
                if (((array[j] >> index) & 1) == 1) {
                    num1[0] ^= array[j];
                } else {
                    num2[0] ^= array[j];
                }
            }
        }
        System.out.println("" + num1[0] + "+" + num2[0] + "");
    }

    //一个数组中，只有一个数字出现了一次，其他数字都出现了三次，找出这个出现了一次的数字；
    public int oneNumsAppearOnceOthersThrice(int[] array) {
        int num = 0;
        if (array.length > 0) {
            int bit[] = new int[32];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < 32; j++) {
                    bit[j] += (array[i] >> j) & 1;
                }
            }
            for (int j = 0; j < 32; j++) {
                if (bit[j] % 3 != 0) {
                    num |= (1 << j);
                }
            }
        }
        return num;
    }

    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
    public int firstNotRepeatingChar(String str) {
        int index = -1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (str.length() > 0) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if (null == map.get(str.charAt(i) + "")) {
                    map.put(str.charAt(i) + "", 1);
                } else {
                    int value = map.get(str.charAt(i) + "");
                    map.put(str.charAt(i) + "", ++value);
                }
            }
            for (int i = 0; i < len; i++) {
                if (1 == map.get(str.charAt(i) + "")) {
                    index = i;
                    break;
                }
            }
        }
        return index;
        /*int index = -1;
        if (str.length() > 0) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                Boolean left = str.substring(0, i).contains(str.charAt(i) + "");
                Boolean right = str.substring(i + 1, len).contains(str.charAt(i) + "");
                if (!left && !right) {
                    index = i;
                    break;
                }
            }
        }
        return index;*/
    }
}
