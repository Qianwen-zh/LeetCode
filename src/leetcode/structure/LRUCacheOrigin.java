package leetcode.structure;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheOrigin {

    Map<Integer, DoubleLinkedNode> cache = new HashMap<Integer, DoubleLinkedNode>();
    int cap;
    int size = 0;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;

    public LRUCacheOrigin(int cap) {
        this.cap = cap;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 删除节点；再插入节点（把节点放到tail前）
        DoubleLinkedNode node = cache.get(key);
        removeNode(node);
        setRecentKey(node);
        return node.val;
    }

    private void setRecentKey(DoubleLinkedNode node) {
        // tail是最新的
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        size++;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    // 1.先判断当前key是否存在
    //         已存在 删除节点；再插入节点（把节点放到tail前）
    //         不存在 判断容量超出
    //                      已超出 删除head.next 对应的key
    //                插入新节点
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.val = value;
            removeNode(node);
            setRecentKey(node);
            return;
        }
        if (this.size >= cap) {
            cache.remove(head.next.key); // 节点中必须存key 否则这里无法取到
            removeNode(head.next);
        }
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        setRecentKey(node);
        cache.put(key, node);
    }

    class DoubleLinkedNode {
        int key;
        int val;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        DoubleLinkedNode() {
        }

        DoubleLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
