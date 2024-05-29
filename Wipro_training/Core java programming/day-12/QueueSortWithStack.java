package com.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueSortWithStack {

	public static void sortQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        while (!isSorted(queue)) {
            int min = Integer.MAX_VALUE;
            int size = queue.size();

            // Find the minimum element in the queue
            for (int i = 0; i < size; i++) {
                int element = queue.poll();
                if (element < min) {
                    min = element;
                }
                stack.push(element);
            }

            // Move elements back to the queue, skipping the minimum element
            boolean minAdded = false;
            for (int i = 0; i < size; i++) {
                int element = stack.pop();
                if (element == min && !minAdded) {
                    minAdded = true;
                    continue;
                }
                queue.add(element);
            }

            // Add the minimum element to the end of the queue
            queue.add(min);
        }
    }
    
    // Helper method to check if the queue is sorted
    private static boolean isSorted(Queue<Integer> queue) {
        int prev = Integer.MIN_VALUE;
        for (int element : queue) {
            if (element < prev) {
                return false;
            }
            prev = element;
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        queue.add(1);
        queue.add(3);
        queue.add(2);

        System.out.println("Original Queue: " + queue);
        sortQueue(queue);
        System.out.println("Sorted Queue: " + queue);
    }
}
