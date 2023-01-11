package com.example.generate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TextGenerator {
    private String text;
    private Random randomNumGenerator;
    private HashMap<String, List<String>> trainedWords;
    private String startWord;

    public TextGenerator(String text) {
        this.text = text;
        randomNumGenerator = new Random();
        trainedWords = new HashMap<>();
    }

    public void trainModel() {
        String[] tokens = text.split(" ");
        for(int i = 0; i < tokens.length - 1; i++) {
            if(trainedWords.containsKey(tokens[i])) {
                trainedWords.get(tokens[i]).add(tokens[i + 1]);
            } else {
                List<String> list = new LinkedList<>();
                list.add(tokens[i + 1]);
                trainedWords.put(tokens[i], list);
            }
        }
        List<String> list = new LinkedList<>();
        list.add(tokens[0]);
        trainedWords.put(tokens[tokens.length - 1], list);
        startWord = tokens[0];
    }

    public String generate(int countWords) {
        StringBuilder answer = new StringBuilder();
        String prevWord = startWord;
        answer.append(prevWord);
        int countSoFar = 0;
        while(countSoFar < countWords) {
            List<String> prevWordFollowers = trainedWords.get(prevWord);
            prevWord = prevWordFollowers.get(randomNumGenerator.nextInt(prevWordFollowers.size()));
            answer.append(" " + prevWord);
            countSoFar++;
        }
        return answer.toString();
    }
}
