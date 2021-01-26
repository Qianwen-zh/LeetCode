package leetcode.structure;

import java.util.LinkedHashMap;
// 146 LRU»º´æ
// 3.1
//https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-she-ji-shu-ju-jie-gou/lru-suan-fa
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
        if(cache.size()>=cap){
            int firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, value);
    }
}

