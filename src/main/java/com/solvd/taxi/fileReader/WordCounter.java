package com.solvd.taxi.fileReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WordCounter {
    public static void countWords(String keyWord) throws IOException {
        File inputFile = new File("src/main/resources/input.txt");
        File outputFile = new File("target/output.txt");

        String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
        StringBuilder result = new StringBuilder();

        int count = StringUtils.countMatches(content.toLowerCase(), keyWord.toLowerCase());
        result.append(keyWord).append(" --- ").append(count).append("\n");
        FileUtils.writeStringToFile(outputFile, result.toString(), StandardCharsets.UTF_8, true);
    }
}
