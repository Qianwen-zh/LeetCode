package leetcode.structure;

import vo.ListNode;

// 25.K个一组翻转链表（困难）
// https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-lian-biao-ti-mu-xun-lian-di-gui-si-wei/k-ge-yi-zu-fan-zhuan-lian-biao
// 1-2-3-4-5 2
public class ReverseList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }
        // tail = 3
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
    // head:1 tail:3
    // 迭代
    ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != tail && cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    // 递归
    ListNode reverse2(ListNode head, ListNode tail) {
        if(head==tail || head.next==tail ) return head;
        // 最后一个node
        ListNode newHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
