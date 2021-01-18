package niuke.list;

import vo.ListNode;

public class ListMain {
    public RandomListNode getClone(){
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r1.setNext(r2);
        r2.setNext(r3);
        r3.setNext(r4);
        r1.setRandom(r3);
        r4.setRandom(r2);
        return r3.Clone(r1);
    }

    // 1->1->2->2->3->4->4->5->5->6
    // {1,1,1,1,1,1,2}
    public ListNode deleteDuplication(){
        ListHandle listHandle = new ListHandle();
        ListNode r11 = new ListNode(1);
        ListNode r12 = new ListNode(1);
        ListNode r13 = new ListNode(1);
        ListNode r14 = new ListNode(1);
        ListNode r15 = new ListNode(1);
        ListNode r16 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r22 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        ListNode r44 = new ListNode(4);
        ListNode r5 = new ListNode(5);
        ListNode r55 = new ListNode(5);
        ListNode r6 = new ListNode(6);
        /*r11.setNext(r12);
        r12.setNext(r13);
        r13.setNext(r14);
        r14.setNext(r15);
        r15.setNext(r16);
        r16.setNext(r2);*/
        r11.setNext(r12);
        r12.setNext(r2);
        r2.setNext(r22);
        r22.setNext(r3);
        r3.setNext(r4);
        r4.setNext(r44);
        r44.setNext(r5);
        r5.setNext(r55);
        r55.setNext(r6);
        return listHandle.deleteDuplication(r11);
    }

}
