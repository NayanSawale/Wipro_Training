package com.task;

import java.util.Stack;

public class SequenceInStack {

	public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true; // An empty sequence is always present
        }
        
        Stack<Integer> tempStack = new Stack<>();
        int seqIndex = 0;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (current == sequence[seqIndex]) {
                seqIndex++;
                if (seqIndex == sequence.length) {
                    // All elements of the sequence matched
                    return true;
                }
            } else {
                // If not matched, reset sequence index and check the current element
                seqIndex = 0;
                // Push the elements to the temporary stack to maintain the original stack order
                tempStack.push(current);
            }
        }

        // Restore the original stack from tempStack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int[] sequence = {3, 4, 5};

        boolean result = isSequencePresent(stack, sequence);
        System.out.println("Is sequence present? " + result); // Output: Is sequence present? true
    }
}
