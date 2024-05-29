package com.task;

public class circularQueueBinarysaerch {
	 public static int search(int[] arr, int target) {
	        int low = 0;
	        int high = arr.length - 1;

	        while (low <= high) {
	            int mid = low + (high - low) / 2;

	            if (arr[mid] == target) {
	                return mid;
	            }

	            // If left half is sorted
	            if (arr[low] <= arr[mid]) {
	                // If target is within the left half
	                if (arr[low] <= target && target < arr[mid]) {
	                    high = mid - 1;
	                } else {
	                    low = mid + 1;
	                }
	            }
	            // If right half is sorted
	            else {
	                // If target is within the right half
	                if (arr[mid] < target && target <= arr[high]) {
	                    low = mid + 1;
	                } else {
	                    high = mid - 1;
	                }
	            }
	        }
	        return -1; // Element not found
	    }

	    public static void main(String[] args) {
	        int[] arr = {4, 5, 6, 7, 0, 1, 2};
	        int target = 0;
	        int index = search(arr, target);
	        if (index != -1) {
	            System.out.println("Element " + target + " found at index " + index);
	        } else {
	            System.out.println("Element " + target + " not found");
	        }
	    }
}
