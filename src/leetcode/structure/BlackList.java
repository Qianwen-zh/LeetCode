package leetcode.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class BlackList {

    /**
     * 给我O(1)时间，我可以删除/查找数组中的任意元素
     * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/sui-ji-ji-he
     * 力扣 380 见 RandomizedSet.java
     *
     * 力扣 710
     * 给定一个包含 [0，n ) 中独特的整数的黑名单 black，写一个函数从 [ 0，n ) 中返回一个不在 black 中的随机整数。
     * n = 8 ; aa = [0,1,2,3,4,5,6,7]; black = [3,5,6]
     * 我们将黑名单分成两部分，第一部分 blackLeft 的数都小于 N - len(black)，需要进行映射；  blackLeft=[3]  N - len(black)=8-3=5
     * 第二部分 blackRight 的数都大于等于 N - len(black) = ，这些数不需要进行映射，因为并不会随机到它们。 blackRight=[5,6]
     * 我们先用 blackRight 构造出 whiteRight，表示大于等于 N - len(black) 且在白名单中的数，blackLeft 和 whiteRight 的长度一定是相等的。 whiteRight = [7]
     * 随后遍历 blackLeft 和 whiteRight，构造一个映射表（HashMap）map，将 blackLeft 和 whiteRight 中的数构造一一映射。
     * 在 [0, N - len(black)) 中随机生成整数 a 时，如果 a 出现在 map 中，则将它的映射返回，否则直接返回 a
     */

    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    int whiteLen; // 白名单长度

    public BlackList(int n, int[] black) {
        whiteLen = n - black.length; // 用黑名单长度将0-n分成两段
        Set<Integer> whiteRight = new HashSet<>();
        for (int i = whiteLen; i < n; i++) {
            whiteRight.add(i); // 白名单中右侧数据需要 和 黑名单左侧数据做映射
        }
        for (int b : black) {
            if (b >= whiteLen) { // 白名单中右侧数据删掉黑名单数据
                whiteRight.remove(b);
            }
        }
        Iterator<Integer> wr = whiteRight.iterator();
        for (int b : black) {
            if (b < whiteLen) { // 黑名单左侧数据做映射
                map.put(b, wr.next());
            }
        }
    }

    public int pick() {
        int k = random.nextInt(whiteLen);
        return map.getOrDefault(k, k); // 获取k的白名单映射，如果没有则说明k在白名单里返回k
    }
}


