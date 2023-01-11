package com.example.generate;

public class TextGeneratorTest {
    public static void main(String[] args) {
        String example1 = "This is a laptop. This is cool. This is room. laptop is neat. This is a test. Model is being trained";
        TextGenerator textGenerator = new TextGenerator(example1);
        textGenerator.trainModel();
        // System.out.println(textGenerator.trainedWords);
        String generated = textGenerator.generate(50);
        System.out.println(generated);
    }
}
