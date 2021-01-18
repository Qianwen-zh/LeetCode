package leetcode.test;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import leetcode.structure.DoublePoint;
import leetcode.structure.RandomizedSet;
import leetcode.structure.ReverseList;
import niuke.list.ListNode;

public class Main {
    public static void main(String[] args) {
        // // 初始化一个空的集合。
        // RandomizedSet randomSet = new RandomizedSet();
        // // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        // randomSet.insert(1);
        // // 返回 false ，表示集合中不存在 2 。
        // randomSet.remove(2);
        // // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        // randomSet.insert(2);
        // // getRandom 应随机返回 1 或 2 。
        // randomSet.getRandom();
        // // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        // randomSet.remove(1);
        // // 2 已在集合中，所以返回 false 。
        // randomSet.insert(2);
        // // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        // randomSet.getRandom();
        DoublePoint doublePoint = new DoublePoint();
        // int[] nums = {1, 1, 2};
        // doublePoint.removeDuplicates(nums);
        ListNode a1 = new ListNode(1);
        ListNode a12 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a31 = new ListNode(3);
        ListNode a32 = new ListNode(3);
        a1.setNext(a12);
        a12.setNext(a2);
        a2.setNext(a31);
        a31.setNext(a32);
        doublePoint.deleteDuplicates(a1);
        String a = doublePoint.removeDuplicateLetters("bcabc");

            List<String> strings = Arrays.asList("6", "1", "3", "1", "2");

            Collections.sort(strings); //sort方法在这里

            for (String string : strings) {

                System.out.println(string);
            }
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        ListNode b5 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        ReverseList reverseList = new ReverseList();
        ListNode cc = reverseList.reverseKGroup(b1, 2);
    }
}
