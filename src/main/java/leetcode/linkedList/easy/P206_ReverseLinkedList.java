package leetcode.linkedList.easy;

import common.ListNode;

public class P206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode node;
        ListNode temp = null;
        while (head != null) {
            node = new ListNode(head.val);
            node.next = temp;
            temp = node;
            head = head.next;
        }
        return temp;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            nextNode.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }


    //1,  temp  2,



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        reverseList(head);

    }
}
