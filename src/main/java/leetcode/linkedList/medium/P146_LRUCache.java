package leetcode.linkedList.medium;

import java.util.HashMap;
import java.util.Map;

public class P146_LRUCache {

    private Node head = new Node(), tail = new Node();
    private Map<Integer, Node> cache;
    private int capacity;

    public P146_LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        Node node = cache.get(key);
        if (node != null) {
            res = node.value;
            remove(node);
            add(node);
        }
        return res;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            add(newNode);
        }
    }

    public void add(Node node) {

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;


    }

    public void remove(Node node) {

        Node nodeNext = node.next;
        Node nodePrev = node.prev;

        nodeNext.prev = nodePrev;
        nodePrev.next  = nodeNext;

    }


    class Node {
        int key, value;
        Node prev, next;
    }
}
