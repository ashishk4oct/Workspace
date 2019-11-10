package com.java.examples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileExample {
    public static void main(String[] args) {
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("D:\\workspace\\intelliJ\\Workspace\\Java8\\src\\test.text"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(l -> Arrays.stream(l.split(" "))).distinct().count();
        }catch(IOException e){
            e.printStackTrace();;
        }
        System.out.println(uniqueWords);
    }
}
