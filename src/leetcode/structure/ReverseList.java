package leetcode.structure;

import niuke.list.ListNode;

// 25.K个一组翻转链表（困难）
// https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-lian-biao-ti-mu-xun-lian-di-gui-si-wei/k-ge-yi-zu-fan-zhuan-lian-biao
public class ReverseList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
