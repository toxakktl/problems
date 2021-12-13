package leetcode.linkedList.easy;

import common.ListNode;

public class P237_LinkedList {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
