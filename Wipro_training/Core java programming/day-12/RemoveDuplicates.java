package com.task;

public class RemoveDuplicates 
{
    int value;
    ListNode next;
    void ListNode(int value) {
        this.value = value;
        this.next = null;
    }

	 public static void removeDuplicates(ListNode head) {
	        ListNode current = head;

	        while (current != null && current.next != null) {
	            if (current.value == current.next.value) {
	                // Skip the duplicate node
	                current.next = current.next.next;
	            } else {
	                // Move to the next node
	                current = current.next;
	            }
	        }
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
	        // Creating a sorted linked list: 1 -> 1 -> 2 -> 3 -> 3
	        ListNode head = new ListNode(1);
	        head.next = new ListNode(1);
	        head.next.next = new ListNode(2);
	        head.next.next.next = new ListNode(3);
	        head.next.next.next.next = new ListNode(3);

	        System.out.println("Original List:");
	        printList(head);

	        removeDuplicates(head);

	        System.out.println("List after removing duplicates:");
	        printList(head);
	    }

}
