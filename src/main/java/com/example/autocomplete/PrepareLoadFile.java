package com.example.autocomplete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PrepareLoadFile {
    public static void main(String[] args) {
        PrepareLoadFile.prepare();
    }
    public static void prepare() {
        Path readPath = Paths.get("src/main/resources/com/example/data/words.txt");
        Path writePath = Paths.get("src/main/resources/com/example/data/toLowercase.txt");
        try(
            BufferedReader bufferedReader = Files.newBufferedReader(readPath);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(writePath)
        ) {
            String word;
            while((word = bufferedReader.readLine()) != null) {
                bufferedWriter.write(word.toLowerCase() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
