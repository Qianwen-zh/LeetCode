package niuke.list;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }

    public void setNext(RandomListNode next) {
        this.next = next;
    }

    public void setRandom(RandomListNode random) {
        this.random = random;
    }

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cloneHead = pHead;
        RandomListNode clone;
        RandomListNode next;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        // A->B
        // A->A1->B->B1
        while (cloneHead != null) {
            clone = new RandomListNode(cloneHead.label);
            next = cloneHead.next;
            cloneHead.next = clone;
            clone.next = next;
            cloneHead = next;
        }
        cloneHead = pHead;
        clone = pHead.next;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (clone != null) {
            clone.random = cloneHead.random == null ? null : cloneHead.random.next;
            cloneHead = clone.next;
            clone = cloneHead == null ? null : cloneHead.next;
        }
        cloneHead = pHead;
        clone = pHead.next;
        RandomListNode pCloneHead = pHead.next;
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        //第2.3步不能合到一起,不然random往前指的节点就会引用pHead中的节点
        while (clone != null) {
            cloneHead.next = clone.next;
            cloneHead = cloneHead.next;
            clone.next = clone.next == null ? null : clone.next.next;
            clone = clone.next;
        }
        return pCloneHead;
    }
}
