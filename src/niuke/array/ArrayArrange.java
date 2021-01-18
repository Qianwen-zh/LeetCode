package niuke.array;

// 排序
public class ArrayArrange {
    /** 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。*/
    /**
     * 解： 自定义一个冒泡排序 如果 ab < ba 说明a在前
     */
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int sum2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (sum1 > sum2) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = new String("");
        for (int i = 0; i < numbers.length; i++) {
            str = str + numbers[i];
        }
        return str;

    }

    public String PrintMinNumber1(int[] numbers) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                Integer a = Integer.valueOf(numbers[j] + "" + numbers[j + 1]);
                Integer b = Integer.valueOf(numbers[j + 1] + "" + numbers[j]);
                if (a > b) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            result.append(numbers[i]);
        }
        return result.toString();
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 输入描述:
     * 题目保证输入的数组中没有的相同的数字
     * 示例  输入 1,2,3,4,5,6,7,0 输出 7
     */
    public int InversePairs(int[] array) {
        int len = array.length;
        int sum = 0;
        int kmod = 1000000007;
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (array[i] > array[j]) {
                    sum += 1;
                    sum %= kmod;
                }
            }
        }
        return sum;
    }

//     归并排序使用分治策略，序列一分为二(O(1))后，将子序列递归排序(2 * T(n / 2))，
//     最后合并有序子序列(O(n)),T(n) = 2 * T(n / 2) + O(n) = O(n * logn)。
//
//     一、归并排序
//      1、归并排序的实现
//     写递归函数就像开车，先系上安全带即先写出递归基。

    public static void mergeSortCore(int[] arr, int lo, int hi) {
        if (lo == hi) { // <----- 安全带
            return;
        }
        int mid = ((hi - lo) >> 1) + lo;
        mergeSortCore(arr, lo, mid);
        mergeSortCore(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }
    // 将两个有序序列合并为一个有序序列，如下(还有一个结构紧凑的写法，效率不高(merge2))
    public static void merge(int[] arr, int lo,int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = 0, p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= hi) {
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[lo + i] = temp[i];
        }
    }
    // 二、剑指offer[51]
    // 数组中的逆序对 题解
    //
    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。即输出P%1000000007
    //
    // 二路归并即merge，是将两个有序的序列合并为一个有序的序列，在两个子序列left、right合并过程中，当left中当前元素A小于right中当前元素B时，
    // 因为right序列已经有序，所以不用比较，A一定是left、right两个子序列当前剩余元素中最小的元素，这省去了A与B后其他元素比较的操作。
    //
    // 对于本题，在两个子序列left、right合并过程中，当left中当前元素A大于right中当前元素B时，因为right序列已经有序，所以不用比较，
    // A一定大于right序列当前所有剩余元素，其全部可以与A组成逆序对，即通过一次比较可到一批逆序对，加速统计过程。

    private int merge2(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int index = 0;
        int count = 0;
        int p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            // 与归并排序不同的地方，在merge过程中统计逆序对数
            if (arr[p1] > arr[p2]) {
                count += mid - p1 + 1;
                temp[index++] = arr[p2++];
            }
            else {
                temp[index++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            temp[index++] = arr[p1++];
        }
        while (p2 <= hi) {
            temp[index++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[lo++] = temp[i];
        }

        return count;
    }
}