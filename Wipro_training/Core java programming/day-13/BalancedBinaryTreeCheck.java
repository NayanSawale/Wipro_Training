package com.task;

public class BalancedBinaryTreeCheck {

static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }

    // Method to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper method to check the height of the tree and determine if it is balanced
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        // If the difference in heights is more than 1, the tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the tree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Main method to run the program
    public static void main(String[] args) {
        BalancedBinaryTreeCheck treeCheck = new BalancedBinaryTreeCheck();

        // Creating a balanced binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

		System.out.println("Is the binary tree balanced? " + treeCheck.isBalanced(root));
    }
	}

public String isBalanced(TreeNode root) {
	// TODO Auto-generated method stub
	return null;
}
}
