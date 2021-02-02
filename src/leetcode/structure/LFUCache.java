package leetcode.structure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {
    Map<Integer, Integer> keyToVal = new HashMap<>();
    Map<Integer, Integer> keyToFreq = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    int cap = 0;
    int minFreq = 1;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        updateFreq(key);
        return keyToVal.get(key);
    }

    // 1.先判断当前key是否存在
    //         已存在 更新值；freq+1;更新三个map
    //         不存在 判断容量超出
    //                      已超出 删除minFreq 对应的key 若存在多个 删除最旧的
    //                插入
    public void put(int key, int value) {
        // key已存在 更新值；freq+1;更新三个map
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            updateFreq(key);
            return;
        }
        if (cap == 0) {
            return;
        }
        // 判断容量超出
        // 已超出 删除minFreq 对应的key 若存在多个 删除最旧的；
        if (cap <= keyToVal.size()) {
            Set<Integer> link = freqToKeys.get(minFreq);
            int removeKey = link.iterator().next();
            keyToVal.remove(removeKey);
            keyToFreq.remove(removeKey);
            link.remove(removeKey);
        }
        // 直接插入
        keyToVal.put(key, value);
        minFreq = 1;
        addNodeForFreqList(key, 1);
    }

    private void updateFreq(int key) {
        int freq = keyToFreq.get(key);
        int newFreq = freq + 1;
        Set<Integer> link = freqToKeys.get(freq);
        link.remove(key);
        addNodeForFreqList(key, newFreq);
        if (link.size() == 0 && minFreq == freq) {
            minFreq++;
        }
    }

    // private void removeNode(Node node, int key) {
    //     if(node.key)
    // }
    private void addNodeForFreqList(int key, int newFreq) {
        keyToFreq.put(key, newFreq);
        LinkedHashSet<Integer> newLink;
        if (freqToKeys.containsKey(newFreq)) {
            newLink = freqToKeys.get(newFreq);
        }
        else {
            newLink = new LinkedHashSet<>();
        }
        newLink.add(key);
        freqToKeys.put(newFreq, newLink);
    }

    // class Node{
    //     int key;
    //     int val;
    //     Node left;
    //     Node right;
    //     public Node(int key, int val) {
    //         this.key = key;
    //         this.val = val;
    //     }
    // }

}
