package com.task;

import java.util.Stack;

public class StackSort {

	public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            // Step 1: Pop an element from the original stack
            int current = stack.pop();

            // Step 2: While temporary stack is not empty and top
            // of temporary stack is greater than current
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                // Pop from temporary stack and push it to the original stack
                stack.push(tempStack.pop());
            }

            // Step 3: Push current element into the temporary stack
            tempStack.push(current);
        }

        // Step 4: Transfer the sorted elements back to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }

}
