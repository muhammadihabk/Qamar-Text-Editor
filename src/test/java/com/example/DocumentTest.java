package com.example;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.document.Document;

public class DocumentTest {
    private Document document;
    private String simpleDoc;

    @BeforeEach
    public void setup() {
        document = new Document(simpleDoc);
        simpleDoc = "Hello! This is Muhammad. Abc, abc abc abc.";
    }

    @Test
    public void getNumWordsAndSentences() {
    }
}
