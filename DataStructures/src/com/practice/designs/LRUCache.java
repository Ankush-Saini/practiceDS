package com.practice.designs;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCacheImpl<K, V> {
    private LinkedList<K> order;
    private HashMap<K, V> data;
    int cacheSize;

    public LRUCacheImpl(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public V get(K key) {
        V res = data.get(key);
        if (res != null) {
            order.remove(key);
            order.addFirst(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (order.size() == cacheSize) {
            K keyToBeRemoved = order.removeLast();
            data.remove(keyToBeRemoved);
        }
        order.addFirst(key);
        data.put(key, value);
    }

    public void display() {
        System.out.println("----------------------");
        for (int i = 0; i < order.size(); i++) {
            K key = order.get(i);
            System.out.println(key + " => " + data.get(key));
        }
        System.out.println("----------------------");
    }
}

class LRUCache {
    public static void main(String[] args) {
        LRUCacheImpl<Integer, String> lruCacheImpl = new LRUCacheImpl<Integer, String>(3);
        lruCacheImpl.put(1, "Ankush");
        lruCacheImpl.put(2, "Sunandan");
        lruCacheImpl.put(3, "Arpit");
        lruCacheImpl.display();
        lruCacheImpl.get(2);
        lruCacheImpl.get(5);
        lruCacheImpl.display();
        lruCacheImpl.put(1, "Ankush Saini");
        lruCacheImpl.put(5, "Ankush A");
        lruCacheImpl.display();
    }
}