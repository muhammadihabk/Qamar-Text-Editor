package com.example.autocomplete;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> followingChars;
    private String text;
    private boolean isWord;

    public TrieNode() {
        followingChars = new HashMap<>();
        text = "";
    }

    public HashMap<Character, TrieNode> getFollowingChars() {
        return followingChars;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public TrieNode getChild(Character c) {
        if(followingChars.containsKey(c)) {
            return followingChars.get(c);
        } else {
            return null;
        }
    }

    public TrieNode addChar(Character c) {
        c = Character.toLowerCase(c);
        if(followingChars.containsKey(c)) {
            return this;
        } else {
            TrieNode newNode = new TrieNode();
            newNode.setText(text + c);
            followingChars.put(c, newNode);
            return newNode;
        }
    }

    @Override
    public String toString() {
        return "[" + followingChars.keySet() + ", " + text + ", isWord: " + isWord + "]";
    }
}
