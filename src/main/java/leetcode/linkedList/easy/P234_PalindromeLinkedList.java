package leetcode.linkedList.easy;

import common.ListNode;

import java.util.Stack;

public class P234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int mid = size/2;
        Stack<ListNode> stack = new Stack<>();
        while (mid-- > 0) {
            stack.push(head);
            head = head.next;
        }
        if (size % 2 != 0) {
            head = head.next;
        }
        int midOver = size/2;
        while (midOver-- > 0) {
            ListNode node = stack.pop();
            if (node.val != head.val)
                return false;
            head = head.next;
        }
        return stack.isEmpty();

    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        while (rev != null && head != null) {
            if (rev.val != head.val)
                return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode temp = null;
        while (node != null) {
            ListNode n = new ListNode(node.val);
            n.next = temp;
            temp = n;
            node = node.next;
        }
        return temp;
    }
}
