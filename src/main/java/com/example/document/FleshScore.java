package com.example.document;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FleshScore {
    private String text;
    private int wordsCount = 0;
    private int sentencesCount = 0;
    private int syllablesCount = 0;
    
    public FleshScore(String text) {
        this.text = text;
    }

    public double getFleschScore() {
        List<String> tokens = getTokens();
        for(String token : tokens) {
            if(isWord(token)) {
                wordsCount++;
            } else {
                sentencesCount++;
            }
            syllablesCount += countSyllables(token);
        }
        if(isWord(tokens.get(tokens.size() - 1))) {
            sentencesCount++;
        }
        
        return 206.835 - 1.015 * ((double) wordsCount / sentencesCount) - 84.6 * ((double) syllablesCount / wordsCount);
    }

    public void setText(String text) {
        this.text = text;
        wordsCount = 0;
        sentencesCount = 0;
        syllablesCount = 0;
    }

    private int countSyllables(String word) {
        word = word.toLowerCase();
        String characters = "aeiouy";
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if(characters.contains(String.valueOf(word.charAt(i)))) {
                while(i < word.length() && characters.contains(String.valueOf(word.charAt(i)))) { i++; }
                count++;
            }
        }
        if(word.charAt(word.length() - 1) == 'e') {
            if(count == 1) {
                return 1;
            } else {
                count--;
            }
        }
        return count;
    }

    private List<String> getTokens() {
        List<String> tokens = new LinkedList<>();
        Matcher matcher = Pattern.compile("[a-zA-Z]+|[.!?]+").matcher(text);
        while(matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    private boolean isWord(String text) {
        return ".!?".indexOf(text.charAt(0)) == -1;
    }
}
