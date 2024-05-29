package com.task;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Method to insert a new element into the heap
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Method to fetch the minimum element (root of the heap)
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Method to delete the minimum element (root of the heap)
    public int deleteMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return min;
    }

    // Helper method to maintain the heap property after insertion
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) >= heap.get(parentIndex)) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // Helper method to maintain the heap property after deletion
    private void heapifyDown(int index) {
        int lastIndex = heap.size() - 1;
        while (index < lastIndex) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex > lastIndex) break;

            int smallerChildIndex = leftChildIndex;
            if (rightChildIndex <= lastIndex && heap.get(rightChildIndex) < heap.get(leftChildIndex)) {
                smallerChildIndex = rightChildIndex;
            }

            if (heap.get(index) <= heap.get(smallerChildIndex)) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    // Helper method to swap elements at two indices
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Main method to test the MinHeap implementation
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(2);

        System.out.println("Min element: " + minHeap.getMin()); // 2
        System.out.println("Deleting Min element: " + minHeap.deleteMin()); // 2
        System.out.println("New Min element: " + minHeap.getMin()); // 5
        System.out.println("Deleting Min element: " + minHeap.deleteMin()); // 5
        System.out.println("New Min element: " + minHeap.getMin()); // 10
    }
}

