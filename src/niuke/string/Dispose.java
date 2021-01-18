package niuke.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//排列
public class Dispose {

    /**
     * 翻转这些单词顺序
     * student. a am I
     * I am a student.
     */
    public String ReverseSentence(String str) {
        int start = str.length();
        StringBuffer result = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                result.append(str.substring(i + 1, start)).append(" ");
                start = i;
            } else if (i == 0) {
                result.append(str.substring(i, start));
            }
        }
        return result.toString();
    }

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public String LeftRotateString(String str, int n) {
        if ("".equals(str)) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        result.append(str.substring(n, str.length())).append(str.substring(0, n));
        return result.toString();
    }

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * 字母e(或E)之前必须有数字(可以是一个十进制的整数或小数)，之后必须是一个整数
     * 如果没有 e 那么+-只能有一个
     * e 只能有一个
     */
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str).toUpperCase();
        int len = string.length();
        if (string.indexOf('E') != string.lastIndexOf('E') || string.indexOf('.') != string.lastIndexOf('.')
                || string.indexOf('E') == 0 || string.indexOf('E') == len - 1
                || string.indexOf('.') == 0 || string.indexOf('.') == len - 1) {
            return false;
        }
        if (string.indexOf('E') > -1) {
            int e = string.indexOf('E');
            if ((str[e + 1] < 48 || str[e + 1] > 57) && str[e + 1] != '+' && str[e + 1] != '-') {
                return false;
            }
            for (int i = e + 2; i < len; i++) {
                if ((str[i] < 48 || str[i] > 57) && str[i] != '+' && str[i] != '-') {
                    return false;
                }
            }
            return isNumeric(string.substring(0, e).toCharArray());
        }
        if ((str[0] < 48 || str[0] > 57) && str[0] != '+' && str[0] != '-') {
            return false;
        }
        for (int i = 1; i < len; i++) {
            if ((str[i] < 48 || str[i] > 57) && (str[i] != '.')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
     * ab ba
     * abc,acb,bac,bca,cab和cba。
     * abcd abdc acbd acdb adbc adcb  bacd badc bcad bcda bdac bdca cabd
     * <p>
     * abcd
     * 首先固定a 剩下的bcd length()>2 再固定b 交换cd 再固定c 交换bd 再固定e 交换bc
     * 然后固定b 剩下acd 。。。
     */
    private StringBuffer parent = new StringBuffer();

    public ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        str = new String(array);
        HashSet set = new HashSet();
        ArrayList<String> permutationList = PermutationList(str);
        //用set去重
        ArrayList<String> newList = new ArrayList<>();
        for (String s : permutationList) {
            if (set.add(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    public ArrayList<String> PermutationList(String str) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        if (str.length() == 1) {
            stringArrayList.add(parent.toString() + str);
        } else if (str.length() == 2) {
            //剩下两个字符的时候交换
            stringArrayList.add(parent.toString() + str);
            stringArrayList.add(parent.toString() + str.charAt(1) + "" + str.charAt(0));
        } else {
            for (int i = 0; i < str.length(); i++) {
                //parent记录上层固定的字符串
                parent.append(str.charAt(i));
                //抽出array[i]固定，剩下的继续拆分和交换
                String childStr = str.substring(0, i) + str.substring(i + 1, str.length());
                ArrayList<String> childList = PermutationList(childStr);
                stringArrayList.addAll(childList);
                //parent删掉当前的字符，以便做下一个循环
                parent.deleteCharAt(parent.length() - 1);
            }
        }
        return stringArrayList;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，
     * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        int result = 0;
        HashMap hashMap = new HashMap<>();
        if (len == 1){
            return array[0];
        }
        if (len > 1) {
            for (int i = 0; i < len; i++) {
                if (hashMap.get(array[i]) == null) {
                    hashMap.put(array[i], 1);
                } else {
                    int count = Integer.parseInt(hashMap.get(array[i]).toString());
                    count++;
                    hashMap.put(array[i], count);
                    if (count > len / 2) {
                        result = array[i];
                        break;
                    }
                }
            }
        }
        return result;
    }
    //如果我把这个数组排序，那么排序之后位于数组中间的数字一定就是那个出现次数超过数组一半的数字
    public int MoreThanHalfNum_Solution1(int[] array) {
        int len = array.length;
        Arrays.sort(array);
        double index = Math.floor(len/2);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(array[i] == array[(int)index]){
                count ++;
                if (count > len / 2) {
                    return array[i];
                }
            }
        }
        return 0;
    }
}
