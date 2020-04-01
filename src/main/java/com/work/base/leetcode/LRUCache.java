package com.work.base.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法  双向链表存储数据，HASHmap 快速存储
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    private Map<Integer, Node> map;
    private int cap;
    private int size;
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        } else {
            Node cur = map.get(key);
            //删除原来节点
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            //插入
            cur.next = head.next;
            head.next.prev = cur;
            head.next = cur;
            cur.prev = head;
            return cur.val;
        }
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node cur = map.get(key);
            cur.val = value;
            //删除原来节点
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            //从新插入新节点
            cur.next = head.next;
            head.next.prev = cur;
            head.next = cur;
            cur.prev = head;
        } else if (size < cap) {
            Node node = new Node(key, value, head, head.next);
            head.next.prev=node;
            head.next = node;
            map.put(key, node);
            size++;
        } else {
            Node delete = tail.prev;
            tail.prev = delete.prev;
            tail.prev.next = tail;
            Node node = new Node(key, value, head, head.next);
            head.next.prev=node;
            head.next = node;

            map.remove(delete.key);
            map.put(key, node);
            delete=null;
        }
    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v, Node prev, Node next) {
        this.key = k;
        this.val = v;
        this.next = next;
        this.prev = prev;
    }

    public Node() {
    }
}
