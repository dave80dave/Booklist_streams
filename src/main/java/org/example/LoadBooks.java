package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadBooks {

    public List<Books> loadBooks(String booksPath){
        List<Books> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(booksPath))){
            String firstline = br.readLine();
            String line;
            while ((line = br.readLine()) != null){
                if(line.isBlank()) continue;
                String[] parts = line.split(",", -1);
                if (parts.length >= 13){
                    books.add(Books.readCSV(parts));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
