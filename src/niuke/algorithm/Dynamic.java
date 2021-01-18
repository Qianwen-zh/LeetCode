package niuke.algorithm;

//动态规划
public class Dynamic {
    /**
     * 连续子向量的最大和
     * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 给一个数组，返回它的最大连续子序列的和？(子向量的长度至少是1)
     * {6,-3,-2,7,-15,1,2,2} 连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * {-2,-8,-1,-5,-9}   -1
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int max = array[0];
        int temp = array[0];
        for (int i = 1; i < len; i++) {
            if (temp > 0){
                temp += array[i];
            }else {
                temp = array[i];
            }
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }

/**
 *  把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *  解：
 *丑数 * 2  3  5
 *  1   2  3  5
 *  2   4  6  10
 *  3   6  9  15
 *  4   8  12 20
 *  5   10 15 25
 *  6   12 18 30
 *  8   16 24 40
 *  */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)return 0;
        int p2=0, p3=0, p5=0; //初始化三个指向三个潜在成为最小丑数的位置
        int[] result = new int[index];
        result[0] = 1;//
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(Math.min(result[p2]*2 , result[p3]*3) , result[p5]*5);
            if(result[i] == result[p2]*2) p2++;
            if(result[i] == result[p3]*3) p3++;
            if(result[i] == result[p5]*5) p5++;
        }
        return result[index-1];
    }

/**    求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
    ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
    （从1 到 n 中1出现的次数）。
 1      1
 1+10   10 11 12 13 14 15 16 17 18 19
 9      21 31 41 51 61 71 81 91 100

 */
    // int NumberOf1Between1AndN_Solution(int n) {
    //
    // }



}
