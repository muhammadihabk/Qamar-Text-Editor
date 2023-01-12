package com.example.autocomplete;

public class TrieNodeTest {
    public static void main(String[] args) {
        // TrieNode newNode = new TrieNode();
        // newNode.addChar('f');
        // newNode.addChar('g');
        // newNode.addChar('h');
        // System.out.println(newNode);

        TrieDictionary dictionary = new TrieDictionary();
        // System.out.println(dictionary);
        dictionary.initialize();
        long startTime = System.nanoTime();
        for(int i = 0; i < 50; i++) {
            dictionary.getPossibleWords("s", 51000);
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9 / 50);
    }

}
