package com.example;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.document.FleshScore;

public class DocumentTest {
    private FleshScore document;
    private String simpleDoc;
    private String simpleDoc_2;
    private String syllablesEndsE_1;
    private String syllablesEndsE_2;
    private String syllablesContinous_1;
    private String syllablesContinous_2;

    @BeforeEach
    public void setup() {
        document = new FleshScore(simpleDoc);
        simpleDoc = "Hello!!! This is Muhammad... Abc, abc abc abc.";
        simpleDoc_2 = "Hello!!! This is Muhammad... Abc, abc abc abc";
        syllablesEndsE_1 = "the";
        syllablesEndsE_2 = "plane";
        syllablesContinous_1 = "bean";
        syllablesContinous_2 = "heelloo";

    }

    @Test
    public void countWordsSentencesAndSyllables() {
        // document.setText(simpleDoc);
        // document.getFleschScore();
        // assertEquals(8, document.getWordsCount(), "Count of words");
        // assertEquals(3, document.getSentencesCount(), "Count of sentences");
        // assertEquals(11, document.getSyllablesCount(), "Count of syllables");
        
        // document.setText(simpleDoc_2);
        // document.getFleschScore();
        // assertEquals(8, document.getWordsCount(), "Count of words");
        // assertEquals(3, document.getSentencesCount(), "Count of sentences");
        // assertEquals(11, document.getSyllablesCount(), "Count of syllables");
    }
    
    @Test
    public void countSyllables() {
        // assertEquals(1, document.countSyllables(syllablesEndsE_1), "Syllables");
        // assertEquals(1, document.countSyllables(syllablesEndsE_2), "Syllables");
        // assertEquals(1, document.countSyllables(syllablesContinous_1), "Syllables");
        // assertEquals(2, document.countSyllables(syllablesContinous_2), "Syllables");
    }
}
