package leetcode.dynamicProgram;

// 切分数组

import java.util.HashMap;
import java.util.Map;

public class SplitArray {
    public int splitArray(int[] nums) {
        Map<Integer, Integer> primeMinIndexMap = new HashMap<>();
        int[] result = new int[nums.length];
        int[] minPrime = new int[1000000 + 1]; // 最小质因子
        for (int i = 2; i < minPrime.length; i++) {
            if (minPrime[i] < 2) {
                for (int j = i; j < minPrime.length; j += i) {
                    minPrime[j] = i;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = i == 0 ? 1 : result[i - 1] + 1;
            int n = nums[i];
            while (n > 1) {
                int prime = minPrime[n];
                int primeMinIndex;
                if (primeMinIndexMap.containsKey(prime)) {
                    primeMinIndex = primeMinIndexMap.get(prime); // 当前质因子 结果最小的下标
                    if (primeMinIndex == 0) {
                        result[i] = 1;
                    }
                    else {
                        result[i] = Math.min(result[i], result[primeMinIndex - 1] + 1);
                    }
                }
                else {
                    primeMinIndex = i;
                    primeMinIndexMap.put(prime, i);
                }
                if (result[i] < result[primeMinIndex]) {
                    primeMinIndexMap.put(prime, i); // 更新 当前质因子 结果最小的下标
                }
                n = n / prime;
            }
        }
        return result[nums.length - 1];
    }


}
