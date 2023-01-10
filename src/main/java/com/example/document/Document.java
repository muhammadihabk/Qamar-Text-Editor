package com.example.document;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {
    private String document;
    
    public Document(String document) {
        this.document = document;
    }

    public static void main(String[] args) {
        String simpleDoc = "Hello! This is Muhammad. Abc, abc abc abc.";
        Document document = new Document(simpleDoc);
        document.getFleschScore(simpleDoc);
    }

    public double getFleschScore(String document) {
        return 0;
    }

    private List<String> getTokens() {
        List<String> tokens = new LinkedList<>();
        Matcher matcher = Pattern.compile("[a-zA-Z]+|[.!?]+").matcher(document);
        while(matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }
}
