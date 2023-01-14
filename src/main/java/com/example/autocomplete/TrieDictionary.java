package com.example.autocomplete;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TrieDictionary {
    TrieNode root;

    public TrieDictionary() {
        root = new TrieNode();
    }

    public void initialize() {
        String file = "src/main/resources/com/example/data/words.txt";
        Path path = Paths.get(file);
        try(BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String word;
            while((word = bufferedReader.readLine()) != null) {
                addWord(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addWord(String word) {
        word = word.toLowerCase();
        int currentWordIdx = 0;
        TrieNode currentNode = root;
        while(currentWordIdx < word.length()
            && currentNode.getChild(word.charAt(currentWordIdx)) != null) {
                currentNode = currentNode.getChild(word.charAt(currentWordIdx++));
        }
        if(currentWordIdx == word.length()) {
            currentNode.setIsWord(true);
        }
        if(currentWordIdx < word.length()) {
            while(currentWordIdx < word.length()) {
                currentNode = currentNode.addChar(word.charAt(currentWordIdx++));
            }
            currentNode.setIsWord(true);
        }
    }

    public List<String> getPossibleWords(String prefix, int countWords) {
        List<String> answer = new LinkedList<String>();
        if(prefix.length() == 0) {
            return answer;
        }
        int countSoFar = 0;
        int currentWordIdx = 0;
        prefix = prefix.toLowerCase();
        TrieNode currentNode = root;
        while(currentWordIdx < prefix.length()
            && currentNode.getChild(prefix.charAt(currentWordIdx)) != null) {
                currentNode = currentNode.getChild(prefix.charAt(currentWordIdx++));
        }
        if(currentWordIdx < prefix.length()) {
            return answer;
        }
        if(currentWordIdx == prefix.length() && currentNode.isWord()) {
            answer.add(prefix);
            countSoFar++;
        }
        Queue<TrieNode> queue = new LinkedList<>();
        for(TrieNode node : currentNode.getFollowingChars().values()) {
            queue.add(node);
        }
        while(countSoFar < countWords && !queue.isEmpty()) {
            currentNode = queue.remove();
            if(currentNode.isWord()) {
                answer.add(currentNode.getText());
                countSoFar++;
            }
            for(TrieNode node : currentNode.getFollowingChars().values()) {
                queue.add(node);
            }   
        }
        return answer;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        TrieNode currentNode = root;
        Queue<TrieNode> queue = new LinkedList<>();
        for(TrieNode node : currentNode.getFollowingChars().values()) {
            queue.add(node);
        }
        answer.append(currentNode);
        while(queue.size() != 0) {
            currentNode = queue.remove();
            answer.append("\n" + currentNode);
            for(TrieNode node : currentNode.getFollowingChars().values()) {
                queue.add(node);
            }
        }
        return answer.toString();
    }
}
