package leetcode.structure;

import java.util.Map;
import java.util.HashMap;

public class LRUCacheOrigin {
    class DoubleLinkedNode {
        int key;
        int val;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        DoubleLinkedNode(){}
        DoubleLinkedNode(int key, int val) {this.key =key; this.val = val;}
    }
    Map<Integer, DoubleLinkedNode> cache = new HashMap<Integer, DoubleLinkedNode>() ;
    int cap;
    int size = 0;
    DoubleLinkedNode head, tail;
    public LRUCacheOrigin(int cap) {
        this.cap = cap;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        DoubleLinkedNode node = cache.get(key);
        removeNode(node);
        setRecentKey(node);
        return node.val;
    }

    private void setRecentKey(DoubleLinkedNode node) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        size++;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size -- ;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.val = value;
            removeNode(node);
            setRecentKey(node);
            return;
        }
        if(this.size>=cap){
            cache.remove(head.next.key);
            removeNode(head.next);
        }
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        setRecentKey(node);
        cache.put(key, node);
    }
}
