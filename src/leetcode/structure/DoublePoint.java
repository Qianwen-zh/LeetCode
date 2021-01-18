package leetcode.structure;

import java.util.Stack;

import niuke.list.ListNode;

/**
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/yuan-di-xiu-gai-shu-zu
 * 一文秒杀四道原地修改数组的算法题 双指针法
 */
public class DoublePoint {

    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4]
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    /**
     * 83
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 示例 1:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    /**
     * 27
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int fast = slow; fast < nums.length; fast++) {
            nums[fast] = 0;
        }
    }

    /**
     * 1081 316
     * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
     * 示例 1：
     * <p>
     * 输入："cdadabcc"
     * 输出："adbc"
     * 示例 2：
     * <p>
     * 输入："abcd"
     * 输出："abcd"
     * <p>
     * 一道数组去重的算法题把我整不会了
     * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/dan-tiao-zhan-qu-zhong
     * 要求一、要去重。
     * 要求二、去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。
     * 要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。
     * 上述三条要求中，要求三可能有点难理解，举个例子。
     * 比如说输入字符串 s = "babc"，去重且符合相对位置的字符串有两个，分别是 "bac" 和 "abc"，但是我们的算法得返回 "abc"，因为它的字典序更小。
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        // 输入为ASCII字符，大小256够用了
        boolean[] inStack = new boolean[256];
        int[] count = new int[256];
        // count计算每个字符的出现次数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            // 已存在 表示c所在位置在目前栈中最小字典序
            if (inStack[c]) {
                continue;
            }
            // 栈不为空且栈顶元素大于c
            while (!stack.isEmpty() && stack.peek() > c) {
                // 说明栈顶元素在之后不会再出现
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 删掉栈顶元素 （每个char在当前栈中只存在一个）
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        // 因为是栈，后进先出 所以要反转
        return stringBuffer.reverse().toString();
    }
}
