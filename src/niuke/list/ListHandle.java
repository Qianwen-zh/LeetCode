package niuke.list;

import java.util.HashSet;
import java.util.Set;

public class ListHandle {
    ListNode end = null;

    //    输入一个链表，反转链表后，输出新链表的表头。
    // 1->2->3->4
    // pre : null; head : 1; next = 2
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //先存head的下一个 next:2
            next = head.next;
            //链表反转 1->null
            head.next = pre;
            //前进一步 pre = 1
            pre = head;
            //head : 2
            head = next;
            // null <- 1  2->3
        }
        //head null pre就是最后一个节点
        return pre;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * 解： a : 1 2 3 4 7 8 9
     * b :   4 5 6 7 8 9
     * a和b可能存在长度不一样的情况 用a+b b+a 长度就一样长了 然后再循环比较一遍即可
     * a+b: 1 2 3 4 7 8 9 4 5 6 7 8 9
     * b+a: 4 5 6 7 8 9 1 2 3 4 7 8 9
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    /* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
        例如，链表1->2->3->3->4->4->5 处理后为 1->2->5*/
    // 1->1->2->2->3->4->4->5->5->6    3->6
    // {1,1,1,1,1,1,2}
    // {1,1,1,1,1,1,1}
    // {1,2,3,3,4,4,5}
    //
    //     找重复值的具体步骤：
    //             1.初始化：set<int> st
    // 2. 遍历单链表相邻两个元素，如果相等，就加入到set当中
    // 3. 直到单链表遍历完</int>
    //
    //     删除重复值的具体步骤：
    //             1.初始化：pre指针指向重复值的前一个节点，cur指向当前遍历的节点值
    // 2.遍历单链表当前元素，然后再set中检查，如果是重复值，就删除，pre->next = cur->next
    // 3. 否则，不是重复值，pre = pre->next, cur = cur->next
    //
    // public class Solution {
    //     public ListNode deleteDuplication(ListNode pHead){
    //         if(pHead == null || pHead.next == null){
    //             return pHead;
    //         }
    //         // 自己构建辅助头结点
    //         ListNode head = new ListNode(Integer.MIN_VALUE);
    //         head.next = pHead;
    //         ListNode pre = head;
    //         ListNode cur = head.next;
    //         while(cur!=null){
    //             if(cur.next != null && cur.next.val == cur.val){
    //                 // 相同结点一直前进
    //                 while(cur.next != null && cur.next.val == cur.val){
    //                     cur = cur.next;
    //                 }
    //                 // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
    //                 // cur 继续前进
    //                 cur = cur.next;
    //                 // pre 连接新结点
    //                 pre.next = cur;
    //             }else{
    //                 pre = cur;
    //                 cur = cur.next;
    //             }
    //         }
    //         return head.next;
    //     }
    // }


    // import java.util.*;
    //     public class Solution {
    //         public ListNode deleteDuplication(ListNode pHead){
    //             if(pHead == null){
    //                 return  null;
    //             }
    //             // 先找出相同结点，存入 set
    //             HashSet<Integer> set = new HashSet<>();
    //             ListNode pre = pHead;
    //             ListNode cur = pHead.next;
    //             while(cur != null){
    //                 if(cur.val == pre.val){
    //                     set.add(cur.val);
    //                 }
    //                 pre = cur;
    //                 cur = cur.next;
    //             }
    //             // 再根据相同节点删除
    //             // 先删头部
    //             while(pHead != null && set.contains(pHead.val)){
    //                 pHead = pHead.next;
    //             }
    //             if(pHead == null){
    //                 return null;
    //             }
    //             // 再删中间结点
    //             pre = pHead;
    //             cur = pHead.next;
    //             while(cur != null){
    //                 if(set.contains(cur.val)){
    //                     pre.next = cur.next;
    //                     cur = cur.next;
    //                 }else{
    //                     pre = cur;
    //                     cur = cur.next;
    //                 }
    //             }
    //             return pHead;
    //         }
    //     }

    // public ListNode deleteDuplication(ListNode pHead) {
    //     if (pHead == null) {
    //         return null;
    //     }
    //     ListNode temp = pHead;
    //     while (temp != null && temp.next != null && temp.val == temp.next.val) {
    //         if (temp.next.next != null) {
    //             pHead = temp.next.next;
    //             temp = temp.next.next;
    //         }
    //         else {
    //             return null;
    //         }
    //     }
    //     while (temp.next != null && temp.next.next != null) {
    //         if (temp.next.val == temp.next.next.val) {
    //             temp.next = temp.next.next.next;
    //         }
    //         else {
    //             temp = temp.next;
    //         }
    //     }
    //     return pHead;
    // }
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Set<Integer> nodeVal = new HashSet<Integer>();
        Set<Integer> mulitiNodeVal = new HashSet<Integer>();
        ListNode temp = pHead;
        // 1->1->2->2->3->4->4->5->5->6
        // 用set保存重复数据
        while (temp != null) {
            if (nodeVal.contains(temp.val)) {
                mulitiNodeVal.add(temp.val);
            }
            else {
                nodeVal.add(temp.val);
            }
            temp = temp.next;
        }
        // 删掉头部的重复数据
        while (pHead != null && mulitiNodeVal.contains(pHead.val)) {
            pHead = pHead.next;
        }
        temp = pHead;
        // 删掉中间的重复数据
        while (temp != null) {
            if (temp.next != null && mulitiNodeVal.contains(temp.next.val)) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return pHead;
    }

}
