package com.task;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private static class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // Method to check if a given prefix exists in the Trie
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    // Main method to test the Trie implementation
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");

        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("appl")); // true
        System.out.println(trie.startsWith("apr")); // true
        System.out.println(trie.startsWith("bat")); // false
    }
}
