package com.task;

public class MergeSortedList

{
    int value;
    ListNode next;

    void ListNode(int value) {
        this.value = value;
        this.next = null;
    }

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to serve as the starting point of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the lists
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If any nodes remain in either list, link them to the end of the merged list
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list starting from the next node of the dummy
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating two sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        // Merging the lists
        ListNode mergedList = mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}
