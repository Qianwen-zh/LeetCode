package leetcode.structure;

import java.util.HashMap;
import java.util.Map;

public class LFUCacheOrigin {
    Map<Integer, DoubleLinkedNode> keyToVal = new HashMap<>();
    Map<Integer, Integer> keyToFreq = new HashMap<>();
    Map<Integer, DoubleLink> freqToKeys = new HashMap<>();
    int cap = 0;
    int minFreq = 1;

    public LFUCacheOrigin(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        updateFreq(key, -1);
        return keyToVal.get(key).val;
    }

    // 1.先判断当前key是否存在
    //         已存在 更新值；freq+1;更新三个map
    //         不存在 判断容量超出
    //                      已超出 删除minFreq 对应的key 若存在多个 删除最旧的
    //                插入
    public void put(int key, int value) {
        // key已存在 更新值；freq+1;更新三个map
        if (keyToVal.containsKey(key)) {
            updateFreq(key, value);
            return;
        }
        if (cap == 0) {
            return;
        }
        // 判断容量超出
        // 已超出 删除minFreq 对应的key 若存在多个 删除最旧的；
        if (cap <= keyToVal.size()) {
            DoubleLink link = freqToKeys.get(minFreq);
            int removeKey = link.head.next.key;
            keyToVal.remove(removeKey);
            keyToFreq.remove(removeKey);
            link.remove(link.head.next);
        }
        // 直接插入
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        keyToVal.put(key, node);
        minFreq = 1;
        addNodeForFreqList(node, key, 1);
    }

    private void updateFreq(int key, int val) {
        DoubleLinkedNode node = keyToVal.get(key);
        if (val != -1) {
            node.val = val;
        }
        int freq = keyToFreq.get(key);
        int newFreq = freq + 1;
        DoubleLink link = freqToKeys.get(freq);
        link.remove(node);
        addNodeForFreqList(node, key, newFreq);
        // 更新最小次数
        if (link.getSize() == 0 && minFreq == freq) {
            minFreq++;
        }
    }

    // 把节点加到新次数的链表中
    private void addNodeForFreqList(DoubleLinkedNode node, int key, int newFreq) {
        keyToFreq.put(key, newFreq);
        DoubleLink newLink;
        if (freqToKeys.containsKey(newFreq)) {
            newLink = freqToKeys.get(newFreq);
        }
        else {
            newLink = new DoubleLink();
        }
        newLink.add(node);
        freqToKeys.put(newFreq, newLink);
    }

    class DoubleLink {
        int size = 0;
        DoubleLinkedNode head = new DoubleLinkedNode();
        DoubleLinkedNode tail = new DoubleLinkedNode();
        DoubleLink() {
            head.next = tail;
            tail.pre = head;
        }
        void remove(DoubleLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }
        void add(DoubleLinkedNode node) {
            // tail是最新的
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }
        int getSize() {
            return size;
        }
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
